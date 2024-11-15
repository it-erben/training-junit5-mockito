package com.iterben.captorannotation;

import com.iterben.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DemoCaptorAnnotationTest {

    @Mock
    PaymentService paymentService;

    @Mock
    NotificationService notificationService;

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    @Captor
    ArgumentCaptor<String> emailCaptor;

    @Test
    void testProcessOrder_SuccessfulPayment() {
        Order testOrder = new Order();
        testOrder.setId(1L);
        testOrder.setCustomerEmail("test@example.com");
        testOrder.setAmount(100.00);
        testOrder.setStatus(OrderStatus.PENDING);

        // Define the behavior of the mocked PaymentService to return true for successful payment
        when(paymentService.charge(testOrder)).thenReturn(true);

        // Call the method under test
        orderService.processOrder(testOrder);

        verify(notificationService).notifyCustomer(emailCaptor.capture());
        assertEquals(testOrder.getCustomerEmail(), emailCaptor.getValue());
    }

}
