package com.example.coding_questions.findSecondLargest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class findSecondLargest {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(10, 20, 4, 45, 99);
        secondLargestApproach1(list1);

        List<Integer> list2 = Arrays.asList(10, 20, 4, 45, 99, 99);
        secondLargestApproach2(list2);

    }

    private static void secondLargestApproach2(List<Integer> list) {

        Integer largest = Integer.MIN_VALUE;
        Integer secondLargest = Integer.MIN_VALUE;

        for(int num : list) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        System.out.println("Second Largest: " + secondLargest);
    }

    private static void secondLargestApproach1(List<Integer> list) {
        Collections.sort(list);
        int secondLargest = list.get(list.size() - 2);

        System.out.println("Second Largest: " + secondLargest);
    }
}
