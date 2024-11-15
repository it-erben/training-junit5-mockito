package com.iterben;

public interface NotificationService {
    void notifyCustomer(String email);
    void notifyAdmin(String message);
    boolean notifyCustomerWithMessage(String email, String message);
}
