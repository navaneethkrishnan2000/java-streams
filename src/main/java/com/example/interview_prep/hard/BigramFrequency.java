package com.example.interview_prep.hard;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Find Bigram frequencies (pairs of consecutive words) in paragraph
public class BigramFrequency {
    public static void main(String[] args) {

        String paragraph = "Java is great and Java is fun. Java is powerful!";

        /* bigrams are "java is", "is great", "great and", "and java",.... */


        String[] words = paragraph.toLowerCase() // normalize the words and punctuation
                .replaceAll("[^a-z\\s]", "")
                .split(" ");// split into words
        System.out.println(Arrays.toString(words));

        List<String> list = IntStream.range(0, words.length - 1)
                .mapToObj(i -> words[i] + " " + words[i + 1])
                .toList();
        System.out.println(list);

        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(map);
    }
}
