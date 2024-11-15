package com.iterben.advanced.ordering;

import com.iterben.fibonacci.BinetFibonacci;
import com.iterben.fibonacci.Fibonacci;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Ordered Tests for Fibonacci Calculation")
class DemoOrderingTest {

    private final Fibonacci fibonacci = new BinetFibonacci();

    /**
     * Random ordering of test methods
     */
    @Nested
    @TestMethodOrder(MethodOrderer.Random.class)
    @DisplayName("Fibonacci Tests with Random Order")
    class RandomOrderTests {

        @Test
        @DisplayName("Fibonacci of 5")
        void testFibonacciOf5() {
            assertEquals(5, fibonacci.fibonacci(5), "Expected Fibonacci of 5 to be 5");
        }

        @Test
        @DisplayName("Fibonacci of 10")
        void testFibonacciOf10() {
            assertEquals(55, fibonacci.fibonacci(10), "Expected Fibonacci of 10 to be 55");
        }

        @Test
        @DisplayName("Fibonacci of 15")
        void testFibonacciOf15() {
            assertEquals(610, fibonacci.fibonacci(15), "Expected Fibonacci of 15 to be 610");
        }
    }

    /**
     * Order by method name in ascending alphabetical order
     */
    @Nested
    @TestMethodOrder(MethodOrderer.MethodName.class)
    @DisplayName("Fibonacci Tests Ordered by Method Name")
    class MethodNameOrderTests {

        @Test
        @DisplayName("Fibonacci of 15")
        void atestFibonacciOf15() {
            assertEquals(610, fibonacci.fibonacci(15), "Expected Fibonacci of 15 to be 610");
        }

        @Test
        @DisplayName("Fibonacci of 5")
        void btestFibonacciOf5() {
            assertEquals(5, fibonacci.fibonacci(5), "Expected Fibonacci of 5 to be 5");
        }

        @Test
        @DisplayName("Fibonacci of 10")
        void ctestFibonacciOf10() {
            assertEquals(55, fibonacci.fibonacci(10), "Expected Fibonacci of 10 to be 55");
        }
    }

    /**
     * Custom order using @Order annotation with MethodOrderer.OrderAnnotation
     */
    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Fibonacci Tests Ordered by Custom Order Index")
    class CustomOrderTests {

        @Test
        @Order(2)
        @DisplayName("Fibonacci of 10")
        void testFibonacciOf10() {
            assertEquals(55, fibonacci.fibonacci(10), "Expected Fibonacci of 10 to be 55");
        }

        @Test
        @Order(3)
        @DisplayName("Fibonacci of 15")
        void testFibonacciOf15() {
            assertEquals(610, fibonacci.fibonacci(15), "Expected Fibonacci of 15 to be 610");
        }

        @Test
        @Order(1)
        @DisplayName("Fibonacci of 5")
        void testFibonacciOf5() {
            assertEquals(5, fibonacci.fibonacci(5), "Expected Fibonacci of 5 to be 5");
        }
    }
}
