package com.example.interview_prep.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestStringInAList {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "watermelon");

        // 1
//        Optional<Map.Entry<String, Integer>> longest = words.stream()
//                .collect(Collectors.toMap(
//                        Function.identity(),
//                        String::length
//                ))
//                .entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue());

        // 2
//        String longest ="";
//        for(String s : words) {
//            if(s.length() > longest.length()) {
//                longest = s;
//            }
//        }

        // 3
        String longest = words.stream()
                        .reduce("", (w1, w2) -> w1.length() >= w2.length() ? w1 : w2);
        System.out.println(longest);
    }
}
