import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MatchTest {

  private Player mockedPlayer;
  private Team battingTeam;
  private Match match;

  @Before
  public void setUp() throws Exception {
    mockedPlayer = mock(Player.class);
    battingTeam = Team.create(mockedPlayer,new Player("lala"));
    match = Match.create(battingTeam,1);
  }

  @Test
  public void shouldBeAbleToStartGame() {
    match.start();
    verify(mockedPlayer,times(6)).bat();
  }

  @Test
  public void shouldAddRunsToStrikerScore() {
    match.addScore(1,3);
    verify(mockedPlayer).addScore(1);
  }

  @Test
  public void finalTest() {
    Team battingTeam = Team.create(new Player("Kirat Boli"),new Player("NS Nodhi"));
    battingTeam.add(new Player("ketya"));
    Match match = Match.create(battingTeam, 4);
    match.start();
  }
}