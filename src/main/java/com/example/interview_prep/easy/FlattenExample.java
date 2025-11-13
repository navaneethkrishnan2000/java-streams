package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;

// Flatten the list of list
public class FlattenExample {
    public static void main(String[] args) {

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5),
                Arrays.asList(6,7,8,9)
        ); // [1, 2, 3, 4, 5, 6, 7, 8, 9]

        List<Integer> list = listOfLists.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println(list);

    }
}
