package com.gautamthapa.javapractice.oops.abstraction;

public class InterfaceABImplClass implements InterfaceA, InterfaceB{
    @Override
    public void showNotification() {
        InterfaceA.super.showNotification();
    }
}
