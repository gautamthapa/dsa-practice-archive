package com.gautamthapa.leetcode;

/*
 * Rectangle Check
 * Time Complexity is O(1) - because no loop, no recursion and no iteration
 *
 * Space Complexity is O(1) - only used variable - a, b, c, d and no extra array, collection and dynamic object used.
 * */
public class RectangleCheck {
    static void main() {
        int a = 2, b = 3, c = 2, d = 3;
        System.out.println("Is a=" + a + " b=" + b + " c=" + c + " d=" + d + " Rectangle? " + checkRectangle(a, b, c, d));
    }

    private static boolean checkRectangle(int a, int b, int c, int d) {
        return (a == b & c == d) ||
                (a == c & b == d) ||
                (a == d & b == c);
    }
}
