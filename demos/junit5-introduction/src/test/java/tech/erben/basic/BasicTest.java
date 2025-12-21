package tech.erben.basic;

import tech.erben.fibonacci.BinetFibonacci;
import tech.erben.fibonacci.Fibonacci;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Fibonacci interface.
 */
@DisplayName("Fibonacci Interface Unit Tests")
public class BasicTest {

    private Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new BinetFibonacci();
    }

    @AfterEach
    void tearDown() {
        fibonacci = null;
    }

    @Test
    @DisplayName("Calculate Fibonacci for index 1")
    void testFibonacciOne() {
        assertEquals(1, fibonacci.fibonacci(1), "Expected Fibonacci of 1 to be 1");
    }

    @Test
    @DisplayName("Calculate Fibonacci for a small positive index")
    void testFibonacciSmallIndex() {
        assertEquals(8, fibonacci.fibonacci(6), () -> "Expected Fibonacci of 6 to be 8, got " + fibonacci.fibonacci(6));
    }

    @Test
    @DisplayName("Calculate Fibonacci for a medium positive index")
    void testFibonacciMediumIndex() {
        assertEquals(55, fibonacci.fibonacci(10),
            () -> "Expected Fibonacci of 10 to be 55, got " + fibonacci.fibonacci(10));
    }

    @Test
    @DisplayName("Calculate Fibonacci for a larger positive index")
    void testFibonacciLargeIndex() {
        assertEquals(6765, fibonacci.fibonacci(20),
            () -> "Expected Fibonacci of 20 to be 6765, got " + fibonacci.fibonacci(20));
    }

    @Test
    @Disabled("Pending optimized implementation for large index calculations")
    @DisplayName("Calculate Fibonacci for very large index (disabled test)")
    void testFibonacciVeryLargeIndex() {
        assertEquals(0, fibonacci.fibonacci(1000), "This test is currently disabled and should not run.");
    }

    @Test
    @DisplayName("Lazy assert message example for Fibonacci calculation")
    void testLazyAssertMessage() {
        assertEquals(21, fibonacci.fibonacci(8),
            () -> "Expected Fibonacci of 8 to be 21, but got " + fibonacci.fibonacci(8));
    }

    @Nested
    @DisplayName("Boundary Value Tests")
    class BoundaryValueTests {


        @Test
        @DisplayName("Fibonacci for a negative index throws IllegalArgumentException")
        void testFibonacciNegativeIndex() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                fibonacci.fibonacci(-1);
            });
            assertEquals("Index cannot be negative", exception.getMessage(),
                "Expected specific error message for negative index");
        }


        @Test
        @DisplayName("Fibonacci for a zero index does not throw IllegalArgumentException")
        void testFibonacciZeroIndex() {
            assertDoesNotThrow(() -> fibonacci.fibonacci(0));
        }
    }
}
