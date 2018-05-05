package com.step.bootcamp2;

import java.util.Objects;

public class Feet extends Length{
  
  public Feet(double value) {
    super(value);
  }
  
  public Feet toFeet() {
    return new Feet(value);
  }
  
  public Inch toInch() {
    return new Inch(value*12);
  }
  
}
