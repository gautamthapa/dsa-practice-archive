package com.gautamthapa.loops;

public class SumOfNaturalNumber {
    public static void main(String[] args) {
        int n = 10;
        int sum = sumOfNaturalNumbers(n);
        System.out.println("The sum of first " + n + " natural numbers is: " + sum);

        System.out.println("Using formula: " + (n * (n + 1)) / 2);
    }

    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
