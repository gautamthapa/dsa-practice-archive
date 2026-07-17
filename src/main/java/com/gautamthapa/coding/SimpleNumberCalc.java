package com.gautamthapa.coding;

public class SimpleNumberCalc {
    static void main() {
        System.out.println("Input is 7 : " + calcNum(7));
        System.out.println("Input is 11 : " + calcNum(11));
    }

    // Do not use if else condition
    public static int calcNum(int num) {
        // write logic to return, 7-11, 11-7
        return 7 + 11 - num;
    }
}
