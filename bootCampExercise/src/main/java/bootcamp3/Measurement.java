package bootcamp3;

import static bootcamp3.Unit.*;

public class Measurement {
  protected final double value;
  protected final Unit unit;

  Measurement(double value, Unit unit) {
    this.value = value;
    this.unit = unit;
  }

  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Measurement otherMeasurement = (Measurement) o;
    try {
      return compareBaseValue(otherMeasurement);
    } catch (IncompatibleTypeException e) {
      return false;
    }
  }

  private boolean compareBaseValue(Measurement otherMeasurement) throws IncompatibleTypeException {
    Measurement baseValue = otherMeasurement.toUnit(unit);
    System.out.println(baseValue);
    System.out.println(value);
    return Double.compare(value, baseValue.value) == 0;
  }

  public Measurement toUnit(Unit otherUnit) throws IncompatibleTypeException {
    if(!this.unit.isSameType(otherUnit)){
      throw new IncompatibleTypeException("Cannot add two different quantities");
    }
    return new Measurement(this.unit.toUnit(this.value, otherUnit),otherUnit);
  }

  @Override
  public int hashCode() {
    return  unit.hash(value);
  }

  @Override
  public String toString() {
    return "Measurement{" +
            "value=" + value +
            ", unit=" + unit +
            '}';
  }

  public static Measurement inCelsius(double value) {
    return new Measurement(value, CELSIUS);
  }

  public static Measurement inFahrenheit(double value) {
      return new Measurement(value,FAHRENHEIT);
  }

}
