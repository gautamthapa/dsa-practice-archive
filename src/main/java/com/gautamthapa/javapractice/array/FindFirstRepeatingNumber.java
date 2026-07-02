package com.gautamthapa.javapractice.array;

import java.util.HashSet;

public class FindFirstRepeatingNumber {
    public static void main(String[] args) {
        int[] a = {5, 4, 6, 3, 4, 3};
        int n = a.length;

        findFirstRepeatingNumberByHashSet(a);
        findFirstRepeatingNumberWithoutDataStructure(a, n);
    }

    private static void findFirstRepeatingNumberWithoutDataStructure(int[] arr, int n) {
        // This will set k=1, if any
        // repeating element found
        int k = 0;

        // max = maximum from (all elements & n)
        int max = n;
        for (int i = 0; i < n; i++)
            if (max < arr[i])
                max = arr[i];

        // Array a is for storing
        // 1st time occurence of element
        // initialized by 0
        int[] a = new int[max + 1];

        // Store 1 in array b
        // if element is duplicate
        // initialized by 0
        int[] b = new int[max + 1];
        for (int i = 0; i < n; i++) {

            // Duplicate element found
            if (a[arr[i]] != 0) {
                b[arr[i]] = 1;
                k = 1;
                continue;
            } else
                // storing 1st occurence of arr[i]
                a[arr[i]] = i;
        }

        if (k == 0)
            System.out.println("No repeating element found");
        else {
            int min = max + 1;

            // trace array a & find repeating element
            // with min index
            for (int i = 0; i < max + 1; i++)
                if (a[i] != 0 && min > a[i] && b[i] != 0)
                    min = a[i];
            System.out.print(arr[min]);
        }
        System.out.println();
    }

    private static void findFirstRepeatingNumberByHashSet(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        int min = -1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (set.contains(a[i])) {
                min = a[i];
            } else {
                set.add(a[i]);
            }
        }
        if (min != -1) {
            System.out.println("First repeating number: " + min);
        } else {
            System.out.println("No repeating number");
        }

    }
}
