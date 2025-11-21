package com.example.multithread.lock.reentrant_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockAccount {

    private double balance;
    private final Lock lock = new ReentrantLock(); // Create a ReentrantLock Object

    public ReentrantLockAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Withdraw money from the account
    public void withdraw(double amount) {
        lock.lock(); // Acquire the lock
        try {
            balance -= amount;
        } finally {
            lock.unlock(); // Always release the lock in a finally block
        }
    }

    // Deposit money into the account
    public void  deposit(double amount) {
        lock.lock(); // Acquire the lock
        try {
            balance += amount;
        } finally {
            lock.unlock(); // Always release the lock in a finally block
        }
    }

    // Transfer money between two accounts
    public void transfer(ReentrantLockAccount to, double amount) {
        lock.lock(); // Lock the current account
        try {
            this.withdraw(amount); // Withdraw from the current account
            to.deposit(amount); // Deposit to the other account
        } finally {
            lock.unlock(); // Always release the lock in a finally block
        }
    }

    // Get the account balance
    public double getBalance() {
        lock.lock(); // Acquire the lock
        try {
            return balance;
        } finally {
            lock.unlock(); // Always release the lock in a finally block
        }
    }
}

/**
 *  The ReentrantLock class in Java provides a more advanced version of synchronization compared to the synchronized keyword.
 *  Just like synchronized, it allows one thread to gain exclusive access to a block of code.
 *  However, the main difference is that ReentrantLock allows a thread to lock a resource it has already locked, which is why it's called reentrant.
 *  It adds an extra feature that synchronized doesn't have, like the ability to interrupt a thread or set timeouts when trying to acquire a lock.

 *  Key points: -
 *      1. ReentrantLock is more flexible than synchronized because it allows threads to re-enter the lock they already hold.
 *      2. It adds features like interruptibility and timeouts, which synchronized doesn't support.
 *      3. You must always remember to release the lock in a finally block to avoid locking problems like deadlocks.

 *  Why use ReentrantLock?
 *      - Interruptibility: Threads can be interrupted while waiting for a lock, which isn't possible with synchronized.
 *      - Timeouts: You can set timeouts for acquiring locks, avoiding situations where a thread waits forever.
 *      - Reentrancy: The same thread can acquire the lock multiple times without getting stuck.
 */
