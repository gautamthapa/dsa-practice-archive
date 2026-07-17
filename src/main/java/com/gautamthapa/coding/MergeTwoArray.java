package com.gautamthapa.coding;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeTwoArray {
    static void main() {
        Integer[] array1 = {2, 4, 6, 7};
        Integer[] array2 = {9, 11, 23, 10};

        Integer[] output = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(Integer[]::new);

        System.out.println("Merged Array : "+Arrays.toString(output));
    }
}
