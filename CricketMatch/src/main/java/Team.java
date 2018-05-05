import java.util.ArrayList;

public class Team extends ArrayList<Player> {
  private int currentPlayer;

  private Team() {
    this.currentPlayer = 0;
  }

  public Player getPlayerToPlay(){
    return this.get(currentPlayer++);
  }

  public static Team create(Player striker,Player nonStriker){
    Team players = new Team();
    players.add(striker);
    players.add(nonStriker);
    return players;

  }

}
