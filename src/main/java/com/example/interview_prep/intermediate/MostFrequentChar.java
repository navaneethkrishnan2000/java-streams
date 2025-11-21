package com.example.interview_prep.intermediate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

// Most frequent character of a string
public class MostFrequentChar {
    public static void main(String[] args) {
        String input = "banana";
        //  "banana" → ['b', 'a', 'n', 'a', 'n', 'a']

        usingStream(input);
        usingMap(input);
    }

    private static void usingMap(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        char mostFrequentChar = 0;
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentChar = entry.getKey();
            }
        }
        System.out.println("Most Frequent character : " + mostFrequentChar + " | Count : " + maxCount);
    }

    private static void usingStream(String input) {
        Optional<Map.Entry<Character, Long>> max = input.chars()    // this will return the alphabetical equivalent numbers
                .mapToObj(c -> (char) c)        // we need to convert it into character using cast
                .collect(Collectors.groupingBy(    // collect it by grouping each character and count them, this will return a Map<Character, Long>
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()                         // get the Map<Character, Long> as entrySet - key value pairs
                .stream()
                .max(Map.Entry.comparingByValue());// get the max value from the map using the comparingByValue
        System.out.println(max.get());
    }
}

