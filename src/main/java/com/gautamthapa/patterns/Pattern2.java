package com.gautamthapa.patterns;

public class Pattern2 {
    private void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Pattern2 p2 = new Pattern2();
        p2.pattern2(5);
    }

}
