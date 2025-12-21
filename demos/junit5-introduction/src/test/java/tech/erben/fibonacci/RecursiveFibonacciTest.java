package tech.erben.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveFibonacciTest {

    private final RecursiveFibonacci calculator = new RecursiveFibonacci();

    /**
     * The DisplayName annotation changes the name of the test rendered in your IDE or test result pages
     */
    @Test
    @DisplayName("fibonacci(0) should return 0")
    void whenInputIsZero_thenReturnZero() {
        assertEquals(0, calculator.fibonacci(0));
    }

    @Test
    @DisplayName("fibonacci(1) should return 1")
    void whenInputIsOne_thenReturnOne() {
        assertEquals(1, calculator.fibonacci(1));
    }

    @Test
    @DisplayName("fibonacci(2) should return 1")
    void whenInputIsTwo_thenReturnOne() {
        assertEquals(1, calculator.fibonacci(2));
    }

    @Test
    @DisplayName("Test basic fibonacci sequence numbers")
    void testBasicSequence() {
        assertEquals(2, calculator.fibonacci(3));
        assertEquals(3, calculator.fibonacci(4));
        assertEquals(5, calculator.fibonacci(5));
        assertEquals(8, calculator.fibonacci(6));
        assertEquals(13, calculator.fibonacci(7));
    }

    @Test
    @DisplayName("Test medium sized fibonacci numbers")
    void testMediumNumbers() {
        assertEquals(21, calculator.fibonacci(8));
        assertEquals(34, calculator.fibonacci(9));
        assertEquals(55, calculator.fibonacci(10));
        assertEquals(89, calculator.fibonacci(11));
    }

    /**
     * Other than in JUnit 4, exceptions are expected by using a lambda expression.
     * The captured exception can be used for further assertions.
     */
    @Test
    @DisplayName("Negative input should throw IllegalArgumentException")
    void whenInputIsNegative_thenThrowException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.fibonacci(-1)
        );
        assertEquals("Index cannot be negative", exception.getMessage());
    }
}
