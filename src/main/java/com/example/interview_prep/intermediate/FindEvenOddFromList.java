package com.example.interview_prep.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindEvenOddFromList {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> collect = nums.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even : " + collect.get(true));
        System.out.println("Odd : " + collect.get(false));
    }
}
