package com.gautamthapa.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Input:  [40, 20, 45, 25, 0, 1]
Output: [45, 25, 1]
* */
public class LeaderArray {
    static void main() {
        int[] input = {40, 20, 45, 25, 0, 1};

        List<Integer> leaders = new ArrayList<>();


        // Rightmost element always leader
        int maxFromRight = input[input.length - 1];
        leaders.add(maxFromRight);

        for (int i = input.length - 2; i >= 0; i--) {
            if (input[i] > maxFromRight) {
                leaders.add(input[i]);
                maxFromRight = input[i];
            }
        }

        System.out.println("leaders : " + leaders);

        Collections.reverse(leaders);

        System.out.println("leaders : " + leaders);
    }
}
