package com.example.coding_questions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurrenceOfEachCharacterInAString {
    public static void main(String[] args) {
        String s = "banana";

//        usingStream(s);
        usingMap(s);

    }

    private static void usingMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
    }

    private static void usingStream(String s) {
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
