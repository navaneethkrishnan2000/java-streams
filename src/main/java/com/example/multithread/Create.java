package com.example.multithread;

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
