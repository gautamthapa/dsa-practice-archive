package com.gautamthapa.javapractice.pattern;

public class Pyramid {

    public static void main(String[] args) {
        System.out.println("Pyramid:-");
        int num = 5;
        printPyramidMethod1(num);
        printPyramidMethod2(num);
        printPyramidMethod3(num);

    }

    private static void printPyramidMethod3(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 2 * (num - 1); j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    private static void printPyramidMethod2(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    private static void printPyramidMethod1(int num) {

        for (int i = 0; i < num; i++) //outer loop for number of rows(n)
        {
            for (int j = num - i; j > 1; j--) //inner loop for spaces
            {
                System.out.print(" "); //print space
            }
            for (int j = 0; j <= i; j++) //inner loop for number of columns
            {
                System.out.print(" *"); //print star
            }

            System.out.println(); //ending line after each row
        }
    }
}
