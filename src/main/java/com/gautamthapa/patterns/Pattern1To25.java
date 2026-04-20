package com.gautamthapa.patterns;

public class Pattern1To25 {
    public static void main(String[] args) {
        printPattern1To25_1(5);
        printPattern1To25_2(5);
    }

    private static void printPattern1To25_2(int num) {
        System.out.println("printPattern1To25_2 *** ");
        for(int row = 1; row <= num; row++){
            int count = (row-1)*num+1;
            for(int col = 1; col <= num; col++){
                System.out.print(count+ " ");
                count++;
            }
            System.out.println();
        }

    }

    private static void printPattern1To25_1(int number) {
        System.out.println("printPattern1To25_1 *** ");
        int count = 1;
        for (int row = 1; row <= number; row++) {
            for (int col = 1; col <= number; col++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }
}
