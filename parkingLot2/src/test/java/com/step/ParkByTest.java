package com.step;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkByTest {

  private ArrayList<ParkingLot> parkingLots;
  private ParkingLot lotWithCapacity2;
  private ParkingLot lotWithCapacity4;

  @Before
  public void setUp() throws Exception {
    parkingLots = new ArrayList<>();
    lotWithCapacity2 = new ParkingLot(2);
    parkingLots.add(lotWithCapacity2);
    lotWithCapacity4 = new ParkingLot(4);
    parkingLots.add(lotWithCapacity4);
  }

  @Test
  public void shouldGiveFirstLotInGivenLot() {
    assertThat(ParkBy.ORDER_OF_INSERTION.getLot(parkingLots),is(lotWithCapacity2));
  }

  @Test
  public void shouldGiveLotWithMaximumAvailableSlots() {
    assertThat(ParkBy.MAXIMUM_AVAILABLE_SPACE.getLot(parkingLots),is(lotWithCapacity4));
  }

  @Test
  public void shouldGiveLotWithMaximumCapacity() {
    assertThat(ParkBy.MAXIMUM_LOT_CAPACITY.getLot(parkingLots),is(lotWithCapacity4));
  }
}