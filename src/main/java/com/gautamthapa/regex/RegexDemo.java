package com.gautamthapa.regex;

public class RegexDemo {
    static void main() {
        // Print only numbers by eliminating all other characters from String.
        String s1 = "1,1,4,5@3,1{6,7,4,8,9,3,4:5:7:?5?9?3?5?6,2";

        System.out.println("Numbers only : "+s1.replaceAll("\\D",""));
    }
}
