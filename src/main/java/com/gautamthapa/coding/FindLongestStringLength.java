package com.gautamthapa.coding;

import java.util.Arrays;

public class FindLongestStringLength {
    static void main() {
        String[] str = {"Apple", "Banana", "Avacado", "Apricot", "Grapes"};
        Integer longestStringLength = findLongestStringLength(str);
        System.out.println("longestStringLength : " + longestStringLength);
    }

    private static Integer findLongestStringLength(String[] str) {
        return Arrays.stream(str)
                .mapToInt(value -> value.length())
                .max().orElse(0);

    }
}
