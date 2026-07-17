package com.gautamthapa.practice;

public class Practice {
    static void main() {

        // print Fibonacci series upto n
        int n = 10;
        printFibonacciSeries(n);


        // Via normal Factorial
        factorial(5);

        // Via normal Factorial Recursion
        factorial2(5);

    }

    private static int factorialRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorialRecursion(n - 1);

    }

    private static void factorial2(int n) {
        System.out.println("Factorial of " + n + " : " + factorialRecursion(n));
    }

    private static void factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number");
        }

        int fact = 1;
        for (int i = 1; i <= n; i++)
            fact *= i;

        System.out.println("Factorial of " + n + " : " + fact);
    }

    private static int fib(int n) {
        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    private static void printFibonacciSeries(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(fib(i));
        }
    }
}
