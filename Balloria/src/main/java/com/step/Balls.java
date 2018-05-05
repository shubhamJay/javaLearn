package com.step;

public class Balls extends java.util.ArrayList<Ball> implements ColourStatistics {
  @Override
  public long countOf(Colour colour) {
    return this.stream().filter(ball -> ball.isOfColour(colour)).count();
  }

  @Override
  public long percentageIfAdded(Colour colour) {
    long numberOfYellowBalls = this.countOf(Colour.YELLOW) + 1;
    return numberOfYellowBalls * 100/(this.size() + 1);
  }
}
