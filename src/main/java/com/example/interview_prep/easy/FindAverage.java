package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class FindAverage {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(5,10,15,20,25);

        OptionalDouble average = OptionalDouble.of(nums.stream()
                .mapToInt(Integer::intValue) // converts the Stream of Integer objects into intStream (int value)
                .average()
                .orElse(0.0));
        System.out.println(average);
    }
}

// stream in-built methods only work on primitive datatypes like int, long, double
