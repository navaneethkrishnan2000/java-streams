package com.example.coding_questions.factorial_recurrsion;

import java.util.stream.LongStream;

public class Factorial {
    public static void main(String[] args) {

        long num = 5L;

        // Approach 1
        long fact = 1;
        for (int i = 1; i <= num ; i++) {
            fact *= i;
        }
        System.out.println("Factorial using approach 1: " + fact);

        // Approach 2 -> recursion
        System.out.println("Factorial using approach 2: " + factorial(num));

        // Approach 3 -> streams
        long f = LongStream.rangeClosed(1, num)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Factorial using approach 3ran: " + f);
    }

    static long factorial(long n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n-1);
    }
}

