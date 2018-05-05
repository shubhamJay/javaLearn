package com.step.bootcamp2;

import java.util.Objects;

public abstract class Length {
  final double value;
  public Length(double value) {
    this.value = value;
  }
  abstract Feet toFeet();
  abstract Inch toInch();
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Length length = (Length) o;
    return Double.compare(length.value, this.value) == 0;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(this.toInch());
  }
}
