import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RoverTest {

  private Location startingLocation;
  private Directions mockedDirection;
  private Rover rover;
  private Platue mockedSurface;
  private Position roverPos;

  @Before
  public void setUp() {
    startingLocation = new Location(0, 0);
    mockedDirection = mock(Directions.NORTH.getDeclaringClass());
    when(mockedDirection.notation()).thenReturn("N");
    roverPos = new Position(startingLocation, mockedDirection);
    rover = new Rover(roverPos);
    mockedSurface = mock(Platue.class);
  }

  @Test
  public void shouldTurnLeft() {
    rover.turnLeft();
    verify(mockedDirection).left();
  }

  @Test
  public void shouldTurnRight() {
    rover.turnRight();
    verify(mockedDirection).right();
  }

  @Test
  public void shouldMove() {

    rover.move(mockedSurface);
    verify(mockedDirection).move(startingLocation);
  }

  @Test
  public void shouldGivePositionInSpaceSeparatedFormat() {
    String output = rover.getCurrentCoOrds();
    assertEquals(output,"0 0 N");
  }

  @Test
  public void shouldCheckAfterMovementThatCurrentPositionInOnGivenSurface() {
    rover.move(mockedSurface);
    verify(mockedSurface).hasCoOrd(roverPos);
  }

  @Test
  public void shouldFireBeaconWhenRoverGoesOutOfSurface() {
    when(mockedSurface.hasCoOrd(roverPos)).thenReturn(false);
    rover.move(mockedSurface);
    verify(mockedSurface).markBeacon(roverPos);
  }
}
