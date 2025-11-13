package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;

public class CountGreaterThan {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,6,3,8,10,1);

        long count = nums.stream()
                .filter(n -> n > 5)
                .count();
        System.out.println(count);

    }
}
