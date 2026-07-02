package com.gautamthapa.javapractice.string;

public class ReverseWord {
    public static void main(String[] args) {
        String s1 = "gautam";
        reverseStringWithoutReverseMethod(s1);
        reverseStringWithReverseMethod(s1);
    }

    private static void reverseStringWithReverseMethod(String s1) {
        System.out.println("*** reverseStringWithReverseMethod ***");
        System.out.println("Reversed String: " + new StringBuilder(s1).reverse());
    }

    private static void reverseStringWithoutReverseMethod(String s1) {
        System.out.println("*** reverseStringWithoutReverseMethod ***");
        String reversedString = "";
        for (int i = s1.length() - 1; i >= 0; i--) {
            reversedString += s1.charAt(i);
        }
        System.out.println("Reversed String: " + reversedString);
    }
}
