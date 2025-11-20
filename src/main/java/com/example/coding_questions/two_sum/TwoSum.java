package com.example.coding_questions.two_sum;

import java.util.*;

// Given an array and target, return indices of two numbers that add to target.
public class TwoSum {
    public static void main(String[] args) {

        int[] arr = {7, 4, 11, 5, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        // Map to store: Key = the complement needed to reach the target
        //                Value = the index of the number that provides the complement
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            // Check if the required complement is already in our map (meaning we found the pair)
            if (map.containsKey(complement)) {
                // Return the index of the complement we stored earlier
                // and the index of the current number we just found.
                return new int[]{map.get(complement), i};
            }

            // If the complement is not found yet, store the *current* complement we need
            // and its index for a future number to find.
            map.put(nums[i], i);
        }
        // According to problem constraints, a solution always exists.
        // This line is here for completeness if constraints change.
        throw new IllegalArgumentException("No two sum solution");
    }
}
