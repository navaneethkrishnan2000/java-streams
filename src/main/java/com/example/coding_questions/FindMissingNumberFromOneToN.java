package com.example.coding_questions;

public class FindMissingNumberFromOneToN {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5};

        int n = arr.length + 1; // since one number is missing
        int expectedSum = n*(n+1)/2;
        int actualSum = 0;
        for(int a : arr) {
            actualSum += a;
        }

        System.out.println(expectedSum - actualSum);
    }
}
