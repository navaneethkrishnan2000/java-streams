package com.example.coding_questions;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveAllDuplicateCharacterFromString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates1("banana")); // ban
        System.out.println(removeDuplicates2("banana")); // ban
    }

    private static String removeDuplicates1(String s) {
        Set<Character> set = new LinkedHashSet<>();

        for (char c : s.toCharArray()) {
            set.add(c);
        }
        System.out.println(set);

        StringBuilder sb = new StringBuilder();
        for (char c : set) {
            sb.append(c);
        }
        return sb.toString();
    }

    // using streams
    private static String removeDuplicates2(String s) {
        return s.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}
