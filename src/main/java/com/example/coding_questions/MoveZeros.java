package com.example.coding_questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Move all zeros to the end of the array
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

//        moveZerosTwoPointerApproach(arr);
//        moveZerosSwap(arr);
        moveZerosStream(arr);
    }

    private static void moveZerosStream(int[] arr) {
        // get the non zero elements
        List<Integer> collect = new java.util.ArrayList<>(Arrays.stream(arr)
                .filter(a -> a != 0)
                .boxed()
                .toList());

        long count = Arrays.stream(arr)
                .filter(a -> a==0)
                .count();

        for(int i=0; i<count; i++) {
            collect.add(0);
        }

        System.out.println(collect);
    }

    private static void moveZerosTwoPointerApproach(int[] arr) {
        int index = 0; // pointer for non-zero elements

        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num; // move non-zero element forward
            }
        }

        // fill remaining positions with zero
        while (index < arr.length) {
            arr[index++] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void moveZerosSwap(int[] arr) {
        int j = 0; // pointer

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

}
