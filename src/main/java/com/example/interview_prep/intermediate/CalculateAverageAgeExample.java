package com.example.interview_prep.intermediate;

import com.example.interview_prep.intermediate.dto.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

// Calculate the average age of a list of person objects using java streams
public class CalculateAverageAgeExample {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 28),
                new Person("David", 35)
        );

        double average = people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);

        System.out.println(average);

    }
}
