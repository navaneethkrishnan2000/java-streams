package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortLists {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5,1,8,3,2,1,10);

        List<Integer> listASEC = nums.stream()
                .distinct()
                .sorted()
                .toList();
        System.out.println(listASEC); // [1, 2, 3, 5, 8, 10]

        List<Integer> listDSEC = nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(listDSEC); // [10, 8, 5, 3, 2, 1]
    }
}
