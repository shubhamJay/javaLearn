package com.step;

public class MaxRedBallRule implements Rule {
  @Override
  public void validate(ColourStatistics ballColourStats, Ball ballToBeAdded) throws CannotAddException {
    if(!ballToBeAdded.isOfColour(Colour.RED))
      return;

    long greenBallCount = ballColourStats.countOf(Colour.GREEN);
    long redBallCount = ballColourStats.countOf(Colour.RED);
    if(greenBallCount * 2 <= redBallCount)
      throw new CannotAddException("Max red balls already added");
  }
}
