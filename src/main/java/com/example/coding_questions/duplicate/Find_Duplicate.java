package com.example.coding_questions.duplicate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Find_Duplicate {
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = {3, 4, 5};
        int[] c = {4, 5, 6};
        findDuplicateUsingStream(a, b, c);
    }

    private static void findDuplicateUsingStream(int[] a, int[] b, int[] c) {
        List<Integer> list = Arrays.asList(a, b, c)
                .stream()
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list);
    }
}
