package com.gautamthapa.javapractice.pattern;

public class LeftTriangle {
    public static void main(String[] args) {
        int num = 10;
        printLeftTriangleMethod1(num);
        printLeftTriangleMethod2(num);
    }

    private static void printLeftTriangleMethod2(int num) {
        for (int i = 1; i < num; i++) {
            for (int j = 2 * (num - i); j >= 1; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    private static void printLeftTriangleMethod1(int num) {
        for (int i = 1; i < num; i++) {
            for (int j = num; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
