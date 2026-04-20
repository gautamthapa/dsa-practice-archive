package com.gautamthapa.patterns;

public class Pattern_a_to_e3 {
    static void main(String[] args) {
        printPatternNumber1(5);
    }

    private static void printPatternNumber1(int num) {
        for (int row = 1; row <= num; row++) {

            // spaces
            for (int col = 1; col <= num - row; col++) {
                System.out.print("  ");
            }

            // char
            for (char ch = 'A'; ch <= 'A' + row - 1; ch++) {
                System.out.print(ch+" ");
            }

            System.out.println();
        }
    }
}
