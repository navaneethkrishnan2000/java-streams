package com.example.interview_prep.hard;

import com.example.interview_prep.hard.dto.WorkRecord;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// Find all Employees who worked in 3+ departments
public class EmployeesWith3Departments {
    public static void main(String[] args) {

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

        Map<String, List<WorkRecord>> collect = records.stream()
                .collect(Collectors.groupingBy(
                        WorkRecord::getEmployeeName
                ));
        System.out.println(collect);
        List<String> list = collect.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() >= 3)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list);
    }
}
