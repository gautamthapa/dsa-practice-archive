package com.gautamthapa.coding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumCommonStringIndexInArray {
    static void main() { // HCL
        String[] str1 = {"ab", "bc", "cd", "de"};
        String[] str2 = {"ba", "cd", "cb", "ed"};

        int sum = IntStream.range(0, str1.length)
                .filter(i -> Arrays.asList(str2).contains(str1[i]))
                .map(i -> i + Arrays.asList(str2).indexOf(str1[i]))
                .reduce(Integer::sum)
                .orElse(-1);

        System.out.println("SUM -> " + sum);
    }
}
