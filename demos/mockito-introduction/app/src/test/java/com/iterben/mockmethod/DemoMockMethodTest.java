package com.iterben.mockmethod;

import com.iterben.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.TooFewActualInvocations;
import org.mockito.exceptions.verification.WantedButNotInvoked;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DemoMockMethodTest {


    @BeforeEach
    void setUp() {

    }

    @Test
    void testProcessOrderSuccessfulPayment() {
        Order testOrder = new Order();
        testOrder.setId(1L);
        testOrder.setCustomerEmail("test@example.com");
        testOrder.setAmount(100.00);
        testOrder.setStatus(OrderStatus.PENDING);

        PaymentService paymentService = Mockito.mock(PaymentService.class);
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        NotificationService notificationService = Mockito.mock(NotificationService.class);

        OrderService orderService = new OrderService(orderRepository, paymentService, notificationService);

        // Define the behavior of the mocked PaymentService to return true for successful payment
        when(paymentService.charge(testOrder)).thenReturn(true);

        // Call the method under test
        Order processedOrder = orderService.processOrder(testOrder);

        // Verify interactions and assertions
        assertEquals(OrderStatus.COMPLETED, processedOrder.getStatus());
        verify(orderRepository).save(testOrder);
        verify(notificationService).notifyCustomer(testOrder.getCustomerEmail());
    }

    @Test
    void assertNoInvocationFailure() {
        @SuppressWarnings("unchecked")
        List<String> listMock = (List<String>) Mockito.mock(List.class);
        assertThrows(WantedButNotInvoked.class,
            () -> verify(listMock, times(2)).add(anyString())
        );
    }

    @Test
    void assertTwoInvocationsFailure() {
        @SuppressWarnings("unchecked")
        List<String> listMock = (List<String>) Mockito.mock(List.class);
        listMock.add("test");
        assertThrows(TooFewActualInvocations.class,
            () -> verify(listMock, times(2)).add(anyString())
        );
    }

    @Test
    void mockWithAnswer() {
        @SuppressWarnings("unchecked") List<String> listMock = (List<String>) mock(List.class, new CustomAnswer());
        boolean added = listMock.add("test");
        verify(listMock).add(anyString());
        assertFalse(added);
        assertThrows(ClassCastException.class, () -> {
            String s = listMock.get(0);
        });
    }

    @Test
    void spyMethod() {
        List<Object> spy = spy(new ArrayList<>());
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> when(spy.get(0)).thenReturn("test")
        ); // will fail as the initial real method call fails
        doReturn("test").when(spy).get(0);
        spy.add("foo");
        assertEquals("test", spy.get(0));
    }

    @Test
    void voidMethodMocking() {
        NotificationService notificationService = Mockito.mock(NotificationService.class);

        // Mit doNothing()
        doNothing().when(notificationService).notifyAdmin("mymessage");
        notificationService.notifyAdmin("mymessage");
        verify(notificationService).notifyAdmin("mymessage");

        // Mit doAnswer()
        doAnswer(invocationOnMock -> null).when(notificationService).notifyCustomer(anyString());
        notificationService.notifyCustomer("mymessage");
        verify(notificationService).notifyCustomer("mymessage");
    }

    @Test
    void sequentialMethodMocking() {
        PaymentService paymentService = Mockito.mock(PaymentService.class);

        doNothing().doThrow(new IllegalStateException())
            .when(paymentService).refund(any());

        Order order = new Order();
        paymentService.refund(order);

        assertThrows(IllegalStateException.class, () -> {
            paymentService.refund(order);
        });
    }

    static class CustomAnswer implements Answer<Boolean> {

        @Override
        public Boolean answer(InvocationOnMock invocation) throws Throwable {
            return false;
        }
    }



}
