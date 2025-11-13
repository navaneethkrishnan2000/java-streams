package com.example.interview_prep.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Group a list of words by their length using streams
public class GroupByLength {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "bat", "ball", "cat", "banana", "dog","goat");

        System.out.println(
                words.stream()
                    .collect(
                            Collectors.groupingBy(String::length) //{3=[bat, cat, dog], 4=[ball, goat], 5=[apple], 6=[banana]}
                    )
        );

    }
}
