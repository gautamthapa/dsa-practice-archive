package com.gautamthapa.javapractice.misc;

public class FibonacciSeries {

    public static void main(String[] args) {
        int totalCount = 10;

        int num1 = 0, num2 = 1, counter = 0;
        while (counter < totalCount) {
            System.out.println(num1 + " ");
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            counter++;
        }
    }
}
