package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;

// Check any number is divisible by a number
public class NumberDivisibleBy {
    public static void main(String[] args) {
//        List<Integer> nums = Arrays.asList(5,7,2,9,10,14);    // true
        List<Integer> nums = Arrays.asList(5,7,2,10,14);        // false

        boolean match = nums.stream()
                .anyMatch(n -> n % 3 == 0);
        System.out.println(match);
    }
}
