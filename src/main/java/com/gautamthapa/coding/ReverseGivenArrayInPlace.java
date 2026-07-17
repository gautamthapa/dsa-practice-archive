package com.gautamthapa.coding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseGivenArrayInPlace {
    static void main() {
        int[] arr = {1, 2, 3, 4, 5};
        reverseGivenArrayInPlace(arr);
    }

    private static void reverseGivenArrayInPlace(int[] arr) {
        IntStream.range(0, arr.length / 2)
                .forEach(i -> {
                    int temp = arr[i];
                    arr[i] = arr[arr.length - i - 1];
                    arr[arr.length - i - 1] = temp;
                });

        System.out.println("Reverse : " + Arrays.toString(arr));
    }
}
