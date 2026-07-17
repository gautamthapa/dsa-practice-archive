package com.gautamthapa.multithreading;

public class SingletonThreadSafeDoubleChecking {
    static void main() throws InterruptedException {

        // Double Checking
        System.out.println("** Double Checking **");
        Runnable task = () -> {
            SingletonDoubleChecking singleton = SingletonDoubleChecking.getInstance();
            System.out.println("HashCode : " + singleton.hashCode());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();


        // Holder Idiom
        System.out.println("** Holder Idiom **");
        Runnable taskHolder = () -> {
            SingletonHolderIdiom singleton = SingletonHolderIdiom.getInstance();
            System.out.println("HashCode : " + singleton.hashCode());
        };

        Thread th1 = new Thread(taskHolder);
        Thread th2 = new Thread(taskHolder);
        Thread th3 = new Thread(taskHolder);

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

    }
}

class SingletonHolderIdiom {
    private SingletonHolderIdiom() {
    }

    private static class Holder {
        private static final SingletonHolderIdiom INSTANCE = new SingletonHolderIdiom();
    }

    public static SingletonHolderIdiom getInstance() {
        return Holder.INSTANCE;
    }

}

class SingletonDoubleChecking {
    private static volatile SingletonDoubleChecking instance;

    private SingletonDoubleChecking() {

    }

    public static SingletonDoubleChecking getInstance() {
        if (instance == null) { // First Check
            synchronized (SingletonDoubleChecking.class) {
                if (instance == null) { // Second Check
                    instance = new SingletonDoubleChecking();
                }
            }
        }
        return instance;
    }

}
