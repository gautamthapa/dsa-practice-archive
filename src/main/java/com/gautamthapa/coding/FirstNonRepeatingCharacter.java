package com.gautamthapa.coding;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    static void main() {
//        String str = "a$0pplea";
        String str = "aabbccdd";

        int nRCh = getFirstNonRepeatingCharacters(str);
        if (nRCh == -1) {
            System.out.println("First Non Repeating Char Not found.");
        } else {
            System.out.println("First Non Repeating Char : " + (char) nRCh);
        }

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
