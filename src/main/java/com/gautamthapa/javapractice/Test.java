package com.gautamthapa.javapractice;

public class Test {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            int sqrt = (int) Math.sqrt(i);
//            System.out.println("Square: " + sqrt);
//        }
        someMethod(10);
    }

    public static int someMethod(int i) {
        try {
            //some statement
            System.out.println("return 1");
            return 1;
        } catch (Exception e) {
            //some statement
            System.out.println("return 999");
            return 999;
        } finally {
            //finally block statements
            System.out.println("finally block");
        }
    }
}
