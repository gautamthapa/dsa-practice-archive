package com.gautamthapa.leetcode;

/*
 * Find out square of x, ignore decimal part - square root of x.
 * Here use Binary Search
 * */
public class SquareOfX {
    static void main() {
        int x = 16;
        System.out.println("Square root of " + x + " = " + squareOfXBinarySearch(x));
    }

    private static int squareOfXBinarySearch(int x) {
        int start = 1;
        int end = x;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            }
            if (square < x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}

/*
* Here time complexity - O(log x) - because of Binary search and search space becomes half in every iteration
* Space Complexity - O(1) - Because there are fixed variables - start, end, ans, mid, square. And No extra array, recursion stack and dynamic memory
* */
