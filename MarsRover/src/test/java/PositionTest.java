import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PositionTest {

  private Position position;
  private Location mockedLocation;

  @Before
  public void setUp() {
    mockedLocation = mock(Location.class);
    position = new Position(mockedLocation, Directions.NORTH);
  }

  @Test
  public void shouldInvokeLieBetweenOfLocation() {
    Location lowerLocation = new Location(0, 0);
    Location upperLocation = new Location(3, 3);
    position.lieBetween(lowerLocation, upperLocation);
    verify(mockedLocation).lieBetween(lowerLocation,upperLocation);
  }

  @Test
  public void shouldGiveTrueWhenHasSameLocationAndDirection() {
    assertEquals(position,new Position(new Location(2,2),Directions.NORTH));
  }

  @Test
  public void shouldGivePreviousPosition() {
    assertThat(position.getLastPosition(),is(new Position(new Location(2,1),Directions.NORTH)));
  }
}