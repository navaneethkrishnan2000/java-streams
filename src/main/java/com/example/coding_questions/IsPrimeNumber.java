package com.example.coding_questions;

public class IsPrimeNumber {
    public static void main(String[] args) {
        int num = 50;

//        if (num <= 1) System.out.println(num + " is not prime");
//        if (num == 2) System.out.println(num + " is prime");
//        if (num % 2 == 0) System.out.println(num + " is not prime");
//
//        for (int i = 3; i * i <= num; i+=2) {
//            if (num % i == 0) {
//                System.out.println(num + " is not prime");
//            }
//        }
//        System.out.println(num + " is prime");

        int count = 0;
        if (num > 1) {

            for (int i = 1; i <= num; i++) {
                if (num%i==0) count++;
            }

            if (count == 2) System.out.println(num+" is a prime number");
                else System.out.println(num+" is not prime number");
        } else {
            System.out.println(num + " is not prime");
        }

        // 3
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n<=1) return false;
        if (n==2) return true;
        if (n%2==0) return false;

        for (int i=3; i<= Math.sqrt(n); i++) {
            if (n%i==0) return false;
        }
        return true;
    }
}
