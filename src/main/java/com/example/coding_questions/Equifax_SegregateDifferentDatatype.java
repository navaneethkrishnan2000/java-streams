package com.example.coding_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Given a list of mixed datatypes, segregate the integer and multiply it with 10 and collect it to a list.
public class Equifax_SegregateDifferentDatatype {
    public static void main(String[] args) {
        List<Object> list = Arrays.asList('a', 10, 'b', 20, 'c', 30);

        List<Integer> collect = list.stream()
                .filter(e -> e instanceof Integer)
                .map(n -> (Integer) n * 10)
                .collect(Collectors.toList());
        System.out.println(collect);

        // another approach
        List<Integer> result = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Integer) {
                result.add((Integer) obj * 10);
            }
        }
        System.out.println(result);
    }
}
