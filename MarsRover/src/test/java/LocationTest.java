import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LocationTest {

  private Location location;

  @Before
  public void setUp() {
    location = new Location(1, 1);
  }

  @Test
  public void shouldGiveCoordinatesInSpaceSeparatedFormat() {
    assertEquals(location.toString(), "1 1");
  }

  @Test
  public void PositionsWithSameCoOrdinatesShouldBeEqual() {
    location.equals(new Location(1, 1));
  }

  @Test
  public void shouldGiveNewPositionAfterAddingGivenCoOrdinates() {
    Location outputPos = location.add(1, 3);
    Location expectedPos = new Location(2, 4);
    assertThat(outputPos, is(expectedPos));
  }
  @Test
  public void shouldGiveTrueWhenLocationLiesBetweenGivenLocations() {
    assertTrue(location.lieBetween(new Location(0,0),new Location(1
            ,2)));
  }

  @Test
  public void shouldGiveTrueWhenLocationIsSameAsUpperLocationLocation() {
    assertTrue(location.lieBetween(new Location(0,1),new Location(1,1)));
  }

  @Test
  public void shouldGiveTrueWhenLocationIsSameAsLowerLocationLocation() {
    assertTrue(location.lieBetween(new Location(1,1),new Location(3,3)));
  }
}