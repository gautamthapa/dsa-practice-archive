package com.gautamthapa.coding;

import java.util.List;
import java.util.stream.Collectors;

public class FindVowelsInString {
    static void main() {
        String input = "hello how are you. Ink is vogue.";

        List<Character> vowels = input.chars()
                .mapToObj(value -> (char) value)
                .filter(character -> 'a' == character || 'e' == character || 'i' == character || 'o' == character || 'u' == character)
                .distinct()
                .collect(Collectors.toList());

        List<String> vowels1 = input.chars()
                .mapToObj(value -> (char) value)
                .map(character -> String.valueOf(character).toLowerCase())
                .distinct()
                .filter(character -> "a".equals(character) || "e".equals(character) || "i".equals(character) || "o".equals(character) || "u".equals(character))
                .collect(Collectors.toList());


        // Better version
        List<Character> vowels2 = input.chars()
                .map(Character::toLowerCase)
                .mapToObj(value -> (char) value)
                .distinct()
                .filter(ch -> "aeiou".indexOf(ch) >= 0)
                .toList();

        System.out.println("vowels " + vowels);
        System.out.println("vowels1 " + vowels1);
        System.out.println("vowels2 " + vowels2);
    }
}
