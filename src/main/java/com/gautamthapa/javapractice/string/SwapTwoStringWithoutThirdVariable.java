package com.gautamthapa.javapractice.string;

public class SwapTwoStringWithoutThirdVariable {
    public static void main(String[] args) {
        String firstString = "gautam";
        String secondString = "nis";

        System.out.println("Before swapping.... ");
        System.out.println("The first String = " + firstString);
        System.out.println("The second String = " + secondString);

        firstString = firstString + secondString;
        secondString = firstString.substring(0, (firstString.length() - secondString.length()));
        firstString = firstString.substring(secondString.length());

        System.out.println("After swapping.... ");
        System.out.println("The first String = " + firstString);
        System.out.println("The second String = " + secondString);
    }
}
