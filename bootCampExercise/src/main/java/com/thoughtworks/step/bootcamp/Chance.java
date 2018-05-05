package com.thoughtworks.step.bootcamp;

//understands mathematical concepts of probability(any number between 0 to 1)
public class Chance {
  private final double probability;
  
  public Chance(double probability) {
    this.probability = probability;
  }
  
  public Chance not() {
    return new Chance(pricise(1-probability));
  }
  
  @Override
  public boolean equals(Object other) {
    if(this==other) return true;
    if(other == null || !(other instanceof Chance)) return false;
    Chance chance = (Chance) other;
    return Double.compare(chance.probability,probability)==0;
  }
  
  public Chance and(Chance chance1) {
   double andVal = pricise(probability* chance1.probability);
    return new Chance(andVal);
  }
  
  public Chance or(Chance chance) {
//    double orVal = (probability + chance.probability - and(chance).probability);
    return (not().and(chance.not())).not();
//    return new Chance(pricise(orVal));
  }
  
  private double pricise(double number){
    number = (double) Math.round(number*100)/100;
    return number;
  }
  
  @Override
  public String toString() {
    return "Chance{" +
            "probability=" + probability +
            '}';
  }
}
