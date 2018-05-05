import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SafeCellTest {

  private SafeCell safeCell;
  private Coin coin;

  @Before
  public void setUp() throws Exception {
    safeCell = new SafeCell(1);
    coin = new Coin(1);
  }

  @Test
  public void shouldAddCoinToSafeCell() {
    assertTrue(safeCell.addCoin(coin));
  }
}