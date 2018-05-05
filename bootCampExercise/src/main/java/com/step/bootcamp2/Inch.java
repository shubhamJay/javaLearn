package com.step.bootcamp2;

public class Inch extends Length{
  
  public Inch(double value) {
    super(value);
  }
  
  public Inch toInch() {
    return new Inch(value);
  }
  
  public Feet toFeet() {
    return new Feet(value/12);
  }
}
