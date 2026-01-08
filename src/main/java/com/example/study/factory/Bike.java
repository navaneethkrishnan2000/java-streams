package com.example.study.factory;

public class Bike extends Vehicle {
    public Bike() {
        super();
        System.out.println("Bike object created");
    }

    @Override
    public void drive() {
        System.out.println("Riding a car");
    }
}
