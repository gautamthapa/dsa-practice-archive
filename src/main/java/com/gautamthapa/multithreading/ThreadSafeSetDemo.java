package com.gautamthapa.multithreading;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
Fix this problem -
Create data structure that works on multi threaded environment. Must follow these functionality.
void add(int value) - add int value on data structure
Boolean contains(int value) - can check value exists or not
Int size() - can get size of data structure

NOTE: do not follow concurrent collections, like ConcurrentHashMap, CopyOnWriteArrayList
You can use RentrantLock and Atomic Integer kinds of.

* */

public class ThreadSafeSetDemo {
    static void main() throws Exception {
        // Via ExecutorService
        ThreadSafeSet set = new ThreadSafeSet();
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            service.submit(() -> {
                for (int j = 1; j <= 1000; j++) {
                    set.add(j);
                }
            });
        }

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Size : " + set.size());

    }
}

class ThreadSafeSet {
    private final Set<Integer> set = new HashSet<>();
    private final AtomicInteger size = new AtomicInteger(0);
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(int value) {
        lock.writeLock().lock();
        try {
            if (set.add(value)) {
                size.incrementAndGet();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean contains(int value) {
        lock.readLock().lock();
        try {
            return set.contains(value);
        } finally {
            lock.readLock().unlock();
        }
    }

    public int size() {
        return size.get();
    }
}