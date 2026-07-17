package com.gautamthapa.jvm;

public class DeadlockDemo {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    static void main() {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                sleep();
                synchronized (lock2) {

                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                sleep();
                synchronized (lock1) {

                }
            }
        });

        t1.start();
        t2.start();
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }
}
