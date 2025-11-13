package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Join all strings in a list into a single comma-separated string
public class JoinStringExample {
    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("Apple", "Banana", "Mango", "Orange", "Grape", "Kiwi");

        String collected = fruits.stream()
                .collect(Collectors.joining(",")); // Apple,Banana,Mango,Orange,Grape,Kiwi
//                .collect(Collectors.joining(",", "[","]")); // [Apple,Banana,Mango,Orange,Grape,Kiwi]
        System.out.println(collected);
    }
}
