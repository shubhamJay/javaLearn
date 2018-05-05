package com.step;

public class Ball {
  public static final Ball BLUE = new Ball(Colour.BLUE);
  public static final Ball RED = new Ball(Colour.RED);
  public static final Ball YELLOW = new Ball(Colour.YELLOW);

  private final Colour colour;

  public Ball(Colour colour) {
    this.colour = colour;
  }

  public static Ball createGreen() {
    return new Ball(Colour.GREEN);
  }

  public boolean isOfColour(Colour colour) {
    return this.colour==colour;
  }
}
