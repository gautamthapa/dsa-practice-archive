package com.gautamthapa.javapractice.designpatterns.singletonpattern.method5;

// Singleton using enum
// thread safe and takes less amount of resource
public class SingletonDemo {
    public static void main(String[] args) {
        Abc obj1 = Abc.INSTANCE;
        obj1.i = 5;
        obj1.show();

        Abc obj2 = Abc.INSTANCE;
        obj2.i = 10;
        obj2.show();
    }
}

enum Abc {  // special type of class
    INSTANCE;
    int i;

    public void show() {
        System.out.println(i);
    }
}
