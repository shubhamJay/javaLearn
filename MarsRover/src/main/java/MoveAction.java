public class MoveAction implements RoverActions {
  @Override
  public void execute(Rover rover, Surface surface) {
    rover.move(surface);
  }
}
