package com.gautamthapa.coding;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CapitalizeFirstLetterOfWords {
    static void main() {
        String input = "java eight stream api";

        // Solution 1
        String output1 = Arrays.stream(input.split(" "))
                .map(str -> String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1))
                .collect(Collectors.joining(" "));

        // Solution 2
        String output2 = Arrays.stream(input.split("\\s+"))
                .map(s -> String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1))
                .collect(Collectors.joining(" "));

        System.out.println(output1);
        System.out.println(output2);
    }
}
