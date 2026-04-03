package com.gautamthapa.loops;

public class FactorialNumber {
    public static void main(String[] args) {
        System.out.println("Factorial of 5 is: " + factorial(5));
    }
    public static int factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
