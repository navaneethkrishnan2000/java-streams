package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;

public class FilterEvenNum {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> even = nums.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(even);

    }
}
