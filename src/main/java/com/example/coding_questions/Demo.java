package com.example.coding_questions;

import com.example.coding_questions.comparable.Product;
import com.example.interview_prep.hard.dto.WorkRecord;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

        int[] arr = {0,1,0,3,12};

        int index=0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]!=0) {
                arr[i] = arr[index];
                index++;
            }
        }

        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
        System.out.println(Arrays.toString(arr));

        List<Integer> list1 = Arrays.asList(10, 20, 4, 45, 99);
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : list1) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        System.out.println(largest);
        System.out.println(secondLargest);

        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        String s = "aabbccaa";

        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Integer maxCount = Collections.max(
                map.entrySet(),
                Map.Entry.comparingByValue()
        ).getValue();
        System.out.println(maxCount);

        List<Integer> list2 = Arrays.asList(5,9,11,2,8,21,1);
        Optional<Integer> second = list2.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(second);

        int[] arr1 = {10, 20, 4, 45, 99, 15};
        for (int i = 0; i < arr1.length-1; i++) {
            for (int j=0; j<arr1.length-1-i; j++) {
                if (arr1[j] > arr1[j+1]) {
                    int temp = arr1[j+1];
                    arr1[j+1] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {7,4,11,5,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(arr2, target)));

        // Find Duplicate Elements In An Array
        int[] a = {1,2,3,4,2,3,5,1};
//        Arrays.sort(a);
//        for (int i=1; i<a.length; i++) {
//            if (a[i] == a[i-1]) {
//                System.out.println(a[i] + " ");
//            }
//        }

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();

        for (int n : a) {
            if (!seen.add(n)) {
                duplicate.add(n);
            }
        }
         System.out.println(duplicate);

        // prime
        for (int i=2; i<=50; i++) {
            if (isPrime(i)) System.out.print(i + " ");
        }

        String str = "banana";
        String s1 = str.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println(s1);

        Set<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        System.out.println(set);

        StringBuilder sb = new StringBuilder();
        for(char c : set) {
            sb.append(c);
        }

        System.out.println(sb.toString());

        /*******************************************/

        List<WorkRecord> records = List.of(
                new WorkRecord("John", "IT"),
                new WorkRecord("John", "Finance"),
                new WorkRecord("John", "HR"),
                new WorkRecord("Alice", "IT"),
                new WorkRecord("Alice", "HR"),
                new WorkRecord("Bob", "Finance"),
                new WorkRecord("David", "IT"),
                new WorkRecord("David", "Finance"),
                new WorkRecord("David", "HR"),
                new WorkRecord("David", "Admin")
        );

        List<String> list = records.stream()
                .collect(Collectors.groupingBy(
                        WorkRecord::getEmployeeName
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() >= 3)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list);
    }

    static boolean isPrime(int n) {
        if (n<=1) return false;
        if (n==2) return true;
        if (n%2==0) return false;

        for (int i=3; i<= Math.sqrt(n); i++) {
            if (n%i==0) return false;
        }
        return true;
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int currNum = nums[i];
            int complement = target - currNum;

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;

        }
    }
 }
