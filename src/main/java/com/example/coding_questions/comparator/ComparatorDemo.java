package com.example.coding_questions.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(3, "Laptop", 999.0));
        products.add(new Product(1, "Smartphone", 699.0));
        products.add(new Product(2, "Headphones", 150.0));
        products.add(new Product(4, "Monitor", 999.0)); // Same price as Laptop

        // Define a Comparator using modern Java 8 Lambda expression:
        // Sort by price, then by name if prices are equal
        Comparator<Product> priceNameComparator = Comparator
                .comparingDouble(Product::getPrice) // Sort primarily by price
                .thenComparing(Product::getName);   // Sort secondarily by name

        // Sorting the list using Collections.sort() with the custom comparator
        Collections.sort(products, priceNameComparator);

        System.out.println("Sorted by Price (Custom Ordering):");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
