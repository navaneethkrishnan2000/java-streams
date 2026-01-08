package com.example.study.strategy;

public class Stripe implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid through stripe");
    }
}
