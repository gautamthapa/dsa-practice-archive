package com.gautamthapa.javapractice.array;

import java.util.Arrays;

public class FindDuplicateNumbers {

    public static void main(String[] args) {
        int[] numArray = {0, 1, 4, 3, 2, 3, 4, 3, 1, 5, 4, 3};
        System.out.println("***Method 1***");
        findDuplicateMethod1(numArray);
        System.out.println("***Method 2***");
        int[] numArray1 = {0, 1, 4, 3, 2, 3, 4, 3, 1, 5, 4, 3};
        findDuplicateMethod2(numArray1);
    }

    private static void findDuplicateMethod2(int[] numArray) {
        Arrays.sort(numArray);
        int previous = -1;
        for (int i = 0; i < numArray.length; i++) {
            for (int j = i + 1; j < numArray.length; j++) {
                if (numArray[i] == numArray[j] && previous != numArray[i]) {
                    previous = numArray[i];
                    System.out.println(previous);
                }
            }
        }
    }

    private static void findDuplicateMethod1(int[] numArray) {
        // ref: https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
        for (int i = 0; i < numArray.length; i++) {
            numArray[numArray[i] % numArray.length]
                    = numArray[numArray[i] % numArray.length]
                    + numArray.length;
        }
        System.out.println(Arrays.toString(numArray));
        System.out.println("The repeating elements are : ");
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] >= numArray.length * 2) {
                System.out.println(i + " ");
            }
        }
    }
}
