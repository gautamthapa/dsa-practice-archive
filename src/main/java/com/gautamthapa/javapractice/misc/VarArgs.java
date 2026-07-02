package com.gautamthapa.javapractice.misc;

public class VarArgs {
    public static void main(String[] args) {
        fooBarMethod("foo*", "bar*");
        fooBarMethod("foo#", "bar#", "boo#");
        fooBarMethod(new String[]{"foo11", "var22", "boo33"});
    }
    public static void fooBarMethod(String... variables){
        for(String variable : variables){
            System.out.println("Variable: "+variable);
        }
    }
}
