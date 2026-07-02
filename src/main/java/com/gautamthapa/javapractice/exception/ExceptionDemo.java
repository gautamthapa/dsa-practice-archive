package com.gautamthapa.javapractice.exception;

public class ExceptionDemo {
    static void avg() throws ArithmeticException{
        System.out.println("Inside avg function");
        throw new ArithmeticException("test");
    }

    public static void main(String[] args) {
        avg();
    }
}
