package com.gautamthapa.coding;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWords {
    static void main() {
        String words = "hello java";

        // Reverse words via Stream
        String output = reverseWordsViaStream(words);
        System.out.println("output " + output);

        // Simple without split
        String output2=reverseWordsViaStreamSimple(words);
        System.out.println("output2 " + output2);
    }

    public static String reverseWordsViaStreamSimple(String str) {

        StringBuilder sb = new StringBuilder();

        int left = 0;

        for (int right = 0; right <= str.length(); right++) {

            if (right == str.length() || str.charAt(right) == ' ') {

                for (int i = right - 1; i >= left; i--) {
                    sb.append(str.substring(i, i + 1));
                }

                if (right != str.length()) {
                    sb.append(" ");
                }

                left = right + 1;
            }
        }

        return sb.toString();
    }

    private static String reverseWordsViaStream(String words) {
        return Arrays.stream(words.split(" "))
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
