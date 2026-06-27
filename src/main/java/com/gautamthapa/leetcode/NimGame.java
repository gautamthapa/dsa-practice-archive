package com.gautamthapa.leetcode;
/*

The Nim Game is a very famous game theory and interview problem.

Problem (LeetCode 292)

There is a pile of n stones.

Rules:

Two players take turns.
On each turn, a player can remove 1, 2, or 3 stones.
Whoever removes the last stone wins.
Both players play optimally.


* */
public class NimGame {
    static void main() {
        int a = 4;
        System.out.println("Can win nim? " + canWinNim(a));
    }

    private static boolean canWinNim(int a) {
        return a % 4 != 0;
    }
}
