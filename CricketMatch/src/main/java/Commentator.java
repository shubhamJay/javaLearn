public class Commentator {
  private  String playerName = null;
  private int overCount;
  private int ballCount;

  public void showScore(int result,int bowledBalls ,Player striker) {
    registerPlayerName(striker);
    registerBalls(bowledBalls);
    String sentence = String.format("%d.%d %s scores %d runs",overCount,ballCount,playerName,result);
    System.out.println(sentence);
  }

  private void registerBalls(int totalBallCount) {
    this.overCount = totalBallCount / 6;
    this.ballCount = totalBallCount % 6;
  }

  private void registerPlayerName(Player player) {
    player.accept(this);
  }

  public void addName(String name) {
    this.playerName = name;
  }

  public void showOverScore(int runsRequired, int ballsRemaining) {
    registerBalls(ballsRemaining);
    String sentence = String.format("%d required in %d overs\n",runsRequired,overCount);
    System.out.println(sentence);
  }
}
