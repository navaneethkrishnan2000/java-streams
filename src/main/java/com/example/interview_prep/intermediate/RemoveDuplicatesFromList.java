package com.example.interview_prep.intermediate;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromList {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 1, 4);

//        List<Integer> unique = nums.stream()
//                .distinct()
//                .toList();

//        Set<Integer> unique = new HashSet<>(nums);

        List<Integer> unique = nums.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .toList();

        System.out.println(unique);

    }
}
