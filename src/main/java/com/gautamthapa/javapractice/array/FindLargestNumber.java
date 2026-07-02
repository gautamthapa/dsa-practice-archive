package com.gautamthapa.javapractice.array;

import java.util.Arrays;

public class FindLargestNumber {
    public static void main(String[] args) {
        int[] a = {12, 2, 1, 4, 3, 2};
        findLargestSmallestNumberIterative(a);

        findLargestSmallestNumberStream(a);
    }

    private static void findLargestSmallestNumberStream(int[] a) {
        System.out.println("*** findLargestSmallestNumberStream ***");
        int max= Arrays.stream(a).max().getAsInt();
        int min = Arrays.stream(a).min().getAsInt();
        System.out.println("Largest Number : "+max);
        System.out.println("Smallest Number : "+min);
    }

    private static void findLargestSmallestNumberIterative(int[] a) {
        System.out.println("*** findLargestSmallestNumberIterative ***");
        // find largest
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // find smallest
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println("Largest Number : "+max);
        System.out.println("Smallest Number : "+min);


    }
}
