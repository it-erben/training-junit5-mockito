package tech.erben.junitbasics;

/**
 * Calculator class provides basic arithmetic operations, factorial calculation,
 * prime number check, GCD calculation, and even/odd checks.
 */
public class Calculator {

    /**
     * Adds two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second integer from the first.
     * @param a the first integer
     * @param b the second integer
     * @return the difference of a and b
     */
    public int subtract(int a, int b) {
        return a - b;
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
     * Divides the first integer by the second, with error handling for division by zero.
     * @param a the dividend
     * @param b the divisor
     * @return the quotient of a divided by b
     * @throws IllegalArgumentException if b is zero
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }

    /**
     * Calculates the factorial of a non-negative integer.
     * @param n the integer for which the factorial is to be calculated
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Checks if a given integer is a prime number.
     * @param n the integer to check for primality
     * @return true if n is prime, false otherwise
     */
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers using recursion.
     * @param a the first integer
     * @param b the second integer
     * @return the GCD of a and b
     */
    public int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    /**
     * Checks if a given integer is even.
     * @param n the integer to check
     * @return true if n is even, false otherwise
     */
    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    /**
     * Checks if a given integer is odd.
     * @param n the integer to check
     * @return true if n is odd, false otherwise
     */
    public boolean isOdd(int n) {
        return n % 2 != 0;
    }
}
