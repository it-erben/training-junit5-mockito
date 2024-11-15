package com.iterben.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleFibonacciTest {

    private final RecursiveFibonacci calculator = new RecursiveFibonacci();

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

}
