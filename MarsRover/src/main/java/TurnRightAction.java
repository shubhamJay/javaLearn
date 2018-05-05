public class TurnRightAction implements RoverActions {

  @Override
  public void execute(Rover rover, Surface surface) {
    rover.turnRight();
  }
}
