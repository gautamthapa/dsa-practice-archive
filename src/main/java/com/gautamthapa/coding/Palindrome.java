package com.gautamthapa.coding;

import java.util.stream.IntStream;

public class Palindrome {
    static void main() {
        String str = "mam";

        // Via For loop
        boolean palindrome = checkStringIsPalindromeOrNot(str);
        System.out.println("Is " + str + " palindrome? " + palindrome);

        // Via Stream
        boolean palindrome2 = IntStream.range(0, str.length() - 1)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
        System.out.println("Is " + str + " palindrome? " + palindrome2);
    }

    private static boolean checkStringIsPalindromeOrNot(String str) {
        // half of the string and checks left and right
        for (int i = 0; i < str.length() / 2; i++) {

            // check left and right characters
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
