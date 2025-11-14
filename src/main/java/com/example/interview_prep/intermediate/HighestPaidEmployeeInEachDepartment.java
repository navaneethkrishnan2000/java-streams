package com.example.interview_prep.intermediate;

import com.example.interview_prep.intermediate.dto.Employee;

import java.util.*;
import java.util.stream.Collectors;

// Find the highest paid employee in each department
public class HighestPaidEmployeeInEachDepartment {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1,"John", "HR", 50000),
                new Employee(2,"Jane", "IT", 70000),
                new Employee(3,"Mike", "IT", 80000),
                new Employee(4,"Sara", "Finance", 60000),
                new Employee(5,"Paul", "HR", 55000)
        );

        Map<String, Optional<Employee>> maxSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)))
                );

        System.out.println(maxSalary);
    }
}
