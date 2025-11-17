package com.example.interview_prep.tutorial;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* input (array, collections, etc) -> intermediate operations(map, filter, distincy,...) -> terminal operations(forEach, reduce, toList,...)
    intermediate operations - do not return a result,
    terminal operations - return a result
* */
public class ConvertToStreams {
    public static void main(String[] args) {
        // primitive array
        int[] primitiveArray = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(primitiveArray);
//        System.out.println(intStream);
        intStream.forEach(System.out::println); // applying terminal operations

        // object array
        Integer[] objectArray = {8,9,10,11,12};
        Stream<Integer> integerStream = Stream.of(objectArray); // we can convert the Wrapper class array using Stream.of()
        integerStream.forEach(System.out::println);

        // List - we can convert the list into a stream using .stream() method
        List<Integer> integerList = Arrays.asList(21,22,23,24,25);
        integerList.stream().forEach(System.out::println);
    }
}
