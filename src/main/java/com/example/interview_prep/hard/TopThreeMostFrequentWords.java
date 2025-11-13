package com.example.interview_prep.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;

public class TopThreeMostFrequentWords {
    public static void main(String[] args) {

        String paragraph = "Java is great great. Java is object oriented. Java streams are powerful, and Java is fun!";

        Map<String, Long> map = Arrays.stream(
                paragraph.toLowerCase()
                        .replaceAll("[^a-z\\s]", "")
                        .split(" ")
        ).collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
        ));

        System.out.println(map); // {java=4, powerful=1, are=1, and=1, streams=1, is=4, oriented=1, great=2, fun=1, object=1}

        List<Map.Entry<String, Long>> sorted = map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .toList();
        System.out.println(sorted); // [java=4, is=4, great=2, powerful=1, are=1, and=1, streams=1, oriented=1, fun=1, object=1]

        // to find the distinct counts
        List<Long> top3Frequencies = sorted.stream()
                .map(Map.Entry::getValue)
                .distinct()
                .limit(3)
                .toList();
        System.out.println(top3Frequencies); // [4, 2, 1]

        List<Map.Entry<String, Long>> entryList = sorted.stream()
                .filter(e -> top3Frequencies.contains(e.getValue()))
                .toList();
        System.out.println(entryList);

    }
}
