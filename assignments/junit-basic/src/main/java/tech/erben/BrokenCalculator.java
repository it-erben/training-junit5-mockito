package tech.erben;

public class BrokenCalculator {

    /**
     * Adds two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a - b;
    }

    /**
     * Subtracts the second integer from the first integer.
     * @param a the first integer
     * @param b the second integer
     * @return the result of a minus b
     */
    public int subtract(int a, int b) {
        return a + b;
    }

    /**
     * Multiplies two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first integer by the second integer.
     * @param a the first integer (dividend)
     * @param b the second integer (divisor)
     * @return the quotient of a divided by b
     * @throws IllegalArgumentException if b is zero
     */
    public int divide(int a, int b) {
        return a / b;
    }

    /**
     * Calculates the square of an integer.
     * @param a the integer to square
     * @return the square of a
     */
    public int square(int a) {
        return a * 2;
    }

    /**
     * Returns the square root of a number.
     * Note: This method will round down to the nearest integer.
     * @param a the number to find the square root of
     * @return the square root of a
     * @throws IllegalArgumentException if a is negative
     */
    public int squareRoot(int a) {
        return (int) Math.sqrt(a);
    }
}
