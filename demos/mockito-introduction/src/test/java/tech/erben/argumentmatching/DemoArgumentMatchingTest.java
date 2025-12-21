package tech.erben.argumentmatching;

import tech.erben.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;
import org.mockito.exceptions.misusing.UnfinishedStubbingException;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DemoArgumentMatchingTest {

    @Mock
    PaymentService paymentService;

    @Mock
    NotificationService notificationService;

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    @Spy
    OrderService orderService;

    @Test
    void exactArgumentMatching() {
        doReturn(OrderStatus.PENDING).when(orderService).getOrderStatus(0L);
        doReturn(OrderStatus.COMPLETED).when(orderService).getOrderStatus(1L);
        assertEquals(OrderStatus.PENDING, orderService.getOrderStatus(0L));
        assertEquals(OrderStatus.COMPLETED, orderService.getOrderStatus(1L));
    }

    @Test
    void anyMatching() {
        doReturn(OrderStatus.PENDING).when(orderService).getOrderStatus(Mockito.any());
        assertEquals(OrderStatus.PENDING, orderService.getOrderStatus(0L));
        assertEquals(OrderStatus.PENDING, orderService.getOrderStatus(1L));
    }

    @Test
    void mixedArgumentMatchingFails() {
        Assertions.assertThrows(InvalidUseOfMatchersException.class, () -> {
            when(notificationService.notifyCustomerWithMessage(Mockito.anyString(),"mymessage")).thenReturn(true);
        });
        when(notificationService.notifyCustomerWithMessage(Mockito.anyString(),Mockito.eq("mymessage"))).thenReturn(true);
        notificationService.notifyCustomerWithMessage("a@b.de", "mymessage");
        verify(notificationService).notifyCustomerWithMessage("a@b.de", "mymessage");
    }

    @Test
    void orArgumentMatcher() {
        doReturn(OrderStatus.PENDING).when(orderService).getOrderStatus(or(Mockito.eq(1L), Mockito.eq(2L)));
        assertEquals(OrderStatus.PENDING, orderService.getOrderStatus(1L));
        assertEquals(OrderStatus.PENDING, orderService.getOrderStatus(2L));
        assertThrows(IllegalArgumentException.class, () -> orderService.getOrderStatus(3L));
    }

    @Test
    void customArgumentMatcher() {
        doReturn(OrderStatus.PENDING).when(orderService).getOrderStatus(Mockito.argThat(value -> value % 2 == 0)); // expand the argument to illustrate
        doReturn(OrderStatus.COMPLETED).when(orderService).getOrderStatus(Mockito.argThat(value -> value % 2 == 1));

        assertEquals(OrderStatus.PENDING, orderService.getOrderStatus(2L));
        assertEquals(OrderStatus.COMPLETED, orderService.getOrderStatus(1L));
    }

}
