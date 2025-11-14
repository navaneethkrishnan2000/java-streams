package com.example.interview_prep.intermediate;

import com.example.interview_prep.intermediate.dto.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortEmployeesByComparatorAndComparable {
    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        list.add(new User(3, "John"));
        list.add(new User(1, "Amit"));
        list.add(new User(2, "Zara"));

        // using comparable
//        Collections.sort(list);
//        System.out.println(list);

        // sorting using comparator - Use Comparator when you want multiple sorting logics outside the class.

        // 1
        Comparator<User> sortByName = (u1, u2) -> u1.getName().compareTo(u2.getName());
        list.sort(sortByName);
        System.out.println(list);

        list.sort(Comparator.comparing(User::getName));
        System.out.println(list);
    }
}
