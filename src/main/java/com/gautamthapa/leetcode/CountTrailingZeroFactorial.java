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
        var num = 148;
        System.out.println("Trailing zero in factorial of " + num + " : " + countTrailingZeroInFactorial(num));
    }

    private static int countTrailingZeroInFactorial(int num) {
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
