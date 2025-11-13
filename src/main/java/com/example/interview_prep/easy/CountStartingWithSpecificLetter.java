package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;

// Count how many strings start with a specific letter
public class CountStartingWithSpecificLetter {
    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("Apple", "Banana", "Avocado", "Mango", "Apricot");
        long count = fruits.stream()
                .filter(f -> f.startsWith("A"))
                .count();

        System.out.println(count);

    }
}
