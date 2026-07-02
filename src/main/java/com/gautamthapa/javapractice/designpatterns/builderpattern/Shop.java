package com.gautamthapa.javapractice.designpatterns.builderpattern;

public class Shop {
    public static void main(String[] args) {
//        Phone phone=new Phone("Android",8,"Mediatek",6.0,10000);
//        System.out.println(phone.toString());

        Phone phone=new PhoneBuilder()
                .setOs("Android")
                .setProcessor("Mediatek")
                .setBattery(5000)
                .setRam(8)
                .setScreenSize(5.6)
                .getPhone();
        Phone phone2=new PhoneBuilder()
                .setOs("Android")
                .setBattery(5000)
                .setRam(8)
                .getPhone();

        System.out.println(phone.toString());
        System.out.println(phone2.toString());
    }
}
