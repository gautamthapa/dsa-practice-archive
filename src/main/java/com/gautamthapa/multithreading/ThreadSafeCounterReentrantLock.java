package com.gautamthapa.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCounterReentrantLock {
    static void main() throws InterruptedException {
        ReentrantCounter counter = new ReentrantCounter();

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

class ReentrantCounter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }

    }
}
