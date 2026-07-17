package com.gautamthapa.coding;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondNonRepeatingCharacter {
    static void main() {
        String str = "Gautam";

        // Via Stream
        Character ch = str.chars().map(Character::toLowerCase)
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() == 1)
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);


        System.out.println("First Non Repeating Char via Stream : " + ch);

    }
}
