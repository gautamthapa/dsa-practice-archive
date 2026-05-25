package com.gautamthapa.leetcode;

public class ReverseInteger {
    static void main() {
        int num = 632;

        System.out.println("Reverse Integer: " + reverseInteger(num));
    }

    private static int reverseInteger(int num) {
        int ans = 0, rem;
        while (num != 0) {
            rem = num % 10;
            num = num / 10;
            ans = ans * 10 + rem;
        }
        return ans;
    }
}
