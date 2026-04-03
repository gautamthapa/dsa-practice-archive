package com.gautamthapa.loops;

import java.util.HashMap;

public class Fibonacci {
    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        // Iterative Approach - Time: O(n), Space: O(1) → optimal (Best approach for production)
        int n = 10;
        fibonacciViaIterativeApproach(n);
        System.out.println();

        // Recursive - only for understanding not for production - Time: O(2^n) → exponential → bad
        fibonacciViaIterativeRecursion(n);
        System.out.println();

        // Optimized Recursion (DP / Memoization) - Time: O(n), Space: O(n) → good
        fibonacciViaIterativeViaDPMemoization(n);
        System.out.println();

        // Iterative matrix exponentiation - Time: O(log n), Space: O(1) → optimal (Best approach for production)
        System.out.println("Fibonacci sequence up to " + n + " terms: via Iterative approach with Matrix Exponentiation");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciViaIterativeViaIterativeMatrixExponentiation(i) + " ");
        }
    }

    private static int fibonacciViaIterativeViaIterativeMatrixExponentiation(int n) {
        if (n <= 1)
            return n;

        int[][] base = {{1, 1}, {1, 0}};
        int[][] result = power(base, n - 1);

        return result[0][0];

    }

    // Matrix exponentiation - Time: O(log n), Space: O(1) → optimal (Best approach for production)
    private static int[][] power(int[][] matrix, int n) {
        if (n == 1)
            return matrix;

        int[][] half = power(matrix, n / 2);
        int[][] full = multiply(half, half);

        if (n % 2 != 0) {
            full = multiply(full, matrix);
        }
        return full;
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        return new int[][]{
                {
                        a[0][0] * b[0][0] + a[0][1] * b[1][0],
                        a[0][0] * b[0][1] + a[0][1] * b[1][1]
                },
                {
                        a[1][0] * b[0][0] + a[1][1] * b[1][0],
                        a[1][0] * b[0][1] + a[1][1] * b[1][1]
                }
        };
    }

    private static void fibonacciViaIterativeViaDPMemoization(int n) {
        System.out.println("Fibonacci sequence up to " + n + " terms: via Iterative approach with DP Memoization");
        for (int i = 0; i < n; i++) {
            System.out.print(fibDPMemo(i) + " ");
        }
    }

    public static int fibDPMemo(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = fibDPMemo(n - 1) + fibDPMemo(n - 2);
        memo.put(n, result);
        return result;
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    private static void fibonacciViaIterativeRecursion(int n) {
        System.out.println("\nFibonacci sequence up to " + n + " terms: via Iterative Recursion");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    private static void fibonacciViaIterativeApproach(int n) {
        System.out.println("Fibonacci sequence up to " + n + " terms: via Iterative approach");
        int a = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
