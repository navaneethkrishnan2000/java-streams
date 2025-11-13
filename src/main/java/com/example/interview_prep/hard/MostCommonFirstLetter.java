package com.example.interview_prep.hard;

import com.example.interview_prep.intermediate.dto.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

// Find the most common first letter among all employee names
public class MostCommonFirstLetter {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "John", "IT", 60000),
                new Employee(2, "Alice", "HR", 55000),
                new Employee(3, "Bob", "IT", 75000),
                new Employee(4, "Carol", "HR", 70000),
                new Employee(5, "David", "Finance", 65000),
                new Employee(6, "Eve", "IT", 80000),
                new Employee(7, "Frank", "Finance", 64000),
                new Employee(8, "Ala", "Operations", 44000)
        );

        Map<Character, Long> map = employees.stream()
                .map(employee -> employee.getName().charAt(0))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(map);

        Optional<Map.Entry<Character, Long>> max = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        System.out.println(max);
    }
}
