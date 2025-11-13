package com.example.interview_prep.hard;

import java.util.Arrays;
import java.util.Comparator;

// Find the longest word in a sentence ignoring case and punctuation
public class LongestWordFinder {
    public static void main(String[] args) {
        String sentence = "The quick, brown fox jumped over the lazy dog!";

        String s = Arrays.stream( // to convert the string into a stream
                        sentence.toLowerCase() // convert to lower case
                                .replaceAll("[^a-z\\s]", "") // remove the special characters
                                .split(" ") // split them with space which returns a stream of string (Stream<String>)
                )
                .max(Comparator.comparing(String::length)) // find the max value by comparing the length of the string
                .orElse(null);

        System.out.println(s); // jumped
    }
}
