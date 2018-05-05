public class Cell{
  private int id;
  private Coins coins;

  public Cell(int id) {
    this.id = id;
    this.coins = new Coins();
  }

  public boolean addCoin(Coin coin){
    return coins.add(coin);
  }

  public boolean removeCoin(Coin coin) {
    return coins.remove(coin);
  }
}
