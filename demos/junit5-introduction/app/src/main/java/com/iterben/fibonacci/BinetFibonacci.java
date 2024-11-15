package com.iterben.fibonacci;

/**
 * Class for calculating the nth Fibonacci number using Binet's Formula.
 * This implementation uses the mathematical formula involving the golden ratio (φ).
 * <p>
 * Binet's Formula: Fₙ = (φⁿ - (-φ)⁻ⁿ)/√5
 * where φ = (1 + √5)/2 is the golden ratio
 */
public class BinetFibonacci implements Fibonacci {

    /** The golden ratio φ = (1 + √5)/2 */
    private static final double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2.0;

    /** The negative reciprocal of the golden ratio -φ⁻¹ */
    private static final double GOLDEN_RATIO_CONJUGATE = -1 / GOLDEN_RATIO;

    /**
     * Calculates the nth number in the Fibonacci sequence using Binet's Formula.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * <p>
     * Note: Due to the limitations of floating-point arithmetic, this method
     * is accurate only for relatively small values of n (typically n < 70).
     * For larger values, rounding errors may occur.
     *
     * @param n the position in the Fibonacci sequence (0-based)
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }

        // For small values, return directly to avoid floating-point imprecision
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Apply Binet's Formula

        return Math.round((Math.pow(GOLDEN_RATIO, n) - Math.pow(GOLDEN_RATIO_CONJUGATE, n)) / Math.sqrt(5));
    }
}
