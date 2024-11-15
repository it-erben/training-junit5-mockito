package com.iterben.fibonacci;

public class RecursiveFibonacci implements Fibonacci {

    /**
     * Calculates the nth number in the Fibonacci sequence using recursion.
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) due to recursion stack
     *
     * @param n the position in the Fibonacci sequence (0-based)
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }

        // Base cases
        if (n <= 1) {
            return n;
        }

        // Recursive case: Fn = Fn-1 + Fn-2
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
