package com.example.coding_questions.comparable;

public class Product implements Comparable<Product> {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    // Returns a negative integer, zero, or a positive integer
    // as this object is less than, equal to, or greater than the specified object.
    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.id, o.id);
    }

    // sort using name
//    @Override
//    public int compareTo(Product o) {
//        return this.name.compareTo(o.name);
//    }
}
