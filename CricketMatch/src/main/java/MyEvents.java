import java.util.ArrayList;

public class MyEvents {

  private ArrayList<ScoreListener> listeners;

  public MyEvents() {
    this.listeners = new ArrayList<>();
  }

  protected boolean addListener(ScoreListener listener) {
    return this.listeners.add(listener);
  }

  protected void runs(int result, int ballCount) {
    for (ScoreListener listener : this.listeners) {
      listener.addScore(result,ballCount);
    }
  }

  protected void overFinished(int remainingBalls) {
    for (ScoreListener listener : listeners) {
      listener.overFinished(remainingBalls);
    }
  }
}
