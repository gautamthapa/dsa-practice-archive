package com.gautamthapa.javapractice.oops.polymorphism.overloading;

public class MethodOverloadingTypePromotionString {

    public void m1(Object obj) {
        System.out.println("m1 Object");
    }

    public void m1(String s) {
        System.out.println("m1 String");
    }

    public static void main(String[] args) {
        MethodOverloadingTypePromotionString t = new MethodOverloadingTypePromotionString();

        // this case method calls of String one because - null string represented as null
        t.m1(null);
    }
}

