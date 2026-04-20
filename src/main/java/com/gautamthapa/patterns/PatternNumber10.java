package com.gautamthapa.patterns;

public class PatternNumber10 {
    static void main() {
        printPatternNumber1(5);
    }

    private static void printPatternNumber1(int num) {
        for (int row = 1; row <= num; row++) {

            // spaces
            for (int col = 1; col <= num - row; col++) {
                System.out.print("  ");
            }

            // numbers
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
