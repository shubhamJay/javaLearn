import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NorthTest {

  private Directions north;

  @Before
  public void setUp() throws Exception {
    north = Directions.NORTH;
  }

  @Test
  public void shouldGiveWestForItsLeftDirection() {
    assertThat(north.left(), is(Directions.WEST));
  }

  @Test
  public void shouldGiveEastForItsRightDirection() {
    assertThat(north.right(), is(Directions.EAST));
  }

  @Test
  public void shouldAddOneUnitOfYAxisFromGivenPosition() {
    assertThat(north.move(new Location(1, 2)), is(new Location(1, 3)));
  }
}