package com.gautamthapa.javapractice.misc;

public class FactorialNumber {
    public static void main(String[] args) {
        int num = 5;
        // simple iterative approach
        factorialNumberIterative(num);
        System.out.println("Using Recursion, Factorial of " + num + " is " + factorialNumberRecursive(num));
    }

    private static void factorialNumberIterative(int num) {
        System.out.println("*** factorialNumberIterative ***");
        int res = 1;
        for (int i = 2; i <= num; i++)
            res *= i;

        System.out.println("Factorial of " + num + " is " + res);
    }

    private static int factorialNumberRecursive(int num) {
        if (num == 0)
            return 1;

        return num * factorialNumberRecursive(num - 1);
    }
}
