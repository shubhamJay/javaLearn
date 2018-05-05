package com.step;

import java.util.ArrayList;

public enum ParkBy {
  ORDER_OF_INSERTION,
  MAXIMUM_AVAILABLE_SPACE {
    @Override
    public ParkingLot getLot(ArrayList<ParkingLot> parkingLots) {
      ParkingLot maxAvailabilityLot = parkingLots.get(0);
      for (ParkingLot parkingLot : parkingLots) {
          if (parkingLot.hasMoreSpaceThan(maxAvailabilityLot)){
            maxAvailabilityLot = parkingLot;
          }
      }
      return  maxAvailabilityLot;
    }
  },
  MAXIMUM_LOT_CAPACITY{
    @Override
    public ParkingLot getLot(ArrayList<ParkingLot> parkingLots) {
      ParkingLot maxCapacityLot = parkingLots.get(0);
      for (ParkingLot parkingLot : parkingLots) {
        if (parkingLot.hasMoreCapacityThan(maxCapacityLot)){
          maxCapacityLot = parkingLot;
        }
      }
      return  maxCapacityLot;
    }
  };

  public ParkingLot getLot(ArrayList<ParkingLot> parkingLots){
    return parkingLots.get(0);
  }
}
