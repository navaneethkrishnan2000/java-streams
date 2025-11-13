package com.example.interview_prep.intermediate;

import com.example.interview_prep.intermediate.dto.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// Group employees by department and calculate average salary
public class GroupByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1,"John", "HR", 50000),
                new Employee(2,"Jane", "IT", 70000),
                new Employee(3,"Mike", "IT", 80000),
                new Employee(4,"Sara", "Finance", 60000),
                new Employee(5,"Paul", "HR", 55000)
        );

        Map<String, Double> avgSalary = employees.stream()
                                                .collect(Collectors.groupingBy(
                                                        Employee::getDepartment,
                                                        Collectors.averagingDouble(Employee::getSalary))
                                                );
        System.out.println(avgSalary); // {Finance=60000.0, HR=52500.0, IT=75000.0}
    }
}
