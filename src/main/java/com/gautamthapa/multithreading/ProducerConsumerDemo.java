package com.gautamthapa.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {
    static void main() {
        ProducerConsumer1 producerConsumer1 = new ProducerConsumer1(5);
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {

                    producerConsumer1.produce(i);
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {

                    producerConsumer1.consume();
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();

    }

}

// Solution Using wait()/notifyAll()
class ProducerConsumer1 {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public ProducerConsumer1(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int item) throws InterruptedException {
        if (queue.size() == capacity) {
            wait();
        }

        queue.offer(item);
        System.out.println("Produced : " + item);

        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }

        int item = queue.poll();
        System.out.println("Consumed : " + item);

        notifyAll();

        return item;
    }

}
