package com.gautamthapa.twopointer;

import java.util.Arrays;

public class TwoSubstractor {
    static void main() {
        int[] arr = {2, 3, 5, 6, 10, 50, 8};
        System.out.println(arr.length);
        int target = 45;

        // Optimized approach
        int[] newArr = findOutTwoPairsMatchWithTarget(arr, target);
        Arrays.stream(newArr).forEach(System.out::println);
    }

    private static int[] findOutTwoPairsMatchWithTarget(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while (end < arr.length) {
            if (arr[end] - arr[start] == target) {
                return new int[]{start, end};
            } else if (arr[end] - arr[start] < target) {
                end++;
            } else {
                start++;
            }
        }

        return new int[]{};
    }
}
