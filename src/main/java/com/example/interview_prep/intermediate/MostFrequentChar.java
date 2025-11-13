package com.example.interview_prep.intermediate;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Most frequent character of a string
public class MostFrequentChar {
    public static void main(String[] args) {
        String input = "banana";
        //  "banana" → ['b', 'a', 'n', 'a', 'n', 'a']

        Optional<Map.Entry<Character, Long>> max = input.chars()    // this will return the alphabetical equivalent numbers
                .mapToObj(c -> (char) c)        // we need to convert it into character using cast
                .collect(Collectors.groupingBy(    // collect it by grouping each character and count them, this will return a Map<Character, Long>
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()                         // get the Map<Character, Long> as entrySet - key value pairs
                .stream()
                .max(Map.Entry.comparingByValue());// get the max value from the map using the comparingByValue
        System.out.println(max);
    }
}

