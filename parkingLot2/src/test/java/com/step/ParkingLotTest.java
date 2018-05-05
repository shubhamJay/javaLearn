package com.step;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ParkingLotTest {
  private ParkingLot parkingLot;
  private Vehicle testCar;

  @Before
  public void setUp() {
    parkingLot = new ParkingLot(2);
    testCar = mock(Vehicle.class);
  }

  @Test
  public void shouldBeAbleParkACar() throws UnableToParkException {
    Object token = parkingLot.park(testCar);
    assertNotNull(token);
    assertTrue(parkingLot.hasVehicleFor(token));
  }

  @Test
  public void shouldCheckoutTheCarOfGivenToken() throws UnableToParkException, InvalidTokenException {
    Object token = parkingLot.park(testCar);
    assertThat(parkingLot.checkout(token), is(testCar));
  }

  @Test
  public void checkedOutCarShouldNotPresent() throws UnableToParkException, InvalidTokenException {
    Object token = parkingLot.park(testCar);
    parkingLot.checkout(token);
    assertFalse(parkingLot.hasVehicleFor(token));
  }

  @Test(expected = UnableToParkException.class)
  public void shouldNotAllowToParkSameCarTwice() throws UnableToParkException {
    parkingLot.park(testCar);
    parkingLot.park(testCar);
  }

  @Test(expected = InvalidTokenException.class)
  public void shouldThrowExceptionWhenCarIsNotPresent() throws InvalidTokenException {
    parkingLot.checkout(123);
  }

  @Test(expected = InvalidTokenException.class)
  public void shouldNotAllowToCheckOutSameCarTwice() throws InvalidTokenException {
    Object token = parkingLot.park(testCar);
    parkingLot.checkout(token);
    parkingLot.checkout(token);
  }

  @Test
  public void shouldGiveFalseWhenParkingIsNotFull() {
    assertFalse(parkingLot.isFull());
  }

  @Test
  public void shouldGiveTrueWhenParkingIsFull() throws UnableToParkException {
    parkingLot.park(testCar);
    Vehicle secondTestCar = mock(Vehicle.class);
    parkingLot.park(secondTestCar);
    assertTrue(parkingLot.isFull());
  }

  @Test(expected = UnableToParkException.class)
  public void shouldNotAllowToParkVehicleWhenCapacityIsFull() throws UnableToParkException {
    parkingLot.park(testCar);
    parkingLot.park(testCar);
    parkingLot.park(testCar);
  }

  @Test
  public void shouldReturnLiveParkingLotStatus() throws UnableToParkException, InvalidTokenException {
    Object tokenForFirst = parkingLot.park(testCar);
    Vehicle secondMockedVehicle = mock(Vehicle.class);
    parkingLot.park(secondMockedVehicle);
    assertTrue(parkingLot.isFull());
    parkingLot.checkout(tokenForFirst);
    assertFalse(parkingLot.isFull());
  }
}
