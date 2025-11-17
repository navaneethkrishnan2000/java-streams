package com.example.interview_prep.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicate_IBS_interview {
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = {3, 4, 5};
        int[] c = {4, 5, 6};

        List<Integer> collect = Stream.of(a, b, c)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(collect);
    }
}
