package com.gautamthapa.patterns;

public class PatternBasics {
    public static void main(String[] args) {
        int n = 5;
        print1To5_1(n);
        print1To5_2(n);

        print1To5_3(n);

        print1To5Square(n);
        print1To5Cube(n);

        print_aTo_e(n);
    }

    private static void print_aTo_e(int n) {
        System.out.println("print_aTo_e *** ");

        for (int row = 1; row <= n; row++) {
            char ch = (char) ('a' + (row - 1));
            for (int col = 1; col <= n; col++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    private static void print1To5Cube(int n) {
        System.out.println("print1To5Cube *** ");
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print(col * col * col + " ");
            }
            System.out.println();
        }
    }

    private static void print1To5Square(int n) {
        System.out.println("print1To5Square *** ");
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print(col * col + " ");
            }
            System.out.println();
        }
    }

    private static void print1To5_3(int n) {
        System.out.println("print1To5_3 *** ");
        for (int row = 1; row <= n; row++) {
            for (int col = n; col >= 1; col--) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static void print1To5_2(int n) {
        System.out.println("print1To5_2 *** ");
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static void print1To5_1(int n) {
        System.out.println("print1To5_1 *** ");
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }
}
