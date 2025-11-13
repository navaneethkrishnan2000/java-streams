package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDistinctElements {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(5,2,8,2,5,3,9,3);

        List<Integer> list = nums.stream() // maintains the insertion order [5, 2, 8, 3, 9]
                .distinct()
                .toList();
        System.out.println(list);

        Set<Integer> set = nums.stream() // do not maintains the insertion order [2, 3, 5, 8, 9]
                .collect(Collectors.toSet());
        System.out.println(set);

        Set<Integer> set1 = new HashSet<>(nums); // do not maintain the insertion order [2, 3, 5, 8, 9]
        System.out.println(set1);

    }
}
