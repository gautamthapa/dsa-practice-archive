package com.gautamthapa.javapractice.oops.polymorphism.overloading;

public class MethodOverloadingTypePromotionInteger {

    private void m1(int i) {
        System.out.println("m1 int");
    }

    private void m1(Integer i) {
        System.out.println("m1 Integer");
    }

    private void m1(int... a) {
        System.out.println("m1 int varargs");
    }

    public static void main(String[] args) {
        MethodOverloadingTypePromotionInteger ob = new MethodOverloadingTypePromotionInteger();

        // in this case calls exact same parameter method
        ob.m1(1);
        ob.m1(1,2);
    }
}
