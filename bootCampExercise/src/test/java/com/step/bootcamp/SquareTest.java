package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

// ensures that it behaves like a square
public class SquareTest {
  @Test
  public void shouldGiveArea400WhenSideIs20() {
    Rectangle square = Rectangle.createSquare(20);
    assertThat(square.area(),is(400));
  }

  @Test
  public void shouldGiveCorrectAreaForAnyGivenSide() {
    Rectangle square = Rectangle.createSquare(30);
    assertThat(square.area(),is(900));
  }

  @Test
  public void shouldGivePerimeter80WhenSideIs20() {
    Rectangle square = Rectangle.createSquare(20);
    assertThat(square.perimeter(),is(80));
  }

  @Test
  public void shouldGiveCorrectPerimeterForAnyGivenSide() {
    Rectangle square = Rectangle.createSquare(30);
    assertThat(square.perimeter(),is(120));
  }
}