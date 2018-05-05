import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RoverMotionControllerTest {

  private Rover mockedRover;
  private RoverMotionController roverMotionController;
  private Platue mockedPlatue;

  @Before
  public void setUp() {
    mockedRover = mock(Rover.class);
    mockedPlatue = mock(Platue.class);
    roverMotionController = new RoverMotionController(mockedPlatue);
    roverMotionController.add(mockedRover);
    roverMotionController.add("L",new TurnLeftAction());
    roverMotionController.add("R",new TurnRightAction());
    roverMotionController.add("M",new MoveAction());
  }

  @Test
  public void shouldTurnLeftOfNorth() {
    roverMotionController.moveRoverBy("L");
    verify(mockedRover).turnLeft();
  }

  @Test
  public void shouldTurnRightOfNorth() {
    clearInvocations(mockedRover);
    roverMotionController.moveRoverBy("R");
    verify(mockedRover).turnRight();
  }

  @Test
  public void shouldMoveTheRoverBy1UnitWhenInstructionIsMove() {
    roverMotionController.moveRoverBy("M");
    verify(mockedRover).move(mockedPlatue);
  }

  @Test
  public void shouldEvaluateMultipleInstructionAtTheSameTime() {
    roverMotionController.moveRoverBy("MLM");

    verify(mockedRover, times(2)).move(mockedPlatue);
    verify(mockedRover).turnLeft();
  }
}