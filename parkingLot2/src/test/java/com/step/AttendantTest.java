package com.step;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

//ensures that attendant manages lots in expected manner

public class AttendantTest {
  private Vehicle mockedCar;
  private Attendant attendant;
  private ParkingLot mockedParkingLot;

  private class TestCar implements Vehicle{};

  @Before
  public void setUp() throws Exception {
    mockedCar = mock(Vehicle.class);
    mockedParkingLot = mock(ParkingLot.class);
    attendant = new Attendant(ParkBy.ORDER_OF_INSERTION);
  }

  @Test
  public void shouldBeAbleToManageParkingLot() {
//    assertTrue(attendant.add(mockedParkingLot));
  }

  @Test
  public void shouldParkVehicleIntoParking() throws Exception {
    ParkingLot mockedParkingLot = new ParkingLot(2);
    attendant.add(mockedParkingLot);
    Object token = attendant.park(mockedCar);
    assertNotNull(token);
  }

  @Test
  public void shouldBeAbleToParkWhenFirstParkingLotIsFull() throws Exception {
    ParkingLot firstParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    attendant.add(firstParkingLot);
    attendant.add(secondParkingLot);
    attendant.park(mockedCar);
    Object tokenForSecond = attendant.park(new TestCar());
    assertNotNull(tokenForSecond);
  }

  @Test(expected = UnableToParkException.class)
  public void shouldThrowExceptionWhenNoSpaceAvailable() throws Exception {
    ParkingLot mockedParkingLot = new ParkingLot(1);
    ParkingLot secondParkingLot = new ParkingLot(1);
    attendant.add(mockedParkingLot);
    attendant.add(secondParkingLot);
    attendant.park(mockedCar);
    attendant.park(new TestCar());
    attendant.park(new TestCar());
  }

  @Test
  public void shouldBeAbleToCheckoutAPreviouslyParkedVehicle() throws InvalidTokenException {
    ParkingLot testLot = new ParkingLot(1);
    attendant.add(testLot);
    Object token = attendant.park(mockedCar);
    Vehicle checkedoutCar = attendant.checkout(token);
    assertEquals(mockedCar, checkedoutCar);
  }

  @Test(expected = InvalidTokenException.class)
  public void shouldThrowExceptionForInvalidToken() throws InvalidTokenException {
    ParkingLot parkingLot = new ParkingLot(2);
    attendant.add(parkingLot);
    Object invalidToken = new Object();
    attendant.checkout(invalidToken);
  }

  @Test
  public void shouldParkVehicleInFirstAvailableLot() {
    attendant.add(new ParkingLot(1));
    attendant.add(mockedParkingLot);
    attendant.add(new ParkingLot(1));
    attendant.park(mockedCar);
    attendant.park(new TestCar());
    attendant.park(mockedCar);
    verify(mockedParkingLot).park(mockedCar);
  }

  @Test
  public void shouldParkCarToHighestCapacityLotWhenAttendantIsToldToParkByCapacity() {
    Attendant attendant = new Attendant(ParkBy.MAXIMUM_LOT_CAPACITY);
    ParkingLot parkingLot3 = new ParkingLot(3);
    attendant.add(parkingLot3);
    attendant.add(new ParkingLot(1));
    attendant.add(new ParkingLot(2));
    ParkingLot parkingLot4 = new ParkingLot(3);
    attendant.add(parkingLot4);
    TestCar car = new TestCar();
    Object token = attendant.park(car);
    attendant.park(new TestCar());
    attendant.park(new TestCar());

    Object token1 = attendant.park(new TestCar());
    assertTrue(parkingLot3.hasVehicleFor(token));
    assertTrue(parkingLot3.isFull());
    assertTrue(parkingLot4.hasVehicleFor(token1));
  }

  @Test
  public void shouldParkCarInLotWithHighestAvailableLots() {
    Attendant attendant = new Attendant(ParkBy.MAXIMUM_AVAILABLE_SPACE);

    ParkingLot parkingLot2 = new ParkingLot(2);
    ParkingLot parkingLot3 = new ParkingLot(3);
    ParkingLot parkingLot4 = new ParkingLot(4);
    parkingLot3.park(new TestCar());
    parkingLot3.park(new TestCar());
    parkingLot4.park(new TestCar());
    parkingLot4.park(new TestCar());
    parkingLot4.park(new TestCar());

    attendant.add(parkingLot3);
    attendant.add(parkingLot2);
    attendant.add(parkingLot4);

    Object token = attendant.park(new TestCar());

    assertTrue(parkingLot2.hasVehicleFor(token));
  }
}
