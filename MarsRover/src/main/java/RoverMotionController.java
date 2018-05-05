import java.util.HashMap;

public class RoverMotionController {
  private final Platue platue;
  private Rover rover = null;
  private HashMap <String , RoverActions> actions;

  public RoverMotionController(Platue platue) {
    this.platue = platue;
    this.actions = new HashMap<>();
  }

  public String moveRoverBy(String givenInstructions) {
    String[] separatedInstruction = givenInstructions.split("");

    for (String instructionToExecute : separatedInstruction) {
      actions.get(instructionToExecute).execute(rover,platue);
    }
    return rover.getCurrentCoOrds();
  }

  public void add(Rover rover) {
    this.rover = rover;
  }

  public void add(String command, RoverActions action){
    actions.put(command,action);
  }
}
