package com.example.study.strategy;

public class Razorpay implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid through razorpay");
    }
}
