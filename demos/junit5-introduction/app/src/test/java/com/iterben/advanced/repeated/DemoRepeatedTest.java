package com.iterben.advanced.repeated;

import com.iterben.fibonacci.BinetFibonacci;
import com.iterben.fibonacci.Fibonacci;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Repeated Tests for Fibonacci Calculation")
public class DemoRepeatedTest {

    private final Fibonacci fibonacci = new BinetFibonacci();

    /**
     * Basic repeated test to validate Fibonacci calculation consistency.
     */
    @RepeatedTest(5)
    @DisplayName("Basic repeated test for Fibonacci index 5")
    void basicRepeatedFibonacciTest() {
        assertEquals(5, fibonacci.fibonacci(5), "Expected Fibonacci of 5 to consistently be 5");
    }

    /**
     * Repeated test with custom display name showing current repetition number.
     */
    @RepeatedTest(value = 3, name = "{displayName} :: repetition {currentRepetition} of {totalRepetitions}")
    @DisplayName("Custom Display Name Fibonacci Test")
    void customDisplayNameRepeatedTest() {
        assertEquals(21, fibonacci.fibonacci(8), "Expected Fibonacci of 8 to be 21");
    }

    /**
     * Repeated test with access to repetition information (index and total repetitions).
     */
    @RepeatedTest(4)
    @DisplayName("Fibonacci Test with RepetitionInfo")
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        int repetition = repetitionInfo.getCurrentRepetition();
        int index = 5 + repetition;  // Testing Fibonacci for indices 6, 7, 8, and 9
        long[] expectedResults = {8, 13, 21, 34};

        assertEquals(expectedResults[repetition - 1], fibonacci.fibonacci(index),
            () -> "Expected Fibonacci of " + index + " to be " + expectedResults[repetition - 1] +
                " in repetition " + repetition);
    }
}
