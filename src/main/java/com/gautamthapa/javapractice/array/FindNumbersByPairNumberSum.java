package com.gautamthapa.javapractice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindNumbersByPairNumberSum {
    public static void main(String[] args) {
        int[] a = {2, 4, 1, 6, 3, 5};
        int sum = 9;

        // Brute force Solution using two loops
        findNumbersByPairNumberSumBruteForce(a, sum);

        findNumbersByPairNumberSumBySortingAndWhile(a, sum);

        findNumbersByPairNumberSumByHashSet(a, sum);

    }

    private static void findNumbersByPairNumberSumByHashSet(int[] a, int sum) {
        System.out.println("*** findNumbersByPairNumberSumByHashSet ***");
        HashSet<Integer> set = new HashSet<>(a.length);
        for (int i : a) {
            int target = sum - i;
            if (!set.contains(target)) {
                set.add(i);
            } else {
                System.out.printf("(%d, %d)\n", i, target);
            }
        }
    }

    private static void findNumbersByPairNumberSumBySortingAndWhile(int[] a, int sum) {
        if (a.length < 2) {
            return;
        }
        System.out.println("*** findNumbersByPairNumberSumBySortingAndWhile ***");
        Arrays.sort(a);
        int left = 0, right = a.length - 1;
        while (left < right) {
            int addition = a[left] + a[right];
            if (addition == sum) {
                System.out.printf("(%d, %d)\n", a[left], a[right]);
                left += 1;
                right -= 1;
            } else if (addition < sum) {
                left += 1;
            } else if (addition > sum) {
                right -= 1;
            }
        }
    }

    private static void findNumbersByPairNumberSumBruteForce(int[] a, int sum) {
        System.out.println("*** findNumbersByPairNumberSumBruteForce ***");
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int first = a[i];
                int second = a[j];
                if ((first + second) == sum)
                    System.out.printf("(%d, %d)\n", first, second);
            }
        }
    }
}
