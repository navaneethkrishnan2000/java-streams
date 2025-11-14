package com.example.coding_questions;

import java.util.Arrays;

public class FindMinMax {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7};

//        minMax(arr);
//        minMaxStream(arr);
        minMaxUsingSorting(arr);
    }

    private static void minMaxUsingSorting(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Min: " + arr[0] + " | Max : " + arr[arr.length-1]);
    }

    private static void minMaxStream(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        System.out.println("Min: " + min + " | Max : " + max);
    }

    private static void minMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        System.out.println("min: " + min);
        System.out.println("max: " + max);
    }
}
