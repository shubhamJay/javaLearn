import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UmpireTest {


  private Umpire umpire;
  private ScoreListener mockedScorer;
  private ScoreListener mockedPlayer;

  private class TestPlayer implements ScoreListener {
    @Override
    public void addScore(int result,int ballCount) {
      return;
    }

    @Override
    public void overFinished(int ballsRemaining) {

    }
  }

  @Before
  public void setUp() throws Exception {
    umpire = new Umpire(4);
    mockedScorer = mock(Scorer.class);
    mockedPlayer = mock(TestPlayer.class);
  }

  @Test
  public void shouldInvokeAddScoreOfGivenListener() {
    umpire.addListener(mockedScorer);
    umpire.declareResult(2);
    verify(mockedScorer).addScore(2,1);
    }

  @Test
  public void shouldInvokeAddScoreOfAllListeners() {
    umpire.addListener(mockedPlayer);
    umpire.addListener(mockedScorer);
    umpire.declareResult(2);
    verify(mockedScorer).addScore(2,1);
    verify(mockedPlayer).addScore(2,1);
  }

  @Test
  public void shouldGiveTrueIfGameHasFinished() {
    Umpire umpire = new Umpire(1);
    umpire.declareResult(0);
    umpire.declareResult(0);
    umpire.declareResult(0);
    umpire.declareResult(0);
    umpire.declareResult(0);
    umpire.declareResult(0);
    assertTrue(umpire.isFinished());
  }

  @Test
  public void shouldGiveFalseIfGameIsNotFinishedYet() {
    Umpire umpire = new Umpire(1);
    umpire.declareResult(0);
    umpire.declareResult(0);
    umpire.declareResult(0);
    umpire.declareResult(0);
    assertFalse(umpire.isFinished());
  }

  @Test
  public void shouldInvokeOverFinishedMethodOfAllListeners() {
    umpire.addListener(mockedPlayer);
    umpire.addListener(mockedScorer);
    umpire.declareResult(2);
    umpire.declareResult(2);
    umpire.declareResult(2);
    umpire.declareResult(2);
    umpire.declareResult(2);
    umpire.declareResult(2);
    verify(mockedScorer).overFinished(18);
    verify(mockedPlayer).overFinished(18);
  }
}