package com.step.parking;

public class CarNotFoundException extends Throwable {
    public CarNotFoundException() {
        super("Car is not present in the parking lot!");
    }
}
