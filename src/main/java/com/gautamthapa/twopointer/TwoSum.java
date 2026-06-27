package com.gautamthapa.twopointer;

import java.util.Arrays;

public class TwoSum {
    static void main() {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 18;
        // Bruteforce Solution
        int[] arr1 = findOut2Sum(arr, target); // TC: O(n2), O(1)
        System.out.println(Arrays.toString(arr1));

        // If sorted array then optimized approach
        int[] arr2 = findOut2Sum2(arr, target); // TC: O(n) SC: O(1)
        System.out.println(Arrays.toString(arr2));
    }

    private static int[] findOut2Sum2(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] == target) {
                return new int[]{start, end};
            } else if (arr[start] + arr[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{};
    }

    private static int[] findOut2Sum(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 0) {
            return new int[]{};
        }
        int[] res = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return res;
    }
}
