package com.example.multithread;

/**
 * We can create threads in java using 2 ways:
 *  1. Extending the Thread class from java.lang.thread and override its run() method.
 *      Then call start() to run in a new thread.
 *      Do not support Single Inheritance
 *
 *  2. Implementing the Runnable Interface from java.lang.runnable
 *      Preferred approach, as it allows only Single Inheritance
 */

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable is running");
    }
}

public class Create {
    public static void main(String[] args) {
        new MyThread().start();

        new MyRunnable().run();
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
