package com.step.parking;


import java.util.ArrayList;

public class Attendant {
    private final String name;
    private ArrayList<ParkingLot> parkingLots;

    public Attendant(String name) {
        this.name = name;
        this.parkingLots = new ArrayList<>();
    }

    public void add(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public Object park(Vehicle vehicle) throws CannotParkException {
        if (parkingLots.isEmpty()) {
            throw new CannotParkException("Cannot park : All lots are full!");
        }
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(vehicle);
            }
        }
        throw new CannotParkException("All lots are full!");
    }


    public Vehicle checkout(Object token) throws CarNotFoundException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasVehicle(token)) {
                if (parkingLot.isFull()) parkingLots.add(parkingLot);
                return parkingLot.checkout(token);
            }
        }
        throw new CarNotFoundException();
    }

    public void report(LotReporter lotReporter) {
        lotReporter.writeHeading("Name of Attendant :- " + name);
        for (ParkingLot parkingLot : parkingLots) {
            parkingLot.report(lotReporter);
        }
    }
}

