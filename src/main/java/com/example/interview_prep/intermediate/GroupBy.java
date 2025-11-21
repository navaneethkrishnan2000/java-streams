package com.example.interview_prep.intermediate;

import java.util.*;
import java.util.stream.Collectors;

// Group a list of words by their length using streams
public class GroupBy {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "bat", "ball", "cat", "banana", "dog","goat");

        groupByLengthUsingStream(words); // O(n)
        groupByLengthUsingMap(words); // O(n)
        groupByLengthSorted(words);

        groupByFirstLetterUsingStream(words);
        groupByFirstLetterUsingMap(words);

        // group by last character: word.charAt(word.length() - 1)

        groupByVowelCountUsingStream(words);

    }

    private static void groupByVowelCountUsingStream(List<String> words) {
        Map<Integer, List<String>> collect = words.stream()
                .collect(
                        Collectors.groupingBy(
                                w -> (int) w.chars()
                                        .mapToObj(c -> (char) c)
                                        .filter(c -> "aeiou".indexOf(c) != -1)
                                        .count()
                        )

                );
        System.out.println(collect);
    }

    private static void groupByFirstLetterUsingMap(List<String> words) {
        Map<Character, List<String>> map = new HashMap<>();
        for (String word : words) {
            char firstLetter = word.charAt(0);
            map.computeIfAbsent(firstLetter, k -> new ArrayList<>()).add(word);
        }
        System.out.println(map);
    }

    private static void groupByFirstLetterUsingStream(List<String> words) {
        Map<Character, List<String>> collect = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println(collect);
    }

    private static void groupByLengthSorted(List<String> words) {
        Map<Integer, List<String>> result = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toList()
                ));
        System.out.println(result);
    }

    private static void groupByLengthUsingMap(List<String> words) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String word : words) {
            int len = word.length();
            map.computeIfAbsent(len, k -> new ArrayList<>()).add(word);
        }
        System.out.println(map);

        /**
         *  map.computeIfAbsent(len, k -> new ArrayList<>()).add(word);
         *  1.  map.computeIfAbsent(len, ...): This method checks if a mapping for the key len already exists in the map.
         *  2.  k -> new ArrayList<>(): This is a lambda expression(a supplier function).
         *      it only executes if the key (len) is not already present in the map.
         *      If the key is missing, it creates a new ArrayList to hold words of that length.
         *  3.  .add(word): This method call is chained to the result of computeIfAbsent. Whether a new list was created or an existing one was retrieved, the current word is added to that list.
         */
    }

    private static void groupByLengthUsingStream(List<String> words) {
        Map<Integer, List<String>> groupByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupByLength);
        //{3=[bat, cat, dog], 4=[ball, goat], 5=[apple], 6=[banana]}

    }
}
