package tech.erben.staticmocking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FinalMethodClass {
    public final String finalMethod() {
        return "Original Final Method";
    }
}

public class FinalMethodMockingTest {

    @Test
    void testFinalMethodMocking() {
        FinalMethodClass finalMethodMock = mock(FinalMethodClass.class);
        when(finalMethodMock.finalMethod()).thenReturn("Mocked Final Method");

        String result = finalMethodMock.finalMethod();
        System.out.println(result); // Ausgabe: Mocked Final Method
        assertEquals("Mocked Final Method", result);
    }
}
