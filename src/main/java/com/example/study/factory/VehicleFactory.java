package com.example.study.factory;

public class VehicleFactory {
    public Vehicle getVehicle(String vehicleName) {
        return
                switch (vehicleName.toLowerCase()) {
                    case "car" -> new Car();
                    case "cycle" -> new Cycle();
                    case "bike" -> new Bike();
                    default -> throw new IllegalStateException("Unexpected value: " + vehicleName.toLowerCase());
                };

    }
}
