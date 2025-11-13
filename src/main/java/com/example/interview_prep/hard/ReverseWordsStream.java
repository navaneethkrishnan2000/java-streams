package com.example.interview_prep.hard;

import java.util.Arrays;
import java.util.stream.Collectors;

// Reverse each word in a sentence using streams
public class ReverseWordsStream {
    public static void main(String[] args) {

        String sentence = "Java streams are powerful";
        //avaJ smaerts era lufrewop

        String collected = Arrays.stream(sentence.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(collected);

        // another way
        String collected1 = Arrays.stream(sentence.split(" "))
                .map(word -> Arrays.stream(word.split(""))
                        .reduce("", (rev, ch) -> ch + rev)
                )
                .collect(Collectors.joining(" "));

        System.out.println(collected1);
    }
}
