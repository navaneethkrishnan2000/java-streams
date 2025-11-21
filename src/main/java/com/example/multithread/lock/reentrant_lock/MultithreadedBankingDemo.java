package com.example.multithread.lock.reentrant_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadedBankingDemo {
    public static void main(String[] args) {

        // Initial setup
        ReentrantLockAccount account = new ReentrantLockAccount(1000.0);
        System.out.println("Initial Balance: $" + account.getBalance());

        // We will run 10 threads, each depositing $100
        int numberOfThreads = 10;
        double depositAmount = 100.0;

        // Use an ExecutorService to manage the threads easily
        // This manages a pool of threads for us. We submit 10 deposit tasks to run concurrently.
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        // Submit tasks to the executorService
        // Lambda Expression (`() -> { ... }`) --> Each task calls the `account.deposit(100.0)` method simultaneously.
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                account.deposit(depositAmount);
            });
        }

        // Shutdown the executorService and wait for all tasks to complete
        executorService.shutdown();
        try {
             // awaitTermination: The main thread waits here until all 10 deposit threads have finished their work.
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            executorService.shutdown();
            throw new RuntimeException(e);
        }

        // Check the final balance
        System.out.println("Deposits complete.");
        System.out.println("Expected Final Balance: $" + (1000.0 + (numberOfThreads * depositAmount)));
        System.out.println("Actual Final Balance:   $" + account.getBalance());

        // Because the `deposit` method in `ReentrantLockAccount` is protected by `lock.lock()` and `lock.unlock()` calls,
        // each thread is forced to wait its turn to update the `balance` variable.
        // The final actual balance will correctly match the expected balance, demonstrating thread safety.

        // If locks were working correctly, Actual == Expected
    }
}
