package com.iterben.fibonacci;

import org.junit.jupiter.api.*;

class NonIndependentTest {

    private final RecursiveFibonacci calculator = new RecursiveFibonacci();

    private int index = 1;

    @Test
    public void firstTest() {
        Assertions.assertEquals(1, calculator.fibonacci(index));
        index++;
    }


    @Test
    public void secondTest() {
        Assertions.assertEquals(1, calculator.fibonacci(index));
        index++;
    }

    @Test
    @Disabled("would fail")
    public void thirdTest() {
        Assertions.assertEquals(2, calculator.fibonacci(index));
        index++;
    }

}
