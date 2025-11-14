package com.example.coding_questions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByKeyAndByValue {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Banana");
        map.put(1, "Apple");
        map.put(2, "Mango");
        map.put(4, "Grapes");

        LinkedHashMap<Integer, String> sortedByKey = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new
                ));
        System.out.println("sortByKey : "+ sortedByKey);

        Map<Integer, String> sortedByKeyDesc =
                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (o, n) -> o,
                                LinkedHashMap::new
                        ));
        System.out.println("sortedByKeyDesc : " + sortedByKeyDesc);

        Map<Integer, String> sortedByValue =
                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldVal, newVal) -> oldVal,
                                LinkedHashMap::new
                        ));
        System.out.println("sortedByValue : " + sortedByValue);

        Map<Integer, String> sortedByValueDesc =
                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.<Integer, String>comparingByValue().reversed())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (o, n) -> o,
                                LinkedHashMap::new
                        ));
        System.out.println("sortedByValueDesc : " + sortedByValueDesc);


    }
}
