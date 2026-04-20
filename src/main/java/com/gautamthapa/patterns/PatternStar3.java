package com.gautamthapa.patterns;

public class PatternStar3 {

    static void main(String[] args) {
        printPatternStar1(5);
    }

    private static void printPatternStar1(int num) {
        for (int row = 1; row <= num; row++) {

            // spaces
            for (int col = 1; col <= num - row; col++) {
                System.out.print("  ");
            }

            // stars
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
