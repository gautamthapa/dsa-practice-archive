package com.gautamthapa.javapractice.array;

import java.util.Arrays;

public class CountDuplicateNumber {
    public static void main(String[] args) {
        int[] a = {3, 5, 2, 4, 2, 3, 6, 2};
        countDuplicateNumberMethod1(a);
    }

    private static void countDuplicateNumberMethod1(int[] a) {
        System.out.println("*** countDuplicateNumberMethod1 ***");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        int num = -1;
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            int count = 0;
            if (num != a[i]) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] == a[j]) {
                        flag = true;
                        num = a[i];
                        count++;
                    }
                }
                if (flag) {
                    System.out.printf("%d is repeats in %d times.\n", a[i], count);
                }
            }
        }
    }
}