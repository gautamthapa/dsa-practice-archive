package com.gautamthapa.javapractice.misc;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first number : ");
        int start = s.nextInt();
        System.out.print("Enter the second number : ");
        int end = s.nextInt();
        System.out.println("List of prime numbers between " + start + " and " + end);
        for (int i = start; i <= end; i++) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("Is this prime number? " + isPrimeMethod2(11));
    }

    // Time complexity: O(n)
    public static boolean isPrimeMethod1(int n) {
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


    static int i = 2;

    // Time Complexity: O(n)
    public static boolean isPrimeMethod2(int n) {

        if (n <= 1)
            return false;

        if (n == i)
            return true;

        if (n % i == 0)
            return false;
        i++;
        return isPrimeMethod2(n);
    }

    public static boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
