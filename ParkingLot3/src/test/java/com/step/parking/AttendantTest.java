package com.step.parking;

import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class AttendantTest {

    private Attendant attendant;
    private class TestVehicle implements Vehicle {}
    private Vehicle car = new TestVehicle();
    private ParkingLot secondParkingLot;
    private ParkingLot thirdParkingLot;
    private ParkingLot firstParkingLot;

    @Before
    public void setUp() {
        attendant = new Attendant("John");
        firstParkingLot = new ParkingLot(2);
        secondParkingLot = new ParkingLot(2);
        thirdParkingLot = new ParkingLot(3);
        attendant.add(firstParkingLot);
        attendant.add(secondParkingLot);
        attendant.add(thirdParkingLot);
    }

    @Test
    public void shouldBeAbleToParkTheCar() throws CannotParkException {
        Object token = attendant.park(car);
        assertNotNull(token);
    }

    @Test
    public void shouldBeAbleToParkTheCarEvenAfterOneParkingLotIsFull() throws CannotParkException {
        attendant.park(car);
        attendant.park(new TestVehicle());
        Object token = attendant.park(new TestVehicle());
        assertNotNull(token);
    }

    @Test(expected = CannotParkException.class)
    public void shouldNotBeAbleToParkTheCarIfAllLotsAreFull() throws CannotParkException {
        attendant.park(new TestVehicle());
        attendant.park(new TestVehicle());
        attendant.park(new TestVehicle());
        attendant.park(new TestVehicle());
        attendant.park(new TestVehicle());
        attendant.park(new TestVehicle());
        attendant.park(new TestVehicle());
        attendant.park(new TestVehicle());
    }

    @Test
    public void shouldBeAbleToCheckoutTheCar() throws CannotParkException, CarNotFoundException {
        Object token = attendant.park(car);
        Vehicle myCar = attendant.checkout(token);
        assertThat(car,is(myCar));

    }

    @Test
    public void shouldBeAbleToCheckoutTheCarFromAnyParkingLot() throws CannotParkException, CarNotFoundException {
        attendant.park(new TestVehicle());
        attendant.park(new TestVehicle());
        Object token = attendant.park(car);
        Vehicle myCar = attendant.checkout(token);
        assertThat(car,is(myCar));
    }


    @Test
    public void shouldParkCarInFirstAvailableLot() throws CannotParkException {
        TestVehicle testVehicle1 = new TestVehicle();
        TestVehicle testVehicle2 = new TestVehicle();
        Object token1 = attendant.park(testVehicle1);
        Object token2 = attendant.park(testVehicle2);
        assertTrue(firstParkingLot.hasVehicle(token1));
        assertTrue(firstParkingLot.hasVehicle(token2));
    }

    private  class TestHTMLTableGenerator implements LotReporter {
        public String data = "";

        @Override
        public void writeHeading(String heading){
            data +=  "<h1>" + heading + "</h1>\n";
        }

        @Override
        public void writeData(String details){
            data += "<h3> " + details + "</h3>\n";
        }


        @Override
        public String toString() {
            return data;
        }
    }

    @Test
    public void shouldPrintReportAboutItsParkingLots() throws IOException {
        TestHTMLTableGenerator testWriter = new TestHTMLTableGenerator();
        attendant.report(testWriter);
        FileWriter fileWriter = new FileWriter("one.html");
        fileWriter.write(testWriter.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}
