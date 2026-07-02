package com.gautamthapa.javapractice.designpatterns.singletonpattern.method1;

// Eagerly Singleton Pattern
public class SingletonDemo {
    public static void main(String[] args) {
        Abc obj1 = Abc.getInstance();
        Abc obj2 = Abc.getInstance();
    }

}

class Abc {
    static Abc obj = new Abc();

    private Abc() {

    }

    public static Abc getInstance() {
        return obj;
    }
}
