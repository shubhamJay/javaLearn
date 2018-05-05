package bootcamp3;

import static bootcamp3.Unit.*;
import static bootcamp3.Unit.GMS;
import static bootcamp3.Unit.KGS;

public class ArithmeticMeasurement extends Measurement {

  public ArithmeticMeasurement(double value, Unit unit) {
    super(value,unit);
  }

  public static ArithmeticMeasurement inFeet(double value) {
    return new ArithmeticMeasurement(value,FEET);
  }

  public static ArithmeticMeasurement inInches(double value) {
    return new ArithmeticMeasurement(value, INCHES);
  }

  public static ArithmeticMeasurement inCentimeters(double value) {
    return new ArithmeticMeasurement(value, CMS);
  }

  public static ArithmeticMeasurement inMillimeters(double value) {
    return new ArithmeticMeasurement(value, MMS);
  }

  public static ArithmeticMeasurement inGallons(double value) {
    return new ArithmeticMeasurement(value,GALLONS);
  }

  public static ArithmeticMeasurement inLitres(double value) {
    return new ArithmeticMeasurement(value,LITRES);
  }

  public static ArithmeticMeasurement inTons(double value) {
    return new ArithmeticMeasurement(value,TONS);
  }

  public static ArithmeticMeasurement inKgs(double value) {
    return new ArithmeticMeasurement(value, KGS);
  }

  public static ArithmeticMeasurement inGrams(double value) {
    return new ArithmeticMeasurement(value,GMS);
  }

  public ArithmeticMeasurement add(ArithmeticMeasurement other) throws IncompatibleTypeException {
    Measurement otherInStandard = other.toUnit(this.unit);
    double newValue = (double)Math.round((otherInStandard.value + value)*100)/100;
    return new ArithmeticMeasurement(newValue,unit);
  }

  @Override
  public Measurement toUnit(Unit otherUnit) throws IncompatibleTypeException {
    Measurement convertedUnit = super.toUnit(otherUnit);
    return new ArithmeticMeasurement(convertedUnit.value,otherUnit);
  }
}
