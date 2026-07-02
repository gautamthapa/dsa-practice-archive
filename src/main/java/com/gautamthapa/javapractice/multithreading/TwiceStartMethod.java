package com.gautamthapa.javapractice.multithreading;

public class TwiceStartMethod extends Thread{
    @Override
    public void run() {
        System.out.println("thread 1");
    }

    public static void main(String[] args) {
        TwiceStartMethod t1=new TwiceStartMethod();
        t1.start();
        t1.start();
    }
}
