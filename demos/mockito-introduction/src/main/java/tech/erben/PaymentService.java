package tech.erben;

public interface PaymentService {
    boolean charge(Order order);
    void refund(Order order);
}
