package com.gautamthapa.leetcode;

/*
Time Complexity - O(1)
- Because of - only one arithmetic operation, no loop, no recursion and no iteration depending on input size

Space Complexity - O(1)
- Because of - Only fixed variables used: input, no array, no collections, no dynamic memory and no recursion

This uses ASCII character arithmetic by leveraging the fixed ASCII difference between lowercase and uppercase letters.
* */
public class ConvertCharSmallToCaps {
    static void main() {
        char input = 'd';
        System.out.println("Capital of " + input + " : " + convertCharSmallToCaps(input));
    }

    private static char convertCharSmallToCaps(char input) {
        return (char) (input - 'a' + 'A');
    }
}