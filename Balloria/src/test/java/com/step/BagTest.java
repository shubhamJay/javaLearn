package com.step;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BagTest {

  public static final String NO_SPACE_FOR_MORE_BALLS = "No space for more balls";
  public static final String MAX_GREEN_BALLS_ALREADY_ADDED = "Max green balls already added";
  public static final String MAX_RED_BALLS_ALREADY_ADDED = "Max red balls already added";
  public static final String MAX_YELLOW_BALLS_ALREADY_ADDED = "Max yellow balls already added";
  private Bag bag;

  @Before
  public void setUp() {
    bag = new Bag(12);
  }

  @Test
  public void shouldNotAddMoreThan12Balls() throws CannotAddException {
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.createGreen());
    bag.add(Ball.createGreen());
    bag.add(Ball.RED);
    bag.add(Ball.YELLOW);
    bag.add(Ball.RED);
    bag.add(Ball.YELLOW);
    bag.add(Ball.RED);
    bag.add(Ball.YELLOW);
    bag.add(Ball.createGreen());
    assertThatThrownBy(()->bag.add(Ball.createGreen()))
        .isInstanceOf(CannotAddException.class)
    .hasMessage(NO_SPACE_FOR_MORE_BALLS);
  }

  @Test
  public void shouldNotAllowMoreThan3GreenBalls() throws CannotAddException {
    bag.add(Ball.createGreen());
    bag.add(Ball.RED);
    bag.add(Ball.createGreen());
    bag.add(Ball.RED);
    bag.add(Ball.createGreen());
    assertThatThrownBy(()->bag.add(Ball.createGreen()))
        .isInstanceOf(CannotAddException.class)
    .hasMessage(MAX_GREEN_BALLS_ALREADY_ADDED);
  }

  @Test
  public void shouldBeAbleToAddMoreThan3BallsOfOtherColor() throws CannotAddException {
    bag.add(Ball.createGreen());
    bag.add(Ball.RED);
    bag.add(Ball.createGreen());
    bag.add(Ball.RED);
    bag.add(Ball.RED);
    bag.add(Ball.RED);
    bag.add(Ball.createGreen());
    assertThat(bag).extracting("balls")
        .first().asList()
        .hasSize(7);
  }

  @Test
  public void shouldNotAllowRedBallsWhenNoGreenBallIsPresent() {
    assertThatThrownBy(()->bag.add(Ball.RED))
        .isInstanceOf(CannotAddException.class)
        .hasMessage(MAX_RED_BALLS_ALREADY_ADDED);
  }

  @Test
  public void shouldAllowRedBallsTwiceTheCountOfGreenBalls() throws CannotAddException {
    bag.add(Ball.createGreen());
    bag.add(Ball.createGreen());
    bag.add(Ball.RED);
    bag.add(Ball.RED);
    bag.add(Ball.RED);
    bag.add(Ball.RED);
    assertThatThrownBy(()->bag.add(Ball.RED))
        .isInstanceOf(CannotAddException.class)
        .hasMessage(MAX_RED_BALLS_ALREADY_ADDED);
  }

  @Test
  public void shouldAllowMax12BlueBalls() throws CannotAddException {
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    assertThat(bag).extracting("balls")
        .first().asList()
        .hasSize(12);
  }

  @Test
  public void shouldCreateBagOfOtherSizes() throws CannotAddException {
    Bag bag = new Bag(3);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    bag.add(Ball.BLUE);
    assertThatThrownBy(()->bag.add(Ball.createGreen()))
        .isInstanceOf(CannotAddException.class)
        .hasMessage(NO_SPACE_FOR_MORE_BALLS);
  }

  @Test
  public void shouldNotAllowFirstYellowBall() {
    assertThatThrownBy(()->bag.add(Ball.YELLOW))
        .isInstanceOf(CannotAddException.class)
        .hasMessage(MAX_YELLOW_BALLS_ALREADY_ADDED);
  }
}
