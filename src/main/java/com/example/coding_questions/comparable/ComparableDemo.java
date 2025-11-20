package com.example.coding_questions.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(3, "Laptop", 999.0));
        products.add(new Product(1, "Smartphone", 699.0));
        products.add(new Product(2, "Headphones", 150.0));

        // Sorting the list using Collections.sort(), which uses the compareTo() method
        Collections.sort(products);

        System.out.println("Sorted by ID (Natural Ordering):");
        for (Product p : products) {
            System.out.println(p);
        }
        // Output will be ordered by ID: 1, 2, 3
    }
}
