import java.util.HashMap;
import java.util.Scanner;

public class Start {

  private  static HashMap<String,Directions> directions = new HashMap<>();
  private static RoverMotionController roverMotionController;
  private static Platue platue;

  static {
    directions.put("N",Directions.NORTH);
    directions.put("S",Directions.SOUTH);
    directions.put("E",Directions.EAST);
    directions.put("W",Directions.WEST);
    roverMotionController.add("L",new TurnLeftAction());
    roverMotionController.add("R",new TurnRightAction());
    roverMotionController.add("M",new MoveAction());
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String platueUpperCoOrds = scanner.nextLine();
    platue = createPlatue(platueUpperCoOrds);
    new RoverMotionController(platue);


    for (int i = 0; i < 2; i++) {
      String initialLocation = scanner.nextLine();
      Rover rover = createRover(initialLocation);
      String instructions = scanner.nextLine() ;
      roverMotionController.add(rover);
      roverMotionController.moveRoverBy(instructions);
      System.out.println(rover.getCurrentCoOrds());
    }
  }

  private static Platue createPlatue(String platueUpperCoOrds) {
    String[] separatedUpperCoOrds = platueUpperCoOrds.split(platueUpperCoOrds);
    int xCoOrd = Integer.parseInt(separatedUpperCoOrds[0]);
    int yCoOrd = Integer.parseInt(separatedUpperCoOrds[1]);
    Location upperLocationOfPlatue = new Location(xCoOrd, yCoOrd);
    return new Platue(upperLocationOfPlatue);
  }


  private static Rover createRover(String coOrds) {
    String[] separatedCoOrds = coOrds.split(" ");
    int XCoOrd = Integer.parseInt(separatedCoOrds[0]);
    int YCoOrd = Integer.parseInt(separatedCoOrds[1]);
    Location location = new Location(XCoOrd, YCoOrd);
    Directions direction = directions.get(separatedCoOrds[2]);
    return new Rover(new Position(location,direction));
  }
}
