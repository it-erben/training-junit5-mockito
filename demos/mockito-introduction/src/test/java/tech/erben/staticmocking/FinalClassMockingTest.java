package tech.erben.staticmocking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

final class FinalClass {
    public String getMessage() {
        return "Original Message";
    }
}

public class FinalClassMockingTest {

    @Test
    void testFinalClassMocking() {
        FinalClass finalClassMock = mock(FinalClass.class);
        when(finalClassMock.getMessage()).thenReturn("Mocked Message");

        String result = finalClassMock.getMessage();
        System.out.println(result); // Ausgabe: Mocked Message
        assertEquals("Mocked Message", result);
    }
}
