package com.example.interview_prep.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Partition numbers in even and odd list
public class PartitionEvenOdd {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Map<Boolean, List<Integer>> listMap = nums.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

//        System.out.println(listMap); // {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}
        System.out.println("Even Numbers : " + listMap.get(true));
        System.out.println("Odd Numbers : " + listMap.get(false));
    }
}

// partitioningBy will check the condition if the element satisfies the condition(true/false),
// it will separate them into 2 lists based on the condition.
// if the condition satisfies it will store it in the true, else false
