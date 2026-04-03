package com.gautamthapa.loops;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        // Take number from user input or define it directly
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        boolean prime = primeNumber(number);
        if (prime) {
            System.out.println("Prime number");
        } else {
            System.out.println("Not Prime number");
        }

        // Prime Numbers upto n
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number2 = sc2.nextInt();
        primeNumberBetterSieveOfEratosthenes(number2);


        sc.close();
        sc2.close();
    }

    public static boolean primeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primeNumberBetterSieveOfEratosthenes(int number) {
        boolean[] isPrime = sieve(number);
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.println(i + "");
            }
        }
    }

    private static boolean[] sieve(int number) {
        boolean[] isPrime = new boolean[number + 1];

        // Step 1: Assume all numbers are prime
        Arrays.fill(isPrime, true);

        // Step 2: 0 and 1 are not prime
        if (number >= 0) isPrime[0] = false;
        if (number >= 1) isPrime[1] = false;

        // Step 3: Mark multiples as non-prime
        for (int i = 2; i * i <= number; i++) {
            if(isPrime[i]) {
                for (int j = i * i; j <= number; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
