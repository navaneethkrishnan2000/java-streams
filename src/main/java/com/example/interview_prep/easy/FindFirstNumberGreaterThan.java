package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// find the first number greater than 10 from list
public class FindFirstNumberGreaterThan {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3,7,12,5,20);

        Optional<Integer> first = nums.stream()
                .filter(n -> n > 10)
                .sorted()
                .findFirst();
        System.out.println(first);
    }
}
