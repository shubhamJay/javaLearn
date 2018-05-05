package com.step.bootcamp;

import java.util.Objects;

//understands chances of occurrences of an event
public class Probability {
  private final double chancesOfOccurrence;

  public Probability(double chancesOfOccurrence) {
    this.chancesOfOccurrence = chancesOfOccurrence;
  }

  public Probability not() {
    return new Probability((double) Math.round((1 - chancesOfOccurrence)*10000)/10000);
  }

  @Override
  public boolean equals(Object obj){
    if (this == obj) return true;
    if (obj == null) return false;
    return obj instanceof Probability && this.chancesOfOccurrence == ((Probability) obj).chancesOfOccurrence ;
  }

  @Override
  public int hashCode() {

    return Objects.hash(chancesOfOccurrence);
  }

  @Override
  public String toString() {
    return "Probability{" +
            "chancesOfOccurrence=" + chancesOfOccurrence +
            '}';
  }

  public Probability and(Probability other) {
    return new Probability(this.chancesOfOccurrence * other.chancesOfOccurrence);
  }

  public Probability or(Probability other) {
    return this.not()
            .and(other.not())
            .not();
  }
}
