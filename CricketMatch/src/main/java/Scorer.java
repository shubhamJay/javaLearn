public class Scorer implements ScoreListener{
  private int runsUpTillNow;

  public Scorer() {
    this.runsUpTillNow = 0;
  }

  @Override
  public void addScore(int runs, int ballCount) {
    runsUpTillNow += runs;
  }

  @Override
  public void overFinished(int ballsRemaining) {
    return;
  }

  public boolean hasReachedTo(int target) {
    return target <= runsUpTillNow;
  }

  public int runsRequiredToComplete(int target) {
    return target - runsUpTillNow;
  }
}
