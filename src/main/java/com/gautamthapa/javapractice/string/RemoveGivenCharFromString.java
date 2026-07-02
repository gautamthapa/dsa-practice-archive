package com.gautamthapa.javapractice.string;

public class RemoveGivenCharFromString {
    public static void main(String[] args) {
        String inputString = "gautamthapa";
        String ch = "a";
        String result = removeCharactersFromString(inputString, ch);
        System.out.println("After removing character '" + ch + "' from the inputString '" + inputString
                + "' the result will be : \n" + result);
    }

    private static String removeCharactersFromString(String inputString, String ch) {
        return inputString.replace(ch, "");
    }
}
