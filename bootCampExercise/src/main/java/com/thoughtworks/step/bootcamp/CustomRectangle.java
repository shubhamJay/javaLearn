package com.thoughtworks.step.bootcamp;

//Understands enclosed shape with 4 corners at right angle
public class CustomRectangle {
  private final double length;
  private final double breadth;
  
  private CustomRectangle(double length, double breadth) {
    this.length = length;
    this.breadth = breadth;
  }
  
  public static CustomRectangle createRectangle(double length, double breadth) {
    return new CustomRectangle(length, breadth);
  }
  
  public static CustomRectangle createSquare(double side) {
    return new CustomRectangle(side,side);
  }
  
  public double area() {
    return length*breadth;
  }
  
  public double perimeter() {
    return 2*(length+breadth);
  }
}
