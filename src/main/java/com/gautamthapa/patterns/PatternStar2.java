package com.gautamthapa.patterns;

public class PatternStar2 {

    public static void main(String[] args) {
        printPatternStar1(5);
    }

    private static void printPatternStar1(int num) {
        for (int row = 1; row <= num; row++) {
            for (int col = 1; col <= num - (row - 1); col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
