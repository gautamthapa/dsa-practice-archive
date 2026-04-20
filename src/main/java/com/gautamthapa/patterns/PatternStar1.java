package com.gautamthapa.patterns;

public class PatternStar1 {

    public static void main(String[] args) {
        printPatternStar1(5);
    }

    private static void printPatternStar1(int num) {
        for (int row = 1; row <= num; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
