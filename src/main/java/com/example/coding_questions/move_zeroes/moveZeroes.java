package com.example.coding_questions.move_zeroes;

import java.util.Arrays;

public class moveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

//        approach1(nums);
        approach2(nums);

    }

    private static void approach2(int[] nums) {
        int left = 0; // Pointer for the position to place the next non-zero element

        // Iterate through the array using the 'right' pointer
        for (int right = 0; right<nums.length; right++) {
            // if the element at the 'right' pointer is not zero
            if (nums[right] != 0) {
                // swap the non-zero element with the element at the 'left' position
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                // Increment the left pointer to the next available position
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
        // If nums[right] is 0, the 'right' pointer just moves on,
        // while 'left' waits for the next non-zero number to swap with.
    }

    private static void approach1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
