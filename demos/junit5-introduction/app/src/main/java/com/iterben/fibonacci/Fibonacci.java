package com.iterben.fibonacci;

/**
 * Interface defining operations for calculating Fibonacci numbers.
 * The Fibonacci sequence is a series of numbers where each number is the sum
 * of the previous two numbers in the sequence: 0, 1, 1, 2, 3, 5, 8, 13, ...
 */
public interface Fibonacci {

    /**
     * Calculates the Fibonacci number at the specified index.
     * The sequence starts with F(0) = 0 and F(1) = 1.
     * For n > 1, F(n) = F(n-1) + F(n-2).
     *
     * @param index the position in the Fibonacci sequence (0-based indexing)
     * @return the Fibonacci number at the specified index
     * @throws IllegalArgumentException if the index is negative
     * @throws ArithmeticException if the result exceeds the capacity of a long
     */
    long fibonacci(int index);
}
