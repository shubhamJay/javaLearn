public class Match implements ScoreListener {

  private final Umpire umpire;
  private final Team battingTeam;
  private final Scorer scorer;
  private Player striker;
  private Player nonStriker;
  private final int target;
  private Commentator commentator;

  private Match(Team battingTeam, Umpire umpire, Scorer scorer) {
    this.umpire = umpire;
    this.battingTeam = battingTeam;
    this.scorer = scorer;
    this.target = 40;
    this.commentator = new Commentator();
    this.striker = battingTeam.getPlayerToPlay();
    this.nonStriker = battingTeam.getPlayerToPlay();
  }

  public static Match create(Team battingTeam, int overs) {
    Umpire umpire = new Umpire(overs);
    Scorer scorer = new Scorer();
    umpire.addListener(scorer);

    Match match = new Match(battingTeam, umpire, scorer);
    umpire.addListener(match);
    return match;
  }

  public void start() {
    do {
      umpire.declareResult(striker.bat());
    }
    while (!hasWon() && !umpire.isFinished());
  }

  @Override
  public void addScore(int result, int ballCount) {
    this.striker.addScore(result);
    this.commentator.showScore(result, ballCount, striker);
    if (result % 2 == 1) {
      changeStrike();
    }
  }

  @Override
  public void overFinished(int ballsRemaining) {
    changeStrike();
    int runsRequired = scorer.runsRequiredToComplete(target);
    commentator.showOverScore(runsRequired,ballsRemaining);
  }

  private void changeStrike() {
    Player currentStriker = this.striker;
    this.striker = this.nonStriker;
    this.nonStriker = currentStriker;
  }

  private boolean hasWon() {
    return scorer.hasReachedTo(target);
  }
}
