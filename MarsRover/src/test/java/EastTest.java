import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EastTest {
  private Directions east;

  @Before
  public void setUp() {
    east = Directions.EAST;
  }

  @Test
  public void shouldGiveNorthForItsLeftDirection() {
    assertThat(east.left(),is(Directions.NORTH));
  }

  @Test
  public void shouldGiveSouthForItsRightDirection() {
    assertThat(east.right(),is(Directions.SOUTH));
  }

  @Test
  public void shouldMinusOneUnitOfXAxisFromGivenPosition() {
    assertThat(east.move(new Location(1,2)),is(new Location(2,2)));
  }
}
