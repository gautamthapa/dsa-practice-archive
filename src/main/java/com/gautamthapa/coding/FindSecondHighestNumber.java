package com.gautamthapa.coding;

import java.util.Arrays;
import java.util.Comparator;

public class FindSecondHighestNumber {
    static void main() {
        int[] arr = {2, 3, 1, 4, 3, 1, 2, 7};

        // Via Stream
        int secondHighestNum = findSecondHighestNumber(arr);
        System.out.println("secondHighestNum : " + secondHighestNum);
    }

    private static int findSecondHighestNumber(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Array does not have second highest element."));
    }
}
