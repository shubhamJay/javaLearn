import java.util.ArrayList;

public class Platue implements Surface {
  private final Location upperLocationOfPlatue;
  private final Location lowerLocationOfPlatue;
  private ArrayList<Position> dangerPlaces;

  public Platue(Location upperLocationOfPlatue) {
    this.lowerLocationOfPlatue = new Location(0,0);
    this.upperLocationOfPlatue = upperLocationOfPlatue;
    this.dangerPlaces = new ArrayList<>();
  }

  @Override
  public boolean hasCoOrd(Position roverPos) {
    return roverPos.lieBetween(lowerLocationOfPlatue,upperLocationOfPlatue);
  }

  @Override
  public void markBeacon(Position position) {
    this.dangerPlaces.add(position);
  }
}
