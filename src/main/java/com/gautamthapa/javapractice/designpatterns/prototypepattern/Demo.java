package com.gautamthapa.javapractice.designpatterns.prototypepattern;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop bookShop=new BookShop();
        bookShop.setShopName("Pustak Bhandar");
        bookShop.loadData();

        BookShop bookShop2= bookShop.clone();
        bookShop2.setShopName("New Book Store");
        System.out.println("1st Object");
        System.out.println(bookShop);
        System.out.println("2nd Object");
        System.out.println(bookShop2);
    }
}
