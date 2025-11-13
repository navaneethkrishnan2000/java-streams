package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;

public class FindFirstNonEmptyString {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("", "", "Hi", "Hello", "World", "");

        List<String> list = strings.stream()
                .filter(s -> !s.isEmpty())
                .toList();

        System.out.println(list);

        System.out.println(
                strings.stream()
                        .filter(s -> !s.isEmpty())
                        .findFirst()
        );


    }
}
