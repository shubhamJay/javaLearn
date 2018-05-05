import java.util.ArrayList;

public class Game {
  private final String name;
  private ArrayList<Player> players;
  private int capacity;
  private Turn turn;

  public Game(String name,int capacity) {
    this.name = name;
    this.capacity = capacity;
    this.players = new ArrayList<>();
  }

  public boolean addPlayer(String name) {
    if (this.hasEnoughPlayers()) return false;
    return players.add(new Player(name,new Coins(),new Route()));
  }


  public boolean hasEnoughPlayers() {
    return players.size() == capacity;
  }

//  //: todo : GamesManagerWillStartGame;
//  public boolean isStarted() {
//    return this.turn != null;
//  }
}
