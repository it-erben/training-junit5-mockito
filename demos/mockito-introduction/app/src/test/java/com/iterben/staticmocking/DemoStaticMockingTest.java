package com.iterben.staticmocking;

import com.iterben.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
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
class DemoStaticMockingTest {

    @Test
    void testStaticMethodMocking() {
        try (MockedStatic<StaticMethodExample> mockedStatic = mockStatic(StaticMethodExample.class)) {
            mockedStatic.when(StaticMethodExample::staticMethod).thenReturn("Mocked Value");

            // Test und verifiziere
            String result = StaticMethodExample.staticMethod();
            System.out.println(result); // Ausgabe: Mocked Value
            assertEquals("Mocked Value", result);

            mockedStatic.verify(StaticMethodExample::staticMethod, times(1));
        }
    }

}

class StaticMethodExample {
    public static String staticMethod() {
        return "Original Value";
    }
}
