package bootcamp3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ArithmeticMeasurementTest {
  @Test
  public void oneFootShouldBeEqualToTwelveInches() {
    ArithmeticMeasurement oneFoot = ArithmeticMeasurement.inFeet(1);
    ArithmeticMeasurement twelveInch = ArithmeticMeasurement.inInches(12);
    assertEquals(oneFoot, twelveInch);
    assertEquals(oneFoot.hashCode(),twelveInch.hashCode());
  }

  @Test
  public void twoInchesShouldBeEqualToFiveCentimeters() {
    ArithmeticMeasurement twoInches = ArithmeticMeasurement.inInches(2);
    ArithmeticMeasurement fiveCentimeters = ArithmeticMeasurement.inCentimeters(5);
    assertEquals(twoInches, fiveCentimeters);
    assertEquals(twoInches.hashCode(), fiveCentimeters.hashCode());
  }

  @Test
  public void oneCmShouldBeEqualToTenMm() {
    ArithmeticMeasurement oneCm = ArithmeticMeasurement.inCentimeters(1);
    ArithmeticMeasurement tenMm = ArithmeticMeasurement.inMillimeters(10);
    assertEquals(oneCm, tenMm);
    assertEquals(oneCm.hashCode(), tenMm.hashCode());
  }

  @Test
  public void oneGallonShouldBeEqualToThreePointSevenEightLitres() {
    ArithmeticMeasurement oneGallon = ArithmeticMeasurement.inGallons(1.0);
    ArithmeticMeasurement threePointSevenEightLitres = ArithmeticMeasurement.inLitres(3.78);
    assertEquals(oneGallon, threePointSevenEightLitres);
    assertEquals(oneGallon.hashCode(),threePointSevenEightLitres.hashCode());
  }

  @Test
  public void oneGallonShouldNotBeEqualToOneLitre() {
    ArithmeticMeasurement oneGallon = ArithmeticMeasurement.inGallons(1.0);
    ArithmeticMeasurement oneLiter = ArithmeticMeasurement.inLitres(1);
    assertNotEquals(oneGallon, oneLiter);
    assertNotEquals(oneGallon.hashCode(),oneLiter.hashCode());
  }

  @Test
  public void oneTonShouldBeEqualToThousandKg() {
    ArithmeticMeasurement oneTon = ArithmeticMeasurement.inTons(1);
    ArithmeticMeasurement thousandKg = ArithmeticMeasurement.inKgs(1000);
    assertEquals(oneTon, thousandKg);
    assertEquals(oneTon.hashCode(),thousandKg.hashCode());
  }

  @Test
  public void oneKgShouldBeEqualToThousandGrams() {
    ArithmeticMeasurement oneKg = ArithmeticMeasurement.inKgs(1);
    ArithmeticMeasurement thousandGrams = ArithmeticMeasurement.inGrams(1000);
    assertEquals(oneKg, thousandGrams);
    assertEquals(oneKg.hashCode(),thousandGrams.hashCode());
  }

  @Test
  public void shouldGiveFourInchesOnAddingTwoAndTwoInches() throws IncompatibleTypeException {
    ArithmeticMeasurement twoInch = ArithmeticMeasurement.inInches(2);
    ArithmeticMeasurement otherTwoInch = ArithmeticMeasurement.inInches(2);
    ArithmeticMeasurement fourInches = ArithmeticMeasurement.inInches(4);
    assertEquals(fourInches, twoInch.add(otherTwoInch));
    assertEquals(fourInches.hashCode(),twoInch.add(otherTwoInch).hashCode());
  }

  @Test
  public void shouldNotGiveThreeInchesOnAddingTwoAndTwoInches() throws IncompatibleTypeException {
    ArithmeticMeasurement twoInch = ArithmeticMeasurement.inInches(2);
    ArithmeticMeasurement otherTwoInch = ArithmeticMeasurement.inInches(2);
    ArithmeticMeasurement threeInches = ArithmeticMeasurement.inInches(3);
    assertNotEquals(threeInches, twoInch.add(otherTwoInch));
    assertNotEquals(threeInches.hashCode(),otherTwoInch.hashCode());
  }

  @Test(expected = IncompatibleTypeException.class)
  public void shouldThrowExceptionWhileAddingTwoDifferentQuantities() throws IncompatibleTypeException {
    ArithmeticMeasurement twoInch = ArithmeticMeasurement.inInches(2);
    ArithmeticMeasurement twoGallon = ArithmeticMeasurement.inGallons(2);
    twoInch.add(twoGallon);
  }

  @Test
  public void shouldAdd2InchesAnd2Not5CmsAndGet3Inches() throws IncompatibleTypeException {
    ArithmeticMeasurement twoInches = ArithmeticMeasurement.inInches(2);
    ArithmeticMeasurement twoNotFiveCms = ArithmeticMeasurement.inCentimeters(2.5);
    // :todo - toUnit method is returning
    Measurement threeInches = ArithmeticMeasurement.inInches(3);
    assertEquals(threeInches,twoInches.add(twoNotFiveCms).toUnit(Unit.INCHES));
  }

  @Test
  public void shouldAdd1GallonAnd1litersAndGive4Not78Liters() throws IncompatibleTypeException {
    ArithmeticMeasurement oneGallon = ArithmeticMeasurement.inGallons(1);
    ArithmeticMeasurement oneLiters = ArithmeticMeasurement.inLitres(1);
    ArithmeticMeasurement fourNotSevenLitres = ArithmeticMeasurement.inLitres(4.78);
    assertNotEquals(oneGallon.add(oneLiters).toString(),fourNotSevenLitres.toString());
  }

}