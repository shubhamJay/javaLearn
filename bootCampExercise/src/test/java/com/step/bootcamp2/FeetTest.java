package com.step.bootcamp2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FeetTest {
  @Test
  public void shouldGiveOneWhenToFitIsCalledWithOne() {
    Feet feet = new Feet(1);
    assertThat(feet.toFeet(),is(new Feet(1)));
  }
  
  @Test
  public void shouldGive12For1Feet() {
    Feet feet = new Feet(1);
  assertThat(feet.toInch(),is(new Inch(12)));
  }
  
  @Test
  public void shouldReturnTrue() {
    assertEquals(new Feet(1),new Inch(12));
  }
}