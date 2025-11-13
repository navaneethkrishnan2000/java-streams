package com.example.interview_prep.hard;

import com.example.interview_prep.hard.dto.CharCategory;

import java.util.*;
import java.util.stream.Collectors;

// Group characters by uppercase vs lowercase vs digit vs other
public class GroupCharacters {
    public static void main(String[] args) {

        List<Character> chars = Arrays.asList(
                'A', 'b', '3', 'Z', 'x', '#', '7', 'm', '@'
        );
     /* DIGIT → [3, 7]
        UPPERCASE → [A, Z]
        LOWERCASE → [b, x, m]
        OTHER → [#, @]*/

        Map<Object, List<Character>> collect = chars.stream()
                .collect(Collectors.groupingBy(
                        ch -> getCharacterCategory(ch.charValue())
                ));
        System.out.println(collect);
    }

    private static Object getCharacterCategory(char c) {
        if (Character.isUpperCase(c)) return CharCategory.UPPERCASE;
        if (Character.isLowerCase(c)) return CharCategory.LOWERCASE;
        if (Character.isDigit(c)) return CharCategory.DIGIT;
        else return CharCategory.OTHER;
    }
}
