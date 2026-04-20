package com.gautamthapa.patterns;

public class Pattern_a_to_e1 {
    public static void main(String[] args) {
        printaToe1(5);
        printaToe2(5);
    }

    private static void printaToe2(int number) {
        System.out.println("printaToe2 *** ");
        for (int row = 1; row <= number; row++) {
            char ch = 'a';
            for (int col = 1; col <= number; col++) {
                System.out.print((char) (ch + col - 1)+" ");
            }
            System.out.println();
        }
    }

    private static void printaToe1(int number) {
        System.out.println("printaToe1 *** ");
        for (int i = 0; i < number; i++) {
            for (char j = 'a'; j <= 'e'; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
