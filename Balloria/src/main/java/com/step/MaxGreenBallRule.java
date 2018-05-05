package com.step;


public class MaxGreenBallRule implements Rule {
  @Override
  public void validate(ColourStatistics ballColourStats, Ball ballToBeAdded) throws CannotAddException {
    if(!ballToBeAdded.isOfColour(Colour.GREEN))
      return;
    long numberOfGreenBalls = ballColourStats.countOf(Colour.GREEN);
    if(numberOfGreenBalls == 3)
      throw new CannotAddException("Max green balls already added");
  }
}
