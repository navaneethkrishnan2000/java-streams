package com.example.coding_questions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElementsInAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 3, 5, 1};

//        findDuplicatesUsingSet(arr);
//        findDuplicatesUsingStreams(arr);
//        findDuplicatesUsingStream(arr);
        findDuplicatesUsingSorting(arr);
    }

    private static void findDuplicatesUsingSorting(int[] arr) {
        Arrays.sort(arr);

        System.out.print("Duplicates: ");
        for (int i=1; i<arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static void findDuplicatesUsingSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();

        for (int a : arr) {
            if (!seen.add(a)) {
                duplicate.add(a);
            }
        }
        System.out.println(duplicate);
    }

    public static void findDuplicatesUsingStreams(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        Set<Integer> duplicates = Arrays.stream(arr)
                .boxed()
                .filter(i -> !seen.add(i))
                .collect(Collectors.toSet());

        System.out.println("Duplicates: " + duplicates);
    }

    public static void findDuplicatesUsingStream(int[] arr) {
        Set<Integer> collect = Arrays.stream(arr)// converting the array into an array of streams
                .boxed() // converting the int to Integer
                .collect(Collectors.groupingBy( // collecting and counting the elements
                        Function.identity(),
                        Collectors.counting()
                ))                              // {1=2, 2=2, 3=2, 4=1, 5=1} Set<element, count>
                .entrySet()     // getting the entry set - key value pairs
                .stream()
                .filter(entry -> entry.getValue() > 1)  // filter the entries that the count > 1
                .map(Map.Entry::getKey)                 // get the key
                .collect(Collectors.toSet());           // collect it
        System.out.println(collect);
    }
}


