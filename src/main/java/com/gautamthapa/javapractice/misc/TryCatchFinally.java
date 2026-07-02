package com.gautamthapa.javapractice.misc;

public class TryCatchFinally {
    //1. we can  not write alone try block it give compilation error
    //2. We can write code try with finally without catch block
    public static void main(String[] args) {
        try{
            System.out.println("hello");
        }finally {
            System.out.println("test");
        }
    }
}
