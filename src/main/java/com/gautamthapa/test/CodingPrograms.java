package com.gautamthapa.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CodingPrograms {
    static void main() {

        // Second largest
        int[] arr = {4, 2, 5, 9};
        //findSecondLargest(arr);

        // 2sum
        int[] arr1 = {3, 9, 6, 8, 5};
        int target = 8;
        int[] outputArr = find2SumMatchWithTarget(arr1, target);
        Arrays.stream(outputArr).forEach(System.out::println);


        // count first non repeating character
        String str1 = "applea";
        char outputCh = getFirstNonRepeatingCharacter(str1);
        System.out.println("First non repeating character: " + outputCh);


        // reverse words
        String input = "hello java";
        String output = reverseStringWords(input);
        System.out.println("reverseStringWords : " + output);
    }

    private static String reverseStringWords(String input) {
        int start = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == ' ') {
                String word = input.substring(start, i);
                for (int j = word.length() - 1; j >= 0; j--) {
                    output.append(word.charAt(j));
                }

                if (i != input.length()) {
                    output.append(" ");
                }
                start = i + 1;
            }

        }
        return output.toString();
    }

    private static char getFirstNonRepeatingCharacter(String str1) {
        if (str1 == null || str1.isEmpty())
            throw new IllegalArgumentException("String should at least one character");

        char[] charArr = str1.toCharArray();

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : charArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        map.forEach((character, integer) -> System.out.println(character + " " + integer));

        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return '\0';
    }

    private static int[] find2SumMatchWithTarget(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array length must greater than or equal to 2");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = target - arr[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            map.put(arr[i], i);
        }


        return new int[]{-1, -1};
    }

    private static void findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array length must greater than or equal to 2");
        }

        int largest = Integer.MIN_VALUE;
        int sLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                sLargest = largest;
                largest = num;
            } else if (num > sLargest && num != largest) {
                sLargest = num;
            }
        }

        if (sLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second larges element found");
        }

        System.out.println("Second Largest: " + sLargest);
    }

    private static void reverseString() {
        String str = "hello";
        char[] charArr = str.toCharArray();

        int start = 0;
        int end = charArr.length - 1;
        while (start < end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;

            start++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : charArr) {
            sb.append(ch);
        }
        System.out.println("Reverse String " + sb);

    }
}
