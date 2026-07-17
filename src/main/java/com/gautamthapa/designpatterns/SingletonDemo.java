package com.gautamthapa.designpatterns;

public class SingletonDemo {
    private static volatile SingletonDemo instance;

    // Private constructor
    private SingletonDemo() {
        System.out.println("Instance Created ...");
    }

    // Double-checked Locking
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}


