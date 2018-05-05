import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SouthTest {

  private Directions south;

  @Before
  public void setUp() throws Exception {
    south = Directions.SOUTH;
  }

  @Test
  public void shouldGiveEastForItsLeftDirection() {
    assertThat(south.left(),is(Directions.EAST));
  }

  @Test
  public void shouldGiveWestForItsRightDirection() {
    assertThat(south.right(),is(Directions.WEST));
  }

  @Test
  public void shouldMinusOneUnitOfYAxisFromGivenPosition() {
    assertThat(south.move(new Location(1,2)),is(new Location(1,1)));
  }
}