package com.gautamthapa.javapractice.designpatterns.singletonpattern.method4;

// Singleton using Double check Locking
public class SingletonDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Abc Obj1 = Abc.getInstance();
        });
        Thread t2 = new Thread(() -> {
            Abc Obj2 = Abc.getInstance();
        });
        t1.start();
        t2.start();
    }
}


class Abc {
    public static Abc obj;

    private Abc() {
        System.out.println("Instance Created!!!");
    }

    public static Abc getInstance() {
        if (obj == null) {
            synchronized (Abc.class) {
                if (obj == null) {
                    obj = new Abc();
                }
            }
        }
        return obj;
    }

}
