package com.gautamthapa.javapractice.oops.abstraction;

public interface InterfaceB {
    default void showNotification(){
        System.out.println("InterfaceA");
    }
}
