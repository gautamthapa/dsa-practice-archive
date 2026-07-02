package com.gautamthapa.javapractice.array;

import java.util.Arrays;

public class ArrayContainAValue {
    public static void main(String[] args) {
        int[] a = {2, 4, 1, 6, 8, 3};
        int checkValue = 20;
        checkValueUsingLinearSearch(a, checkValue);
        checkValueUsingBinarySearch(a, checkValue);
    }

    private static void checkValueUsingBinarySearch(int[] a, int checkValue) {
        Arrays.sort(a);
        int res = Arrays.binarySearch(a, checkValue);
        boolean isExist = res > 0;
        System.out.println("Is " + checkValue + " present in the array: " + isExist);
    }

    private static void checkValueUsingLinearSearch(int[] a, int checkValue) {
        boolean exist = false;
        for (int j : a) {
            if (j == checkValue) {
                exist = true;
                break;
            }
        }
        System.out.println("Is " + checkValue + " present in the array: " + exist);
    }
}
