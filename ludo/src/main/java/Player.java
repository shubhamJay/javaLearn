import java.util.HashSet;

public class Player {
  private final String name;
  private Coins coins;
  private Route path;

  public Player(String name, Coins coins, Route path) {

    this.name = name;
    this.coins = coins;
    this.path = path;
  }

  public Coins getMovableCoin() {
    return path.getMovableCoins(coins);
  }


}
