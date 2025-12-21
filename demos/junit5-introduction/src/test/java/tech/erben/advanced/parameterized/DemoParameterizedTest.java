package tech.erben.advanced.parameterized;

import tech.erben.fibonacci.BinetFibonacci;
import tech.erben.fibonacci.Fibonacci;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

@DisplayName("Parameterized Tests for Fibonacci Calculation")
class DemoParameterizedTest {

    private final Fibonacci fibonacci = new BinetFibonacci();

    @ParameterizedTest
    @DisplayName("Fibonacci calculation with ValueSource for small indexes")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void testFibonacciWithSmallIndexes(int index) {
        long[] expectedResults = {0, 1, 1, 2, 3, 5};
        assertEquals(expectedResults[index], fibonacci.fibonacci(index),
            () -> "Expected Fibonacci of " + index + " to be " + expectedResults[index]);
    }

    @ParameterizedTest
    @DisplayName("Fibonacci calculation with CsvSource for specific index/result pairs")
    @CsvSource({
        "6, 8",
        "7, 13",
        "8, 21",
        "9, 34",
        "10, 55"
    })
    void testFibonacciWithCsvSource(int index, long expectedResult) {
        assertEquals(expectedResult, fibonacci.fibonacci(index),
            () -> "Expected Fibonacci of " + index + " to be " + expectedResult);
    }

    @ParameterizedTest
    @DisplayName("Fibonacci calculation with MethodSource for larger indexes")
    @MethodSource("provideIndexesForMethodSource")
    void testFibonacciWithMethodSource(int index, long expectedResult) {
        assertEquals(expectedResult, fibonacci.fibonacci(index),
            () -> "Expected Fibonacci of " + index + " to be " + expectedResult);
    }

    private static Stream<Arguments> provideIndexesForMethodSource() {
        return Stream.of(
            Arguments.of(15, 610),
            Arguments.of(20, 6765),
            Arguments.of(25, 75025),
            Arguments.of(30, 832040)
        );
    }

    @ParameterizedTest
    @DisplayName("Fibonacci with ValueSource to test IllegalArgumentException for negative indexes")
    @ValueSource(ints = {-1, -10, -100})
    void testFibonacciWithNegativeIndexes(int index) {
        assertThrows(IllegalArgumentException.class, () -> fibonacci.fibonacci(index),
            () -> "Expected IllegalArgumentException for negative index " + index);
    }


    @ParameterizedTest
    @DisplayName("Fibonacci calculation using values from a CSV file")
    @CsvFileSource(resources = "/tech/erben/fibonacci/fibonacci_test_data.csv", numLinesToSkip = 1)
    void testFibonacciWithCsvFile(int index, long expectedResult) {
        assertEquals(expectedResult, fibonacci.fibonacci(index),
            () -> "Expected Fibonacci of " + index + " to be " + expectedResult);
    }
}
