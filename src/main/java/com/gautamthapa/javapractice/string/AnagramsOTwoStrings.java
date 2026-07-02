package com.gautamthapa.javapractice.string;

import java.util.Arrays;

/*
 * We can say if two strings are an anagram of each other if they contain the same characters but at different orders.
 * */
public class AnagramsOTwoStrings {
    public static void main(String[] args) {
        String string1 = "Mary";
        String string2 = "army";
        System.out.println("Is both Strings are anagram? " + isAnagram(string1, string2));
    }

    private static boolean isAnagram(String string1, String string2) {
        char[] string1CharAr = string1.toLowerCase().toCharArray();
        char[] string2CharAr = string2.toLowerCase().toCharArray();
        Arrays.sort(string1CharAr);
        Arrays.sort(string2CharAr);
        return Arrays.equals(string1CharAr, string2CharAr);
    }
}
