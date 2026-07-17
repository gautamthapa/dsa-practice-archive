package com.gautamthapa.javapractice.oops.abstraction;

public interface InterfaceA {
    default void showNotification(){
        System.out.println("InterfaceA");
    }
}
