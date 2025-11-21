package com.example.coding_questions.two_sum;

import java.util.*;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 5, 11, 15, 4, 20};
        int target = 9;

        List<int[]> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            if (map.containsKey(currentNum)) {
                list.add(new int[]{map.get(currentNum), i});
            }
            map.put(complement, i);
        }
        for (int[] array : list) {
            System.out.println(Arrays.toString(array));
        }
    }
}
