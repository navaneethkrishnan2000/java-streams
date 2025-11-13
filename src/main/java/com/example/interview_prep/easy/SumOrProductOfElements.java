package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;

public class SumOrProductOfElements {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        Integer sum = nums.stream()
                .reduce(0, Integer::sum);

        Integer product = nums.stream()
                .reduce(1, (a,b) -> a*b);

        System.out.println(sum);
        System.out.println(product);
    }
}
