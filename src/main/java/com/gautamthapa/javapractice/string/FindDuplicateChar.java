package com.gautamthapa.javapractice.string;

import java.util.ArrayList;

public class FindDuplicateChar {
    public static void main(String[] args) {
        String str = "My name is Gautam Thapa";
        printDuplicates(str);
    }

    private static void printDuplicates(String str) {
        int count = 0;
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) != ch) {
                    continue;
                }
                count++;
            }

            if (!charList.contains(ch)) {
                if (count > 1 && ch != ' ') {
                    System.out.println("Char: " + ch + ", count: " + count + " times.");
                    charList.add(ch);
                }
            }
            count = 0;
        }
    }
}
