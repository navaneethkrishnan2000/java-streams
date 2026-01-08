package com.example.study.strategy;

public class Strategy {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(new Stripe());
        paymentService.processPayment(500);
    }
}
