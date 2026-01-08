package com.example.design_patterns;

/**
 * The Strategy pattern defines a family of algorithms, encapsulates each one and make them interchangeable at runtime.
 * In simple words: Behavior can be changed without changing the client code

 * Without strategy pattern:
 *      Too many if/else or switch
 *      Hard to add new behavior
 *      Violates Open-Closed Principle
 */
interface PaymentStrategy {
    void pay(double amount);
}

class CardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using CARD");
    }
}

class UpiPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class WalletPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using WALLET");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CardPayment());
        context.executePayment(500);

        context.setPaymentStrategy(new UpiPayment());
        context.executePayment(800);

        context.setPaymentStrategy(new WalletPayment());
        context.executePayment(200);
    }
}


