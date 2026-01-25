package com.example.design_patterns.SOLID;

/**
 * Classes should be open for extension, closed for modification.

 * Bad Example - You add a new payment method → you modify existing PaymentService each time.

     class BadPaymentService {
         public void pay(String type) {
             if (type.equals("razorpay")) {
                System.out.println("Processing Razorpay Payment");
             } else if (type.equals("stripe")) {
                System.out.println("Processing Stripe Payment");
             }
             // next time: add PayPal → modify this class again
         }
     }
*/

interface PaymentStrategy {
    void pay();
}

class RazorpayPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Processing Razorpay Payment...");
    }
}

class StripePayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Processing Stripe Payment...");
    }
}

// if we need to add a new payment method, just add this
class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Processing PayPal Payment...");
    }
}

class PaymentService {
    private final PaymentStrategy paymentStrategy;

    PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() {
        paymentStrategy.pay();
    }
}

public class Open_Or_Closed_Principle {
    public static void main(String[] args) {

        PaymentService razorpayService = new PaymentService(new RazorpayPayment());
        razorpayService.processPayment();

        PaymentService stripeService = new PaymentService(new StripePayment());
        stripeService.processPayment();

        // just add this in-case it you want to add a new payment method
        PaymentService payPalService = new PaymentService(new PaypalPayment());
        payPalService.processPayment();
    }
}
