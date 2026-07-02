package com.gautamthapa.coding;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequencyCount {

    static void main() {
        String str = "Gautamthapa";

        // Via Map
        countCharacterFrequency(str);

        // Via java 8
        Map<Character, Long> charMap = str.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        charMap.forEach((character, count) -> {
            System.out.println(character + " " + count);
        });
    }

    private static void countCharacterFrequency(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // print
        map.forEach((k, v) -> {
            System.out.println(k + "\t" + v);
        });

        // Time Complexity: O(n) because we traverse the string once, and each getOrDefault() and put() operation on LinkedHashMap is O(1) on average.
        // Space Complexity: O(k), where k is the number of distinct characters stored in the map. In the worst case, if every character is unique, it becomes O(n).
    }
}
