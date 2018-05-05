import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

  private Cell cell;
  private Coin coin;

  class TestCoin extends Coin {
    private boolean isKillCalled;

    public TestCoin(int id) {
      super(id);
      isKillCalled = false;
    }

//    public void kill(){
//      isKillCalled = true;
//    }
  }


  @Before
  public void setUp() throws Exception {
    cell = new Cell(1);
    // : todo use mockito
    coin = new TestCoin(1);
  }

  @Test
  public void shouldAddCoinToCell() {
    assertTrue(cell.addCoin(coin));
  }

//  @Test
//  public void shouldKillPreviousCoinsInCell() {
//    cell.addCoin(coin);
//    cell.addCoin(new TestCoin(1));
//    TestCoin testcoin = (TestCoin) coin;
//    assertTrue(testcoin.isKillCalled);
//  }

  // : todo kill Test;

  @Test
  public void shouldRemoveCoinFromCell() {
    cell.addCoin(coin);
    assertTrue(cell.removeCoin(coin));
  }

}