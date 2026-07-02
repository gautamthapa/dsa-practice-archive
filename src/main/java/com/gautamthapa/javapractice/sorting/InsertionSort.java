package com.gautamthapa.javapractice.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        insertionSortMethod1();
    }

    private static void insertionSortMethod1() {
        int[] a = {12, 54, 65, 7, 23, 9};
        System.out.println(Arrays.toString(a));

        int key;
        int j;
        for (int i = 1; i < a.length; i++) {
            key = a[i];
            j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        System.out.println(Arrays.toString(a));
    }
}
