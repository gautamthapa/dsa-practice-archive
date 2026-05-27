package com.gautamthapa.leetcode;

public class ComplementOfNumber {
    static void main() {
        int num = 13;
        System.out.println("1. Complement of " + num + " is " + complementOfNumber(num));
        System.out.println("2. Complement of " + num + " is " + complementOfNumberOptimized(num));
    }

    private static int complementOfNumberOptimized(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return mask ^ num;

        /*
         * Time Complexity - O(1)
         * Because Operations used: highestOneBit, left shift, substraction, XOR and no loops
         *
         * Space Complexity - O(1)
         * Because fixed mask variable and - No extra memory depending on input size.
         * */

    }

    private static int complementOfNumber(int num) {
        int ans = 0, rem, mul = 1;
        while (num != 0) {
            rem = num % 2;
            rem = rem ^ 1;
            num = num / 2;
            ans = ans + (rem * mul);
            mul = mul * 2;
        }
        return ans;

        /*
         * Time Complexity - O(log n)
         * Because divides the number by 2 every iteration.
         *
         * Space Complexity - O(1)
         * Because fixed variable used num, ans, mul, rem. and no extra array, collections, recursion, dynamic memory allocation
         * */
    }
}