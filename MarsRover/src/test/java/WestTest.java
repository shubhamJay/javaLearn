import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WestTest {

  private Directions west;

  @Before
  public void setUp() {
    west = Directions.WEST;
  }

  @Test
  public void shouldGiveSouthForItsLeftDirection() {
    assertThat(west.left(),is(Directions.SOUTH));
  }

  @Test
  public void shouldGiveNorthForItsRightDirection() {
    assertThat(west.right(),is(Directions.NORTH));
  }

  @Test
  public void shouldMinusOneUnitOfXAxisFromGivenPosition() {
    assertThat(west.move(new Location(1,2)),is(new Location(0,2)));
  }
}