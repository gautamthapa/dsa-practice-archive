package com.gautamthapa.javapractice.array;

public class UnionAndIntersectionTwoSortedArray {
    public static void main(String[] args) {
        int[] da1 = {1, 2, 2, 2, 3};
        int[] da2 = {2, 3, 4, 5};
        int[] a1 = {1, 2, 4, 5, 6};
        int[] a2 = {2, 3, 5, 7};
        int m = a1.length, n = a2.length;

        unionOfSortedTwoArrays(a1, a2, m, n);
        intersectionOfSortedTwoArrays(a1, a2, m, n);
        unionOfDuplicateElementsTwoSortedArray(da1,da2);
    }

    private static void intersectionOfSortedTwoArrays(int[] a1, int[] a2, int m, int n) {
        System.out.println("*** intersectionOfSortedTwoArrays ***");
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a1[i] < a2[j]) {
                i++;
            } else if (a2[j] < a1[i]) {
                j++;
            } else {
                System.out.print(a2[j++] + " ");
                i++;
            }
        }
        System.out.println();
    }

    private static void unionOfSortedTwoArrays(int[] a1, int[] a2, int m, int n) {
        System.out.println("*** unionOfSortedTwoArrays ***");
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a1[i] < a2[j]) {
                System.out.print(a1[i++] + " ");
            } else if (a2[j] < a1[i]) {
                System.out.print(a2[j++] + " ");
            } else {
                System.out.print(a2[j++] + " ");
                i++;
            }
        }

        // print remaining array
        while (i < m)
            System.out.print(a1[i++] + " ");

        while (j < n)
            System.out.print(a2[j++] + " ");
        System.out.println();
    }

    private static void unionOfDuplicateElementsTwoSortedArray(int[] a1, int[] a2) {
        System.out.println("*** unionOfDuplicateElementsTwoSortedArray ***");
        int m = a1[a1.length - 1];
        int n = a2[a2.length - 1];
        int ans = 0;
        if (m > n) {
            ans = m;
        } else {
            ans = n;
        }

        int[] newtable = new int[ans + 1];
        System.out.print(a1[0] + " ");

        ++newtable[a1[0]];

        for (int i = 1; i < a1.length; i++) {
            if (a1[i] != a1[i - 1]) {
                System.out.print(a1[i] + " ");
                ++newtable[a1[i]];
            }
        }

        for (int j = 1; j < a2.length; j++) {
            if (newtable[a2[j]] == 0) {
                System.out.print(a2[j] + " ");
                ++newtable[a1[j]];
            }
        }
    }
}