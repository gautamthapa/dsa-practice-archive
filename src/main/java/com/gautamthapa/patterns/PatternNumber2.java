package com.gautamthapa.patterns;

public class PatternNumber2 {
    public static void main(String[] args) {
        printPatternNumber1(5);
    }

    private static void printPatternNumber1(int num) {
        for (int row = 1; row <= num; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }
}
