package com.gautamthapa.leetcode;

public class LeapYear {
    static void main() {
        int year = 2096;
        System.out.println("Is Leap Year: " + year + " = " + isLeapYear(year));
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        else if (year % 4 == 0 && year % 100 != 0)
            return true;
        else
            return false;
    }
}
