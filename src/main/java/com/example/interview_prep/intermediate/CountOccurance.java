package com.example.interview_prep.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// Count occurrences of each element in a list
public class CountOccurance {
    public static void main(String[] args) {

        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        System.out.println(
                items.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),        // identity is a function that always returns its input argument - whatever we are sending it will send that
                                Collectors.counting()
                        ))
        );

    }
}
