package com.gautamthapa.leetcode;

/*
 - calculates the total number of squares a Bishop can move to from position (a, b) on an 8×8 chessboard.
 - Algorithm - Mathematical Geometry / Chessboard Simulation / Diagonal Movement Counting
 - Time Complexity - O(1)
 - Space Complexity - O(1)

* */
public class BishopMoves {
    static void main() {
        int a = 3, b = 4;
        System.out.println("BishopMoves a=" + a + " b=" + b + " is " + findBishopMoves(a, b));
    }

    private static int findBishopMoves(int a, int b) {
        int count = 0;

        count += Math.min(8 - a, 8 - b);
        count += Math.min(8 - a, b - 1);
        count += Math.min(a - 1, b - 1);
        count += Math.min(a - 1, 8 - b);

        return count;
    }
}
