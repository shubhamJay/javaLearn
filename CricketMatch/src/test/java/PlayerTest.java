import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlayerTest {

  private final int maxScore = 6;
  private final int minScore = -1;
  private Player kirat_boli;

  private boolean isValidScore(int result) {
    return result <= maxScore && result >= minScore;
  }

  @Before
  public void setUp() throws Exception {
    kirat_boli = new Player("Kirat Boli");
  }

  @Test
  public void shouldGiveResultOfPlayedBall() {
    int result = kirat_boli.bat();
    assertTrue(isValidScore(result));
  }
}