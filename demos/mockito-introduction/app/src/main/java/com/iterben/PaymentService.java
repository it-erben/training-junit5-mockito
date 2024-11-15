package com.iterben;

public interface PaymentService {
    boolean charge(Order order);
    void refund(Order order);
}
