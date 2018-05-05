package com.step;

import java.util.HashMap;

// understands a place to park vehicles;

public class ParkingLot implements Comparable {
  private final HashMap<Object,Vehicle> vehicles;
  private final int capacity;

  public ParkingLot(int capacity) {
    vehicles = new HashMap<>();
    this.capacity = capacity;
  }

  public Object park(Vehicle car) throws UnableToParkException {
    if(hasVehicle(car)) {
      throw new UnableToParkException("Vehicle already parked!");
    }
    if(isFull()) {
      throw new UnableToParkException("No space available");
    }
    Object key = new Object();
    vehicles.put(key,car);
    return key;
  }

  private boolean hasVehicle(Vehicle vehicle) {
    return vehicles.containsValue(vehicle);
  }

  public boolean hasVehicleFor(Object token) {
    return vehicles.containsKey(token);
  }

  public Vehicle checkout(Object token) throws InvalidTokenException {
    if (!vehicles.containsKey(token)) {
      throw new InvalidTokenException();
    }

    return vehicles.remove(token);
  }

  public boolean isFull() {
    return vehicles.size() == capacity;
  }


  public boolean isGreater(ParkingLot b) {
    if (capacity  > b.capacity) return true;
    return false;
  }

  @Override
  public String toString() {
    return "ParkingLot{" +
            "vehicles=" + vehicles +
            ", capacity=" + capacity +
            '}';
  }

  @Override
  public int compareTo(Object o) {
    ParkingLot lot = (ParkingLot)o;
    if (isFull() && !lot.isFull()) return 1;
    if(!lot.isFull() && lot.capacity-capacity>=0) return 1;
    return -1;
  }

  public boolean hasMoreSpaceThan(ParkingLot other) {
    return this.getAvailableSlots() > other.getAvailableSlots();
  }

  public int getAvailableSlots() {
    return capacity - vehicles.size();
  }

  public boolean hasMoreCapacityThan(ParkingLot other) {
    return capacity >  other.capacity;
  }
}
