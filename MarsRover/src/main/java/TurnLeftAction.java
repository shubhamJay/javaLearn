public class TurnLeftAction implements RoverActions {
  @Override
  public void execute(Rover rover, Surface surface) {
    rover.turnLeft();
  }
}
