package bootcamp3;

import org.junit.Test;

import static bootcamp3.Unit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UnitTest {
  @Test
  public void shouldConvertOneTonToGrams() {
    assertThat(TONS.toUnit(1,GMS),is(1000000D));
  }

  @Test
  public void shouldConvertOneGallonTo3Not78Liters() {
    assertThat(GALLONS.toUnit(1,LITRES),is(3.78D));
  }

  @Test
  public void shouldGive212FahrenheitFor100Celsius() {
    assertThat(CELSIUS.toUnit(100,FAHRENHEIT),is(212D));
  }

  @Test
  public void shouldGive32FahrenheitFor0Celsius() {
    assertThat(CELSIUS.toUnit(0,FAHRENHEIT),is(32D));
  }

  @Test
  public void shouldGive100CelsiusFor212Fahrenheit() {
    assertThat(FAHRENHEIT.toUnit(212,CELSIUS),is(100D));
  }

  @Test
  public void shouldGive0CelsiusFor32Fahrenheit() {
    assertThat(FAHRENHEIT.toUnit(32,CELSIUS),is(0D));
  }
}