package com.gautamthapa.javapractice.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        sortArrayByBubbleSortTempVariableASC();
        sortArrayByBubbleSortTempVariableASCAdaptive();
        sortArrayByBubbleSortTempVariableASC1();
        sortArrayByBubbleSortWithoutTempVariableASC();
        sortArrayByBubbleSortTempVariableASC2();
    }

    // main solution 2
    private static void sortArrayByBubbleSortTempVariableASCAdaptive() {
//        int[] a = {7, 11, 9, 2, 4, 17};
        int[] a = {1, 2, 3, 6, 5};
        System.out.println("*** sortArrayByBubbleSortTempVariableASCAdaptive ***");
        System.out.println("unsorted Array: ");
        System.out.println(Arrays.toString(a));
        int temp;
        boolean sorted;
        for (int i = 0; i < a.length - 1; i++) {
            sorted = false;
            System.out.printf("Working on pass number %d\n", i + 1);
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    sorted = true;
                }
            }
            if (!sorted) {
                break;
            }
        }
        System.out.println("Sorted Array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // main solution 1
    private static void sortArrayByBubbleSortTempVariableASC() {
        int[] a = {7, 11, 9, 2, 17, 4};
        System.out.println("*** sortArrayByBubbleSortTempVariableASC ***");
        System.out.println("unsorted Array: ");
        System.out.println(Arrays.toString(a));
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted Array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void sortArrayByBubbleSortTempVariableASC2() {
        int[] a = {7, 11, 9, 2, 17, 4};
        System.out.println("*** sortArrayByBubbleSortTempVariableASC2 ***");
        System.out.println("unsorted Array: ");
        System.out.println(Arrays.toString(a));
        int temp;
        boolean swapped = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        System.out.println("Sorted Array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void sortArrayByBubbleSortWithoutTempVariableASC() {
        int[] a = {7, 11, 9, 2, 17, 4};
        System.out.println("*** sortArrayByBubbleSortWithoutTempVariableASC ***");
        System.out.println("unsorted Array: ");
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    a[i] = a[i] + a[j];
                    a[j] = a[i] - a[j];
                    a[i] = a[i] - a[j];
                }
            }
        }
        System.out.println("Sorted Array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void sortArrayByBubbleSortTempVariableASC1() {
        int[] a = {7, 11, 9, 2, 17, 4};
        System.out.println("*** sortArrayByBubbleSortTempVariableASC ***");
        System.out.println("unsorted Array: ");
        System.out.println(Arrays.toString(a));
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("Sorted Array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
