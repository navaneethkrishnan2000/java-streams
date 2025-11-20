package com.example.coding_questions.rotate_arrays;


import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k) {
        // 3%7 = 3,
        // if the k k >= nums.length, Rotating n (array length) or a multiple of n does nothing.
        // if k = 10 and n = 7, k % n = 3 — rotating 10 steps is same as rotating 3 steps.
        k = k % nums.length;
        // reverse entire array
        reverse(nums, 0, nums.length - 1); // [7, 6, 5, 4, 3, 2, 1]

        // reverse first k element
        reverse(nums, 0, k - 1); // [5, 6, 7, 4, 3, 2, 1]

        // reverse remaining elements
        reverse(nums, k, nums.length - 1); // [5, 6, 7, 1, 2, 3, 4]
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
