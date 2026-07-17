package com.gautamthapa.coding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenTwoThread {
    private static volatile boolean isOddTurn = true;

    static void main() {
        // Using Executor Framework
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable printOdd = () -> {
            for (int i = 5; i <= 20; i += 2) {
                synchronized (OddEvenTwoThread.class) {
                    while (!isOddTurn) {
                        try {
                            OddEvenTwoThread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Odd numbers : " + i + " - " + Thread.currentThread().getName());
                    isOddTurn = false;
                    OddEvenTwoThread.class.notify();
                }
            }
        };

        // print even
        Runnable printEven = () -> {
            for (int i = 6; i <= 20; i += 2) {
                synchronized (OddEvenTwoThread.class) {
                    while (isOddTurn) {
                        try {
                            OddEvenTwoThread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Even numbers : " + i + " - " + Thread.currentThread().getName());
                    isOddTurn = true;
                    OddEvenTwoThread.class.notify();
                }
            }
        };

        executorService.submit(printOdd);
        executorService.submit(printEven);

        executorService.shutdown();


    }
}
