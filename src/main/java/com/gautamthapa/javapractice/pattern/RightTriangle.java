package com.gautamthapa.javapractice.pattern;

public class RightTriangle {

    public static void main(String[] args) {

        printRightTriangle(5);
    }

    public static void printRightTriangle(int num){
        System.out.println("RightTriangle:-");
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
