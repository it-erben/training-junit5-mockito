package com.iterben;

import java.util.List;
import java.util.Optional;

public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public OrderService(OrderRepository orderRepository, PaymentService paymentService, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    public Order processOrder(Order order) {
        orderRepository.save(order);
        if (paymentService.charge(order)) {
            order.setStatus(OrderStatus.COMPLETED);
            notificationService.notifyCustomer(order.getCustomerEmail());
        } else {
            order.setStatus(OrderStatus.PENDING);
            notificationService.notifyAdmin("Payment failed for order: " + order.getId());
        }
        return order;
    }

    public boolean cancelOrder(Long orderId) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            if (order.getStatus() == OrderStatus.COMPLETED) {
                paymentService.refund(order);
            }
            order.setStatus(OrderStatus.CANCELLED);
            orderRepository.updateStatus(orderId, OrderStatus.CANCELLED);
            notificationService.notifyCustomer(order.getCustomerEmail());
            return true;
        }
        return false;
    }

    public OrderStatus getOrderStatus(Long orderId) {
        return orderRepository.findById(orderId)
                              .map(Order::getStatus)
                              .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    public List<Order> findOrdersByCustomer(String email) {
        return orderRepository.findByCustomerEmail(email);
    }

    public void refundOrder(Long orderId) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent() && orderOpt.get().getStatus() == OrderStatus.COMPLETED) {
            paymentService.refund(orderOpt.get());
            orderOpt.get().setStatus(OrderStatus.REFUNDED);
            orderRepository.updateStatus(orderId, OrderStatus.REFUNDED);
            notificationService.notifyCustomer(orderOpt.get().getCustomerEmail());
        } else {
            throw new IllegalStateException("Order is not eligible for refund");
        }
    }
}
