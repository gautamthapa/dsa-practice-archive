package com.gautamthapa.coding;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {
    static void main() {
        String str = "hello";
        // Via two
        String output = reverseString(str);
        System.out.println("ReverseString -> " + output);

        // Via StringBuilder
        String sbOutput = new StringBuilder(str).reverse().toString();
        System.out.println("sbOutput : " + sbOutput);

        // Via Stream API
        String sApiReverse = IntStream.range(0, str.length())
                .mapToObj(i -> String.valueOf(str.charAt(str.length() - 1 - i)))
                .collect(Collectors.joining(""));

        System.out.println("sApiReverse : "+sApiReverse);
    }

    private static String reverseString(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException("Input is empty.");

        int start = 0;
        int end = str.length() - 1;
        char[] chArr = str.toCharArray();

        while (start < end) {
            char temp = chArr[start];
            chArr[start] = chArr[end];
            chArr[end] = temp;

            start++;
            end--;
        }

        return new String(chArr);
    }
}
