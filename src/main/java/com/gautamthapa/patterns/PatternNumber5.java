package com.gautamthapa.patterns;

public class PatternNumber5 {
    static void main() {
        printPatternNumber1(5);
    }

    private static void printPatternNumber1(int num) {
        for (int row = 1; row <= num; row++) {
            for (int col = 1; col <= num - (row - 1); col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
