package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;

public class SquareNumbers {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        List<Integer> squares = nums.stream()
                .map(n -> n * n)
                .toList();
        System.out.println(squares);

    }
}
