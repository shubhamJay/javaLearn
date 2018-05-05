import java.util.ArrayList;

public class DinningTable {
  private static boolean firstFork = true;
  private static boolean secondFork = true;
  private static boolean thirdFork = true;
  private static boolean fourthFork = true;
  private static boolean fifthFork = true;
  private ArrayList<Philosopher> philosophers;

  public DinningTable(ArrayList<Philosopher> philosophers) {
    this.philosophers = philosophers;
  }

}
