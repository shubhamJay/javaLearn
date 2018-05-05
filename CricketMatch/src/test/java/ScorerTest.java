import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScorerTest {

  private Scorer scorer;

  @Before
  public void setUp() {
    scorer = new Scorer();
  }

  @Test
  public void shouldGiveTrueWhenGivenTargetIsAchieved () {
    scorer.addScore(2,1);
    scorer.addScore(2,2);
    scorer.addScore(2,3);
    assertTrue(scorer.hasReachedTo(6));
  }

  @Test
  public void shouldGiveFalseWhenGivenTargetIsNotAchieved() {
    scorer.addScore(2,1);
    scorer.addScore(2,2);
    assertFalse(scorer.hasReachedTo(6));
  }

  @Test
  public void shouldGiveRunsRequiredToReachGivenTarget() {
    scorer.addScore(2,1);
    scorer.addScore(2,2);
    assertEquals(scorer.runsRequiredToComplete(10),6);
  }
}