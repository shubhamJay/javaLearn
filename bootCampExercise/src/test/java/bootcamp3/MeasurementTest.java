package bootcamp3;

import org.junit.Test;

import static org.junit.Assert.*;

public class MeasurementTest {

  @Test
  public void shouldReturnTrueFor212F_equalsTo_100C() {
    Measurement hundredCelsius = Measurement.inCelsius(100);
    Measurement twoOneTwoFahrenheit = Measurement.inFahrenheit(212);
    assertEquals(hundredCelsius,twoOneTwoFahrenheit);
    assertEquals(hundredCelsius.hashCode(),twoOneTwoFahrenheit.hashCode());
  }

  @Test
  public void shouldReturnTrueFor32F_equalsTo_0C() throws IncompatibleTypeException {
    Measurement zeroCelsius = Measurement.inCelsius(4);
    Measurement threeTwoFahrenheit = Measurement.inFahrenheit(39.2);
    assertEquals(zeroCelsius,threeTwoFahrenheit);
  }

}