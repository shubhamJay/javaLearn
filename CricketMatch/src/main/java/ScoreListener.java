public interface ScoreListener {
  void addScore(int result,int totalBallCount);
  void overFinished(int ballsRemaining);
}
