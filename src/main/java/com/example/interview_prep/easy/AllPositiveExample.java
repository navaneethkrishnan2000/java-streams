package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;

// Check if all elements are positive numbers
public class AllPositiveExample {
    public static void main(String[] args) {

//        List<Integer> nums = Arrays.asList(5,10,15,20,25); // true
        List<Integer> nums = Arrays.asList(5,10,15,-20,25);  // false

        boolean allMatch = nums.stream()
                .allMatch(n -> n > 0);

        System.out.println(allMatch);
    }
}
