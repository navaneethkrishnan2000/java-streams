package com.example.coding_questions.second_largest;

import java.util.*;
import java.util.stream.IntStream;

public class FindSecondLargest {
    public static void main(String[] args) {

        int[] arr = {10, 20, 4, 45, 99, 15};

//        System.out.println(approach1(arr));
//        System.out.println(approach2(arr));
//        System.out.println(approach3(arr));
        System.out.println(approach(arr));
    }

    private static int approach3(int[] nums) {
        if (nums == null || nums.length < 2) {
            System.out.println("Array is too small to find a second largest element.");
            return Integer.MIN_VALUE;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                // If the current number is larger than our current largest,
                // the old largest becomes the second largest,
                // then the currentNum will be the largest
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                // If the number is smaller than largest, but larger than the current second largest,
                // it becomes the new second largest.
                // The num != largest check handles duplicates.
                secondLargest = num;
            }
        }
        // Handle cases where all numbers were duplicates (e.g., {5, 5, 5})
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No distinct second largest element found.");
        }
        return secondLargest;
    }

    private static int approach2(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : arr) {
            treeSet.add(num);
        }

        List<Integer> sortedList = new ArrayList<>(treeSet);


        return sortedList.get(sortedList.size() - 2);
    }

    private static int approach1(int[] arr) {
        return IntStream.of(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
    }

    private static int approach(int[] arr) {

        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j< arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr[arr.length - 2];
    }
}
