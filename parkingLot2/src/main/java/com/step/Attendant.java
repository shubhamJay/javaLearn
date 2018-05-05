
package com.step;


import java.util.ArrayList;

//understands to add parking lot(s);

public class Attendant {

  private final ParkBy parkBy;
  private ArrayList parkingLots;
  private ArrayList<ParkingLot> availableLots;

  public Attendant(ParkBy parkBy) {
    this.parkBy = parkBy;
    this.parkingLots = new ArrayList<>();
    this.availableLots = new ArrayList<>();

  }

  public boolean add(ParkingLot parkingLot) {

    parkingLots.add(parkingLot);
    return availableLots.add(parkingLot);
  }

  public Object park(Vehicle vehicle) {


    Object token;
    ParkingLot lotToPark;
    try {
      lotToPark = parkBy.getLot(availableLots);
      token = lotToPark.park(vehicle);
    } catch (IndexOutOfBoundsException e){
      throw new UnableToParkException("No space available");
    }
    if (lotToPark.isFull()){
      availableLots.remove(lotToPark);
    }
    return token;
  }


  public Vehicle checkout(Object token) throws InvalidTokenException {
    for (ParkingLot parkingLot : parkingLots) {
      if (parkingLot.hasVehicleFor(token)) {
        if (parkingLot.isFull()) availableLots.add(parkingLot);
        return parkingLot.checkout(token);
      }
    }
    throw new InvalidTokenException();
  }

}