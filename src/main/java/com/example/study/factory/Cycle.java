package com.example.study.factory;

public class Cycle extends Vehicle {

    public Cycle() {
        super();
        System.out.println("Cycle Object created");
    }

    @Override
    public void drive() {
        System.out.println("Riding a cycle");
    }
}
