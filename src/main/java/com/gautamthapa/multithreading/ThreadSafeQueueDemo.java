package com.gautamthapa.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeQueueDemo {

    static void main() throws InterruptedException {

        ThreadSafeQueue queue = new ThreadSafeQueue();

        Runnable producer = () -> {
            for (int i = 1; i <= 1000; i++) {
                queue.enqueue(i);
            }
        };

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(producer);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("size : " + queue.size());
        System.out.println("deque : " + queue.dequeue());
        System.out.println("deque : " + queue.dequeue());
        System.out.println("size : " + queue.size());
    }
}

/*
Requirements
enqueue(int value)
dequeue()
size()
isEmpty()

LinkedList<Integer> as the underlying queue
ReentrantLock for synchronization
AtomicInteger for O(1) size()
* */
class ThreadSafeQueue {

    private final Queue<Integer> queue = new LinkedList<>();
    private final AtomicInteger size = new AtomicInteger(0);
    private final ReentrantLock lock = new ReentrantLock();

    public void enqueue(int value) {
        lock.lock();
        try {
            queue.offer(value);
            size.incrementAndGet();
        } finally {
            lock.unlock();
        }
    }

    public Integer dequeue() {
        lock.lock();
        try {
            if (queue.isEmpty()) {
                return null;
            }
            size.decrementAndGet();
            return queue.poll();
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
