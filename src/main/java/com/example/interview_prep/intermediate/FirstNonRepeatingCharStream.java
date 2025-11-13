package com.example.interview_prep.intermediate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

// Find the first non-repeating character in string
public class FirstNonRepeatingCharStream {
    public static void main(String[] args) {
        String str = "swiss";

        // to find the first non-repeating character in string - option 1
        Optional<Map.Entry<Character, Long>> firstNonRepeatingChar1 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new, // to preserve insertion order, without this, the collect function will return the HashMap_which does not preserve the insertion order. that is why we used LinkedHashMap
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue());
        System.out.println(firstNonRepeatingChar1);

        // to find the first non-repeating character in string - option 2
        Optional<Map.Entry<Character, Long>> firstNonRepeatingChar2 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst();
        System.out.println(firstNonRepeatingChar2);

        // to find the second non-repeating character in string - option 1
        Optional<Character> secondNonRepeatingChar1 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .skip(1)
                .findFirst();
        System.out.println(secondNonRepeatingChar1);
    }
}
