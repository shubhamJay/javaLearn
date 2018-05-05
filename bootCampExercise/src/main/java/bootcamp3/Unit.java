package bootcamp3;

import java.util.Objects;

import static bootcamp3.MeasurementType.*;

public enum Unit {
  LITRES(1,VOLUME), GALLONS(Constants.A_GALLON_IN_LITERS,VOLUME),
  FEET(12,LENGTH), INCHES(1,LENGTH), CMS(0.4,LENGTH), MMS(0.04,LENGTH),
  TONS(1000,WEIGHT), KGS(1,WEIGHT),GMS(0.001,WEIGHT),
  CELSIUS(1,-273,TEMPERATURE){
  }, FAHRENHEIT((double)5/9,-459.4,TEMPERATURE);

  private final double valueInBaseUnit;
  private final double offset;
  private MeasurementType type;

  Unit(double valueInBaseUnit, MeasurementType type) {
    this(valueInBaseUnit,0,type);

  }

  Unit(double valueInBaseUnit, double offset, MeasurementType type) {

    this.valueInBaseUnit = valueInBaseUnit;
    this.offset = offset;
    this.type =type;
  }

  public double convertIntoBaseValue(double value) {
    return value * valueInBaseUnit;
  }

  public boolean isSameType(Unit otherUnit){
    return type == otherUnit.type;
  }

  public int hash(double value){
    return Objects.hash(this.convertIntoBaseValue(value),type);
  }

  private double toBaseUnit(double value) {
    return (double) Math.round(this.valueInBaseUnit * (value-offset) * 1000) / 1000;
  }

  public double toUnit(double value, Unit target){
    return  toBaseUnit(value)/ target.valueInBaseUnit + target.offset;
  }

  private static class Constants {
    private static final double A_GALLON_IN_LITERS = 3.78;
  }
}

