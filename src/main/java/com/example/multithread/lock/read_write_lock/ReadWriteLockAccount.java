package com.example.multithread.lock.read_write_lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockAccount {
    private double balance;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public ReadWriteLockAccount(double intitialBalance) {
        this.balance = intitialBalance;
    }

    // Withdraw money (write operation)
    public boolean withdraw(double amount) {
        readWriteLock.readLock().lock(); // Acquire the write lock
        try {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        } finally {
            readWriteLock.readLock().unlock(); // Always release the lock
        }
    }

    // Deposit money (write operation)
    public boolean deposit(double amount) {
        readWriteLock.writeLock().lock(); // Acquire the write lock
        try {
            balance += amount;
            return true;
        } finally {
            readWriteLock.writeLock().unlock(); // Always release the lock
        }
    }

// Transfer money between two accounts is complex to do correctly with ReadWriteLock,
// as it requires locking two different accounts simultaneously to prevent deadlock.
// We omit it here for simplicity and focus on basic read/write operations
// Transfer money between two accounts (write operation)

//    public boolean transfer(ReadWriteLockAccount to, double amount) {
//        readWriteLock.writeLock().lock(); // Acquire the write lock
//        try {
//            if (!this.withdraw(amount)) return false; // Withdraw from this account
//            return to.deposit(amount); // Deposit into the other account
//        } finally {
//            readWriteLock.writeLock().unlock(); // Always release the lock
//        }
//    }

    // Get the account balance (read operation)
    public double getBalance() {
        readWriteLock.readLock().lock(); // Acquire the write lock
        try {
            return balance;
        } finally {
            readWriteLock.readLock().unlock();  // Always release the lock
        }
    }
}

/**
 *  How It Works:
 *   - Read Lock: When we just need to check the balance (as in the getBalance() method), we use the read lock.
 *                This lock allows multiple threads to access the data at the same time.
 *     Read lock allows multiple threads to acquire the readLock simultaneously. They don't have to wait for one another.
 *     They all see the initial balance of 500.0 because the writer hasn't made its first update yet

 *   - Write Lock: For operations that modify the balance (like withdraw() or deposit()), we use the write lock.
 *                 This is exclusive: only one thread can write at a time, ensuring that no other threads can interfere with the data while it's being changed.
 *     When the writer thread calls account.deposit(), it acquires the writeLock.
 *     This action momentarily blocks all other threads (both readers and writers) from accessing the balance until the write lock is released.
 *     This ensures that the deposit operation is atomic and the balance update is visible to the next set of readers
 */
