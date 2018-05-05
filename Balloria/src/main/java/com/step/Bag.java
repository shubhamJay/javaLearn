package com.step;

import java.util.ArrayList;

public class Bag {
  private final Balls balls;
  private final int capacity;

  public Bag(int capacity) {
    this.capacity = capacity;
    balls = new Balls();
  }

  public void add(Ball ball) throws CannotAddException {
    Rule greenBallRule = new MaxGreenBallRule();
    Rule redBallRule = new MaxRedBallRule();
    Rule yellowBallRule = new MaxYellowBallRule();

    if(isFull())
      throw new CannotAddException("No space for more balls");

    greenBallRule.validate(balls, ball);
    redBallRule.validate(balls, ball);
    yellowBallRule.validate(balls, ball);

    balls.add(ball);
  }

  private boolean isFull() {
    return balls.size() == capacity;
  }
}
