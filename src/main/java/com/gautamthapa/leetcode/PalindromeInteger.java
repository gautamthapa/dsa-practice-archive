package com.gautamthapa.leetcode;

/*
* Palindrome Integer via Reverse Number algorithm
* if number is 121 then it is Palindrome
* */
public class PalindromeInteger {
    static void main() {
        int num = 232322432;
        System.out.println("Is number : " + num + " palindrome - " + checkNumberIsPalindrome(num));
    }

    private static boolean checkNumberIsPalindrome(int num) {
        if (num == 0 || num == 1) return true;

        if (num < 0) return false;

        int original = num;

        long ans = 0, rem;
        while (num != 0) {
            rem = num % 10;
            num = num / 10;
            ans = ans * 10 + rem;
        }

        return ans == original;
    }
}
/*
* Time Complexity - O(log n)
* Because every digit loop runs once
*
* Space Complexity - O(1)
* Because fixed variable used num, ans, original, rem. and no extra array, collections, recursion, dynamic memory allocation
* */