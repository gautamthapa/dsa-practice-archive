package com.gautamthapa.coding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindWordsWithMatchedChar {
    static void main() {
        String input = "apple banana mango box been fox auto bike";
        char ch = 'b';

        List<String> output = Arrays.stream(input.split(" "))
                .filter(word -> word.startsWith(String.valueOf(ch)))
                .collect(Collectors.toList());

        System.out.println("Output : " + output);

        // OR print on stream
        Arrays.stream(input.split(" "))
                .filter(word -> word.startsWith(String.valueOf(ch)))
                .toList().forEach(System.out::println);

    }
}
