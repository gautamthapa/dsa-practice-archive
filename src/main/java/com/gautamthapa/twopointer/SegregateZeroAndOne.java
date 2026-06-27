package com.gautamthapa.twopointer;

import java.util.Arrays;

public class SegregateZeroAndOne {
    static void main() {
        int[] arr = new int[]{1, 0, 0, 1};

        // Bruteforce 1
        segregateZeroAndOne1(arr); // TC: O(n log n) SC: O(1)

        // Bruteforce 2
        segregateZeroAndOne2(arr); // TC: O(n), SC: O(1)


        // Via Simple Java - Optimized
        zeroStartAndOneEnd(arr); // TC: O(n) SC: O(1)
        Arrays.stream(arr).forEach(System.out::println);

        //TODO: Via Stream API
    }

    private static void segregateZeroAndOne2(int[] arr) {
        System.out.println("**segregateZeroAndOne2**");
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static void segregateZeroAndOne1(int[] arr) {
        System.out.println("**segregateZeroAndOne1**");
        int count0=0;
        int count1=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                count0++;
            }else {
                count1++;
            }
        }
        int[] newArr = new int[arr.length];
        for(int i =0; i<count0; i++){
            newArr[i]=0;
        }
        for(int i =0; i<count1; i++){
            newArr[count0]=1;
        }

        Arrays.stream(newArr).forEach(System.out::println);

    }

    private static void zeroStartAndOneEnd(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] == 0) {
                start++;
            } else {
                if (arr[end] == 0) {
                    // swap values of arr
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                } else {
                    end--;
                }
            }
        }
    }
}
