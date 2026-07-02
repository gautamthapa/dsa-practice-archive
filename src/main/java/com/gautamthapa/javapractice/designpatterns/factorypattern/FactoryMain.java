package com.gautamthapa.javapractice.designpatterns.factorypattern;

public class FactoryMain {
    public static void main(String[] args) {
        OperatingSystemFactory factory= new OperatingSystemFactory();
        OS androidOs= factory.getInstance("Android");
        OS iOs= factory.getInstance("IOS");
        OS windowsOs= factory.getInstance("windows");

        androidOs.spec();
        iOs.spec();
        windowsOs.spec();
    }
}
