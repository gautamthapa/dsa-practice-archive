package com.gautamthapa.coding;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {
    static void main() {
//        String str = "a$0pplea";
        String str = "aabccdd";

        // Via Normal
        int nRCh = getFirstNonRepeatingCharacters(str);
        if (nRCh == -1) {
            System.out.println("First Non Repeating Char Not found.");
        } else {
            System.out.println("First Non Repeating Char : " + (char) nRCh);
        }

        // Via Stream
        Character ch = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(characterLongEntry -> characterLongEntry.getValue()==1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("First Non Repeating Char via Stream : " + ch);

    }

    private static int getFirstNonRepeatingCharacters(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for (Character ch : map.keySet()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return -1;
    }
}
