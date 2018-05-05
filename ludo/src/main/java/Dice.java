
public class Dice {
  private final int max;
  private final int min;

  public Dice() {
    this.min = 1;
    this.max = 6;
  }

  public int roll() {
    return (int) Math.round(Math.random() * this.max);
  }
}
