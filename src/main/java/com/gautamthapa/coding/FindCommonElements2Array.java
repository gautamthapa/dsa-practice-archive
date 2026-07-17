package com.gautamthapa.coding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindCommonElements2Array {
    static void main() {
        int[] arr1 = {3, 6, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};
        findCommonElements(arr1, arr2);
    }

    private static void findCommonElements(int[] arr1, int[] arr2) {
        List<Integer> commonNumbers = Arrays.stream(arr1)
                .filter(number -> Arrays.stream(arr2).anyMatch(num2 -> number == num2))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("commonNumbers: " + commonNumbers);
    }
}
