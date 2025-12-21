package tech.erben.mockannotation;

import tech.erben.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DemoMockAnnotationTest {

    @Mock
    PaymentService paymentService;

    @Mock
    NotificationService notificationService;

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    @Test
    void testProcessOrderSuccessfulPayment() {
        Order testOrder = new Order();
        testOrder.setId(1L);
        testOrder.setCustomerEmail("test@example.com");
        testOrder.setAmount(100.00);
        testOrder.setStatus(OrderStatus.PENDING);

        // Define the behavior of the mocked PaymentService to return true for successful payment
        when(paymentService.charge(testOrder)).thenReturn(true);

        // Call the method under test
        Order processedOrder = orderService.processOrder(testOrder);

        // Verify interactions and assertions
        assertEquals(OrderStatus.COMPLETED, processedOrder.getStatus());
        verify(orderRepository).save(testOrder);
        verify(notificationService).notifyCustomer(testOrder.getCustomerEmail());
    }

}
