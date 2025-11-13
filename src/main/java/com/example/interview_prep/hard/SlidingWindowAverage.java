package com.example.interview_prep.hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// Given a list of integers, compute the average of every 3-element siding window
public class SlidingWindowAverage {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(4,8,15,16,23,42);

        // n-(s-1) -> n= length of the list, s= size of the sliding window(3)

        int windowSize = 3;

        List<Double> list = IntStream.range(0, (nums.size() - (windowSize - 1))) // 2 because the size of the window is 3 so s-1 = 3-1 = 2
                .mapToObj(i -> nums.subList(i, i + windowSize))
                .map(window -> window.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0)
                )
                .toList();

        System.out.println(list); // [9.0, 13.0, 18.0, 27.0]
    }
}
