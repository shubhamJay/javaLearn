package com.step;

public class MaxYellowBallRule implements Rule {
  @Override
  public void validate(ColourStatistics ballColourStats, Ball ballToBeAdded) throws CannotAddException {
    if(!ballToBeAdded.isOfColour(Colour.YELLOW))
      return;
    if(ballColourStats.percentageIfAdded(Colour.YELLOW) > 40)
      throw new CannotAddException("Max yellow balls already added");
  }
}
