package com.gautamthapa.javapractice.designpatterns.factorypattern;

public class Windows implements OS{
    @Override
    public void spec() {
        System.out.println("Windows I am about to die.");
    }
}
