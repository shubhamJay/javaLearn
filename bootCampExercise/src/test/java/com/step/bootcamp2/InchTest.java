package com.step.bootcamp2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InchTest {
  @Test
  public void shouldGiveOneIfToInchIsCalledWithOne() {
    Inch inch = new Inch(1);
    assertThat(inch.toInch(),is(new Inch(1)));
  }
  
  @Test
  public void shouldGive1FeetFor12Inch() {
    Inch inch = new Inch(12);
    assertThat(inch.toFeet(),is(new Feet(1)));
  }
}
