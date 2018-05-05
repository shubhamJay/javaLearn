package com.step;

public interface Rule {
  void validate(ColourStatistics ballColourStats, Ball ballToBeAdded) throws CannotAddException;
}
