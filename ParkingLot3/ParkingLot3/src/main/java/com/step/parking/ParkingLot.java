package com.step.parking;


import java.util.HashMap;

public class ParkingLot {
    private static int ID = 0;
    private final int capacity;
    private final int id;
    private HashMap<Object, Vehicle> vehicles;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.id = ++ID;
        this.vehicles = new HashMap<>();
    }

    public Object park(Vehicle vehicle) throws CannotParkException {
        if (isAlreadyParked(vehicle)) throw new CannotParkException("Car is already parked!");
        if (isFull()) throw new CannotParkException("Cannot park: Space not available!");
        Object token = new Object();
        vehicles.put(token, vehicle);
        return token;
    }

    public boolean isFull() {
        return vehicles.size() == capacity;
    }

    public Vehicle checkout(Object token) throws CarNotFoundException {
        if (!hasVehicle(token)) throw new CarNotFoundException();
        Vehicle vehicle = vehicles.remove(token);
        return vehicle;
    }

    protected boolean hasVehicle(Object token) {
        return vehicles.containsKey(token);
    }

    private boolean isAlreadyParked(Vehicle vehicle) {
        return vehicles.containsValue(vehicle);
    }

    public void report(LotReporter reporter) {
        reporter.writeData("ParkingLotId :" + String.valueOf(id));
        reporter.writeData("ParkingLotCapacity :" + String.valueOf(capacity));
    }
}
