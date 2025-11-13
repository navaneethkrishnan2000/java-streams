package com.example.interview_prep.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindSecondHighestNumber {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(5,9,11,2,8,21,1);

        System.out.println(
                nums.stream()
                        .sorted(Comparator.reverseOrder())  // sort the list in reverse order
                        .skip(1)                         // skip the first element(1)
                        .findFirst()                        // 11
        );

    }
}
