package com.gautamthapa.patterns;

public class PatternNumber3 {
    public static void main(String[] args) {
        printPatternNumber1(5);
    }

    private static void printPatternNumber1(int num) {
        for (int row = 1; row <= num; row++) {
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
