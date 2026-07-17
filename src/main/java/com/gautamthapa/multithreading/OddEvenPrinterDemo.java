package com.gautamthapa.multithreading;

class OddEvenPrinter {
    private int number = 1;
    private final int limit;

    public OddEvenPrinter(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() throws InterruptedException {
        while (number <= limit) {

            while (number % 2 == 0) {
                wait();
            }

            if (number <= limit) {
                System.out.println(Thread.currentThread().getName() + " : " + number);
                number++;
                notifyAll();
            }

            notifyAll();
        }
    }

    public synchronized void printEven() throws InterruptedException {

        while (number <= limit) {

            while (number % 2 != 0) {
                wait();
            }

            if (number <= limit) {
                System.out.println(Thread.currentThread().getName() + " : " + number);
                number++;
                notifyAll();
            }


            notifyAll();
        }
    }
}

public class OddEvenPrinterDemo {
    static void main() {
        OddEvenPrinter printer = new OddEvenPrinter(10);
        Thread odd = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Odd");

        Thread even = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Even");

        odd.start();
        even.start();
    }
}
