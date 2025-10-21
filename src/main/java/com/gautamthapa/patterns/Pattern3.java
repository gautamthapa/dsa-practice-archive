package com.gautamthapa.patterns;

public class Pattern3 {
    private void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Pattern3 p3 = new Pattern3();
        p3.pattern3(5);
    }
}
