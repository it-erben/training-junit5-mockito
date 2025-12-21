package tech.erben.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A bad example: This test uses another production class
 */
class BinetFibonacciTest {

    private final RecursiveFibonacci recursive = new RecursiveFibonacci();
    private final BinetFibonacci sqrt = new BinetFibonacci();

    /**
     * Testing one unit in terms of another is error prone.
     * It can lead to issues with the other class "leaking" into this test
     * <p>
     * Under rare circumstances, when you really only want to test parity between the implementations,
     * this is acceptable.
     */
    @Test
    public void shouldYieldSameResultThanRecursiveCalculation() {
        for (int i = 0; i < 15; i++) {
            Assertions.assertEquals(
                recursive.fibonacci(i),
                sqrt.fibonacci(i)
            );
        }
    }

    @Test
    public void shouldThrowExceptionOnNegativeInput() {
        Assertions.assertThrowsExactly(
            IllegalArgumentException.class,
            () -> sqrt.fibonacci(-1)
        );
    }

}
