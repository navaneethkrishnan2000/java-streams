package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;

// Sum of squares of even numbers in a list
public class EvenSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Integer evenSum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(evenSum);
    }
}
