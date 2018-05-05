import java.util.Objects;

public class Position {
  private Location location;
  private Directions direction;

  public Position(Location location, Directions direction) {
    this.location = location;
    this.direction = direction;
  }

  public boolean lieBetween(Location lowerLocation, Location upperLocation) {
    return location.lieBetween(lowerLocation,upperLocation);
  }

  public void left(){
    this.direction = direction.left();
  }

  public void right(){
    this.direction  = direction.right();
  }

  public void move(){
    this.location = this.direction.move(location);
  }

  @Override
  public String toString() {
    return String.format("%s %s",location.toString(),direction.notation());

  }

  public Position getLastPosition() {
    Location previousLocation = this.direction.previousLocation(location);
    return new Position(previousLocation,this.direction);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position position = (Position) o;
    return location.equals(position.location) &&
            direction == position.direction;
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, direction);
  }
}
