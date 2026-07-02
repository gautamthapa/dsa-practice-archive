package com.gautamthapa.javapractice.string;

import java.util.StringTokenizer;

public class CountWordsFromString {
    public static void main(String[] args) {
        String str = "Arise! Awake! and stop not until the goal is reached.";
        System.out.println("The input string is: \n" + str + "\n");
        System.out.println("Count words using split() method: " + countWordsUsingSplit(str));
        System.out.println("Count words using StringTokenizer class: " + countWordsUsingStringTokenizer(str));
        System.out.println("Count words using custom method: " + countWords(str));
    }

    private static int countWords(String string) {
        int wordCount = 0;
        int endOfString = string.length() - 1;
        String str = string.trim();

        for (int i = 0; i < string.length(); i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                wordCount++;
            } else if (str.charAt(i) == ' ' && str.charAt(i++) == ' ') {
                i++;
            } else if (i == endOfString) {
                wordCount++;
            }
        }
        return wordCount;
    }

    private static int countWordsUsingStringTokenizer(String str) {
        if (!str.isEmpty()) {
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            return stringTokenizer.countTokens();
        }
        return 0;
    }


    private static int countWordsUsingSplit(String str) {
        String[] springArray = str.split("\\s+"); // splitting the using spaces
        return springArray.length;
    }
}
