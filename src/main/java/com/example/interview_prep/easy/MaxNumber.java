package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;

public class MaxNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5,10,2,8,20);

        Integer max = numbers.stream()
//                .reduce(0, (a, b) -> Integer.max(a, b));
                .reduce(0, Integer::max);
        System.out.println(max);
    }
}
