package com.gautamthapa.javapractice.misc;

class Parent {
    public static void main(String[] args) {
        System.out.println("Parent");
    }
}

public class OverrideMainMethod extends Parent {

//    @Override
    public static void main(String[] args) {
        System.out.println("Child");
    }
}
