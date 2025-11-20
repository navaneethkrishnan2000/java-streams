package com.example.coding_questions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class demo {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {3, 4, 5};
        int[] c = {4, 5, 6};

        System.out.println(Arrays.asList(a,b,c).stream().flatMapToInt(Arrays::stream).boxed().sorted().toList());

        List<Integer> collect = Stream.of(a, b, c)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .toList();

        HashSet<Integer> set = new HashSet<>();
        for (int num : collect) {
            if (!set.add(num)) {
                System.out.println(num);
            }
        }

//        System.out.println(list);

    }
}

class Product implements Comparable<Product> {
    private Long id;
    private String name;
    private String quantity;
    @Override
    public int compareTo(Product o) {
        return Long.compare(this.id,o.id);
    }
}
