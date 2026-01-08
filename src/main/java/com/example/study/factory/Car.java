package com.example.study.factory;

public class Car extends Vehicle {
    public Car() {
        super();
        System.out.println("Car Object created");
    }

    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}
