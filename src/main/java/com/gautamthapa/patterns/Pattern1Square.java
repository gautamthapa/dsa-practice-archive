package com.gautamthapa.patterns;

public class Pattern1Square {
    private void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Pattern1Square p1 = new Pattern1Square();
        p1.pattern1(5);
    }
}
