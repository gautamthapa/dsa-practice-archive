package com.gautamthapa.leetcode;

/*
 * Count trailing zeros in factorial like !6= 1*2*3*4*5*6=720; then here trailing zero is 1
 *
 * Time Complexity is O(log n)
 * Because here loop is every time decrease by 5.
 *
 * Space Complexity is O(1)
 * Because here only count and num variables are used and no arrays, collections, recursion and extra memory.
 * */
public class CountTrailingZeroFactorial {
    static void main() {
        var num = 15;
        System.out.println("1. Trailing zero in factorial of " + num + " : " + countTrailingZeroInFactorial1(num));
        System.out.println("2. Trailing zero in factorial of " + num + " : " + countTrailingZeroInFactorial2(num));
    }

    private static int countTrailingZeroInFactorial2(int num) {
        int count = 0;
        for (int divisor = 5; divisor <= num; divisor *= 5) {
            count += num / divisor;
        }
        return count;
    }

    private static int countTrailingZeroInFactorial1(int num) {
        if (num == 0)
            return 0;

        int count = 0;
        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }
        return count;
    }
}
