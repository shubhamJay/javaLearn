package com.step.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

// ensures that it behave like rectangle
public class RectangleTest {

  private Rectangle rectangle;

  @Before
  public void setUp() throws Exception {
    rectangle = new Rectangle(10, 20);
  }

  @Test
  public void shouldGiveArea200WhenLengthIs10AndBreadthIs20() {
    assertThat(rectangle.area(), is(200));
  }

  @Test
  public void shouldGivePerimeter60WhenLengthIs10AndBreathIs20() {
    assertThat(rectangle.perimeter(), is(60));
  }
}