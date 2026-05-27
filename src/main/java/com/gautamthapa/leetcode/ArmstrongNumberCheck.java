package com.gautamthapa.leetcode;

/*
Time Complexity - O(log n)
O(d)+O(d)

Space complexity - O(1)
Only used - You only use fixed variables: digits, rem, ans and n. There is no array, no collection, no recursion and no dynamic memory.
* */
public class ArmstrongNumberCheck {
    static void main() {
        int num = 1531;
        int digits = getDigitsOfNumber(num);
        System.out.println("Is " + num + " Armstrong number?" + " : " + checkArmstrongNumber(digits, num));
    }

    private static int getDigitsOfNumber(int num) {
        int digits = 0;
        while (num != 0) {
            digits++;
            num = num / 10;
        }
        return digits;
    }

    private static boolean checkArmstrongNumber(int digits, int num) {
        int rem, ans = 0, n = num;
        while (n != 0) {
            rem = n % 10;
            n = n / 10;
            ans = (int) (ans + Math.pow(rem, digits));
        }
        return ans == num;
    }
}
