package com.gautamthapa.javapractice.array;

import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] ar = generateArrayByRange(5, 20);
        int[] mArray = {5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20};
        Arrays.asList(mArray).stream().sorted();
        System.out.println("Missing number: " + getMissingNumber(ar, mArray));

        // Only one missing number in array
        int[] iArray = new int[]{1, 2, 4};
        int missing = getMissingNumber(iArray, 4);
        System.out.printf("Missing number in array %s is %d %n",
                Arrays.toString(iArray), missing);


    }

    public static int getMissingNumber(int[] fullArray, int[] mArray) {
        int totalMain = 0;
        int totalMissing = 0;
        for (int i : fullArray) {
            totalMain += i;
        }
        for (int i : mArray) {
            totalMissing += i;
        }
        return totalMain - totalMissing;
    }

    public static int[] generateArrayByRange(int start, int end) {
        int[] ar = new int[(end - start) + 1];
        int index = 0;
        for (int i = start; i <= end; i++) {
            ar[index] = i;
            index++;
        }
        return ar;
    }

    public static int getMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = totalCount * (totalCount + 1) / 2;
        System.out.println("expected sum: "+expectedSum);
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }
}
