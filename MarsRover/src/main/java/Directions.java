import java.security.cert.X509Certificate;

public enum Directions {

  EAST(1,0){
    @Override
    public Directions left() { return NORTH; }

    @Override public Directions right() { return SOUTH; }

    @Override public String notation() { return "E"; }

  },
  WEST(-1,0){
    @Override
    public Directions left() { return SOUTH; }

    @Override
    public Directions right() { return NORTH; }

    @Override
    public String notation() { return "W"; }

  },
  NORTH(0,1){
    @Override
    public Directions left() { return WEST; }

    @Override
    public Directions right() { return EAST; }

    @Override
    public String notation() { return "N"; }

  },
  SOUTH(0,-1){
    @Override
    public Directions left() { return EAST; }

    @Override
    public Directions right() { return WEST; }

    @Override
    public String notation() { return "S"; }
  };

  private final int xOffset;
  private final int yOffset;

  Directions(int xOffset,int yOffset) {
    this.xOffset = xOffset;
    this.yOffset = yOffset;
  }

  abstract public Directions left();

  abstract public Directions right();

  abstract public String notation();

  public Location move(Location pos){
    return pos.add(xOffset,yOffset);
  }

  public Location previousLocation(Location location) {
    return location.add(xOffset*(-1),yOffset*(-1));
  }
}
