package com.example.coding_questions;

/*
*   They have exactly the same characters
*   With the same frequency
*   In any order
*
* eg:- listen → silent , triangle → integral
*/

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringAnagramCheck {
    public static void main(String[] args) {
        System.out.println(isAnagram2("listen", "silent")); // true
        System.out.println(isAnagram2("hello", "world"));   // false
    }

    // Sort and Compare (Simple & Popular)
    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    private static boolean isAnagram2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Map<Character, Long> map1 = s1.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(map1);

        Map<Character, Long> map2 = s2.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(map2);

        return map1.equals(map2);
    }
}


