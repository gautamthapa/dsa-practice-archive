package com.gautamthapa.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    static void main() {
        String str1 = "temp";
        String str2 = "pemt";

        // Via Sorting Easy - Frequency Array
        boolean isAnagram1 = isAnagram1(str1, str2); // TC: O(n), SC: O(1)
        System.out.println(str1 + " and " + str2 + " are anagram : " + isAnagram1);

        // Via Sorting Easy
        boolean isAnagram2 = isAnagram2(str1, str2); // TC: O(n log n), SC: O(n)
        System.out.println(str1 + " and " + str2 + " are anagram : " + isAnagram2);

        // Via HashMap
        boolean isAnagram3 = isAnagram3(str1, str2); // TC: O(n) SC: O(n)
        System.out.println(str1 + " and " + str2 + " are anagram : " + isAnagram3);
    }

    private static boolean isAnagram2(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        int[] count = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0)
                return false;
        }

        return true;

    }

    private static boolean isAnagram1(String str1, String str2) {
        System.out.println("isAnagram1 **");
        if (str1.length() != str2.length())
            return false;

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }

    private static boolean isAnagram3(String str1, String str2) {
        System.out.println("isAnagram **");
        if (str1.length() != str2.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        // keep count of characters of character
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}
