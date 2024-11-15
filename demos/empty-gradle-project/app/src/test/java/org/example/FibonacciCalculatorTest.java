package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FibonacciCalculatorTest {

    @Test
    void shouldThrowIllegalArgumentExceptionOnMinus1() {
        assertThrows(IllegalArgumentException.class, () -> new FibonacciCalculator().fibonacci(-1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionOnMinus2() {
        assertThrows(IllegalArgumentException.class, () -> new FibonacciCalculator().fibonacci(-2));
    }
}
