import java.util.Objects;

public class Location {
  private final int xCoOrd;
  private final int yCoOrd;

  public Location(int XCoOrd, int YCoOrd) {
    xCoOrd = XCoOrd;
    yCoOrd = YCoOrd;

  }

  @Override
  public String toString() {
    return String.format("%d %d", xCoOrd,yCoOrd);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Location location = (Location) o;
    return xCoOrd == location.xCoOrd &&
            yCoOrd == location.yCoOrd;
  }

  @Override
  public int hashCode() {
    return Objects.hash(xCoOrd, yCoOrd);
  }

  public Location add(int xCoOrdToAdd, int yCoOrdToAdd) {
    return new Location(xCoOrd+xCoOrdToAdd,yCoOrd+yCoOrdToAdd);
  }

  public boolean lieBetween(Location lowerLocation, Location upperLocation) {
    return isSmallerThan(upperLocation) && isGreaterThan(lowerLocation);
  }

  private boolean isSmallerThan(Location location) {
    return xCoOrd <= location.xCoOrd && yCoOrd <= location.yCoOrd;
  }

  private boolean isGreaterThan(Location location) {
    return xCoOrd >= location.xCoOrd && yCoOrd >= location.yCoOrd;
  }
}
