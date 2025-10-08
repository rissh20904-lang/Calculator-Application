/**
 * Calculator.java
 * Implements arithmetic operations using method overloading.
 * Methods:
 *  - add(int a, int b)
 *  - add(double a, double b)
 *  - add(int a, int b, int c)
 *  - subtract(int a, int b)
 *  - multiply(double a, double b)
 *  - divide(int a, int b)  // throws ArithmeticException on divide-by-zero
 *
 * Author: Generated for user assignment
 */
public class Calculator {

    // Add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Subtract two integers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiply two doubles
    public double multiply(double a, double b) {
        return a * b;
    }

    // Divide two integers and return a double result.
    // Throws ArithmeticException if divisor is zero.
    public double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / (double) b;
    }
}
