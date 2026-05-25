package com.gautamthapa.leetcode;

public class PalindromeInteger {
    static void main() {
        int num = 232322432;
        System.out.println("Is number : " + num + " palindrome - " + checkNumberIsPalindrome(num));
    }

    private static boolean checkNumberIsPalindrome(int num) {
        if (num == 0 || num == 1) return true;

        if (num < 0) return false;

        int original = num;

        int ans = 0, rem;
        while (num != 0) {
            rem = num % 10;
            num = num / 10;
            ans = ans * 10 + rem;
        }

        return ans == original;
    }
}
