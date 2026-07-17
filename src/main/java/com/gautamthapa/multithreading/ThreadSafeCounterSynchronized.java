package com.gautamthapa.multithreading;

public class ThreadSafeCounterSynchronized {
    static void main() throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();

        Runnable task = () -> {
            for (int i = 1; i <= 10000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Thread t3 = new Thread(task, "T3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Count : " + counter.getCount());
    }
}

class SynchronizedCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
