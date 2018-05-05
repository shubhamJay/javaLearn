public class SafeCell extends Cell {

  public SafeCell(int id) {
    super(id);
  }

  @Override
  public boolean addCoin(Coin coin) {
    return super.addCoin(coin);
  }
}
