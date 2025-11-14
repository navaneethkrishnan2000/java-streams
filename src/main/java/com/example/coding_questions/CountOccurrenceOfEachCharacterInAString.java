package com.example.coding_questions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurrenceOfEachCharacterInAString {
    public static void main(String[] args) {
        String s = "banana";

        LinkedHashMap<Character, Long> collect = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        System.out.println(collect);

    }
}
