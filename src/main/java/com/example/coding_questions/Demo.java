package com.example.coding_questions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        String s = "madam";
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        System.out.println(set);
        StringBuilder sb = new StringBuilder();
        for (char c : set) {
            sb.append(c);
        }
        System.out.println(sb);
    }

}
