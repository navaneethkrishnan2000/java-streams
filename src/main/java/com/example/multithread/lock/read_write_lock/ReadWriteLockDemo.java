package com.example.multithread.lock.read_write_lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockAccount account = new ReadWriteLockAccount(500.0);
        ExecutorService executorService = Executors.newFixedThreadPool(15); // A pool of 15 threads

        // Task 1: A thread that writes occasionally (the "Writer" thread)
        executorService.submit(() -> {
            Random rand =  new Random();
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(rand.nextInt(500)); // Sleepy randomly
                    double depositAmount = 50.0;
                    account.deposit(depositAmount);
                    System.out.println("-> Writer deposited $" + depositAmount + ". Balance: " + account.getBalance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Task 2: Multiple threads that read the balance constantly (the "Read" operation)
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
               Random rand = new Random();
               for (int j=0; j<10; j++) {
                   try {
                       Thread.sleep(rand.nextInt(100)); // Sleepy randomly
                       // Multiple readers access this simultaneously due to readLock
                       System.out.println(Thread.currentThread().getName() + " reads balance: " + account.getBalance());
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            });
        }

        executorService.shutdown();
        if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("\nExecutor timed out before completion.");
        } else {
            System.out.println("\nDemo finished.");
        }
        System.out.println("Final Balance: $" + account.getBalance());
    }
}


