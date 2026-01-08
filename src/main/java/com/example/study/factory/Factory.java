package com.example.study.factory;

public class Factory {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        try {
            Vehicle vehicle = vehicleFactory.getVehicle("car");
            vehicle.drive();

            Vehicle vehicle1 = vehicleFactory.getVehicle("bike");
            vehicle1.drive();

            Vehicle vehicle2 = vehicleFactory.getVehicle("cycle");
            vehicle2.drive();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
