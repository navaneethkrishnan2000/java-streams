package com.example.interview_prep.intermediate;

import com.example.interview_prep.intermediate.dto.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortEmployeesBySalary {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1,"John", "HR", 50000),
                new Employee(2,"Jane", "IT", 70000),
                new Employee(3,"Mike", "IT", 80000),
                new Employee(4,"Sara", "Finance", 60000),
                new Employee(5,"Paul", "HR", 55000)
        );

        List<Employee> employeeListASEC = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();

        System.out.println(employeeListASEC);

        List<Employee> employeeListDSEC = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList();

        System.out.println(employeeListDSEC);

    }
}
