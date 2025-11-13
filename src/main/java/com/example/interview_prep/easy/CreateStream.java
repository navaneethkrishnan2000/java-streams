package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
        // list -> stream
        Stream<String> stream = names.stream();

        // arrays -> stream
        String[] arr = {"java", "python", "c#", "golang"};
        Stream<String> stream1 = Arrays.stream(arr);

        // Stream of
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        // Stream generate
        Stream<Double> doubleStream = Stream.generate(Math::random).limit(10);

    }
}
