package com.gautamthapa.patterns;

public class Pattern4 {
    private void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Pattern4 p4 = new Pattern4();
        p4.pattern4(5);
    }
}
