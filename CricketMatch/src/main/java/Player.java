public class Player {

  private final String name;
  private int scoredRuns;
  private int ballsPlayed;

  public Player(String name) {
    this.name = name;
    this.scoredRuns = 0;
    this.ballsPlayed= 0;
  }

  public void addScore(int runs){
    scoredRuns +=  runs;
    ++ballsPlayed;
  }

  public int bat() {
    return 3;
  }

  public void accept(Commentator commentator) {
    commentator.addName(name);
  }
}

