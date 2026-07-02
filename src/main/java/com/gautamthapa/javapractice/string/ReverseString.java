package com.gautamthapa.javapractice.string;

public class ReverseString {
    public static void main(String[] args) {
        String inputString="Arise! Awake! and stop not until the goal is reached";
        System.out.println("The string with the reversed word is : \n"+reverseWordsFromString(inputString));
    }

    private static String reverseWordsFromString(String inputString) {
        String[] wordArray=inputString.trim().split("\\s+");
        String stringWithReverseWords="";
        for (String word: wordArray){
            stringWithReverseWords=stringWithReverseWords+" "+reverseWord(word);
        }
        return stringWithReverseWords;
    }

    private static String reverseWord(String word) {
        String reverseWord="";
        for (int i = word.length()-1; i >=0; i--) {
            reverseWord=reverseWord+word.charAt(i);
        }
        return reverseWord;
    }
}
