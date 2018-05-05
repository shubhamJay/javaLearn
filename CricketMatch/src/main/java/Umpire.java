public class Umpire extends MyEvents {
  private final int totalBalls;
  private int ballCount;

  public Umpire(int overs) {
    super();
    this.totalBalls = overs * 6;
    this.ballCount = 0;

  }

  public void declareResult(int result) {
    super.runs(result,++ballCount);
    if (ballCount % 6 == 0) super.overFinished(remainingBalls());
  }

  private int remainingBalls() {
    return totalBalls - ballCount;
  }


  public boolean isFinished() {
    return this.ballCount == totalBalls;
  }
}
