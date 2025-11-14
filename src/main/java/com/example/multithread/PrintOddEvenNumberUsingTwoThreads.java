package com.example.multithread;

public class PrintOddEvenNumberUsingTwoThreads {
    public static void main(String[] args) {
        Printer printer = new Printer(10);

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }
}

class Printer {
    private int number = 1;
    private final int limit;

    public Printer(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {
        while (number <= limit) {
            while (number % 2 == 0) { // Not odd -> wait
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Odd  : " + number);
            number++;
            notify(); // wake up even thread
        }
    }

    public synchronized void printEven() {
        while (number <= limit) {
            while (number%2!=0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Even : " + number);
            number++;
            notify(); // Wake up odd thread
        }
    }
}
