package com.gautamthapa.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeStackDemo {

    static void main() throws InterruptedException {
        ThreadSafeStack stack = new ThreadSafeStack();

        Runnable task = () -> {
            for (int i = 1; i <= 1000; i++) {
                stack.push(i);
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

        System.out.println("Size : " + stack.size());
        System.out.println("Top : " + stack.peek());
        System.out.println("Pop : " + stack.pop());
        System.out.println("New size : " + stack.size());

    }
}

/*
We'll use:

ArrayList<Integer> as the underlying storage
ReentrantLock for synchronization
AtomicInteger for O(1) size()

A stack follows LIFO (Last In, First Out).

Implement:

push(int value)
pop()
peek()
size()
isEmpty()

All operations must be thread-safe.

* */
class ThreadSafeStack {

    private final List<Integer> stack = new ArrayList<>();

    private final AtomicInteger size = new AtomicInteger(0);

    private final ReentrantLock lock = new ReentrantLock();

    public void push(int value) {
        lock.lock();
        try {
            stack.add(value);

            size.incrementAndGet();
        } finally {
            lock.unlock();
        }
    }

    public Integer pop() {
        lock.lock();
        try {
            if (stack.isEmpty()) {
                return null;
            }
            size.decrementAndGet();

            return stack.remove(stack.size() - 1);
        } finally {
            lock.unlock();
        }
    }

    public Integer peek() {
        lock.lock();
        try {

            if (stack.isEmpty()) {
                return null;
            }

            return stack.get(stack.size() - 1);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return size.get();
    }

    public boolean isEmpty() {
        return size.get() == 0;
    }

}