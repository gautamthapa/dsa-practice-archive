package com.gautamthapa.loops;

public class SumOfNaturalNumberSquare {
    public static void main(String[] args) {
        System.out.println("Sum of natural numbers square");
        System.out.println("The sum of first 10 natural numbers square is: " + sumOfNaturalNumberSquare(10));
        System.out.println("Using formula: " + sumOfNaturalNumberSquareFormula(10));
    }
    public static int sumOfNaturalNumberSquare(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    public static int sumOfNaturalNumberSquareFormula(int n) {
        return n * (n + 1) * (2 * n + 1) / 6;
    }
}
