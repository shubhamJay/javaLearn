package com.step.parking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingLotTest {

    private ParkingLot parkingLot;
    private Object token;

    private class TestCar implements Vehicle {
    }

    private Vehicle car;

    @Before
    public void setUp() throws CannotParkException {
        parkingLot = new ParkingLot(3);
        car = new TestCar();
        token = parkingLot.park(car);
    }

    @Test
    public void shouldBeAbleToParkTheCar() {
        assertNotNull(token);
    }

    @Test
    public void shouldBeAbleToCheckoutTheCar() throws CarNotFoundException {
        Object myCar = parkingLot.checkout(token);
        assertThat(myCar, is(car));
    }

    @Test(expected = CarNotFoundException.class)
    public void shouldNotBeAbleToCheckoutTheCarWithInvalidToken() throws CarNotFoundException {
        parkingLot.checkout(new Object());
    }

    @Test(expected = CarNotFoundException.class)
    public void shouldNotCheckoutTheSameCarMoreThanOnceBeforeParkingItAgain() throws CarNotFoundException {
        parkingLot.checkout(token);
        parkingLot.checkout(token);
    }

    @Test(expected = CannotParkException.class)
    public void shouldNotParkTheSameCarTwiceWhichIsNotCheckedOut() throws CannotParkException {
        parkingLot.park(car);
    }

    @Test
    public void shouldAssertTrueWhenTheParkingLotIsFull() {
        ParkingLot newParkingLot = new ParkingLot(0);
        assertTrue(newParkingLot.isFull());
    }

    @Test
    public void shouldAssertFalseWhenTheParkingLotIsNotFull() {
        ParkingLot newParkingLot = new ParkingLot(1);
        assertFalse(newParkingLot.isFull());
    }

    @Test(expected = CannotParkException.class)
    public void shouldNotBeAbleToParkTheCarWhenThereIsNoSpace() throws CannotParkException {
        parkingLot.park(new TestCar());
        parkingLot.park(new TestCar());
        parkingLot.park(new TestCar());
    }

    @Test
    public void shouldBeAbleToParkAfterCheckingOutCarFromFullLot() throws CannotParkException, CarNotFoundException {
        parkingLot.park(new TestCar());
        parkingLot.park(new TestCar());
        assertTrue(parkingLot.isFull());
        parkingLot.checkout(token);
        Object carToken = parkingLot.park(car);
        assertNotNull(carToken);
    }

    @Test
    public void shouldAssertFalseAfterCheckingOutCarFromFullLot() throws CarNotFoundException, CannotParkException {
        parkingLot.park(new TestCar());
        parkingLot.park(new TestCar());
        assertTrue(parkingLot.isFull());
        parkingLot.checkout(token);
        assertFalse(parkingLot.isFull());
    }
}

