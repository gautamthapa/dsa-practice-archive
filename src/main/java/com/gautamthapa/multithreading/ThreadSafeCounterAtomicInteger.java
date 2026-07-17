package com.gautamthapa.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounterAtomicInteger {
    static void main() throws InterruptedException {
        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 1; i <= 10000; i++) {
                counter.increment();
            }
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

        System.out.println("Counter : " + counter.getCount());
    }

}

class Counter {
    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public void decrement() {
        count.decrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
