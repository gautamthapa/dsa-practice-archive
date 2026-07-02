package com.gautamthapa.javapractice.multithreading;

public class ThreadWithoutRunMethod {
    public static void main(String[] args) {
        MyThread t=new MyThread();
        t.start();
    }
}

class MyThread extends Thread {
}