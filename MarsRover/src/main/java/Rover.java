
public class Rover {

  private final Position position;

  public Rover(Position position) {

    this.position = position;
  }

  public void turnLeft() {
    position.left();
  }

  public void turnRight() {
    position.right();
  }

  public void move(Surface surface) {
    position.move();
    if (surface.hasCoOrd(position)) fireBeacon(surface);
  }

  private void fireBeacon(Surface surface) {
    surface.markBeacon(position.getLastPosition());
  }

  public String getCurrentCoOrds() {
    return position.toString();
  }
}
