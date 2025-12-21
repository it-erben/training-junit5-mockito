package tech.erben;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    Optional<Order> findById(Long orderId);
    void updateStatus(Long orderId, OrderStatus status);
    List<Order> findByCustomerEmail(String email);
}
