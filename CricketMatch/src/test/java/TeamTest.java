import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TeamTest {

  private Team players;
  private Player firstPlayer;
  private Player secondPlayer;

  @Before
  public void setUp() {
    firstPlayer = new Player("Kirat Boli");
    secondPlayer = new Player("NS Nodhi");
    players = Team.create(firstPlayer, secondPlayer);
    players.add(firstPlayer);
    players.add(secondPlayer);
  }

  @Test
  public void shouldGiveFirstPlayerToPLay() {
    assertThat(players.getPlayerToPlay(),is(firstPlayer));
  }

  @Test
  public void shouldGiveNextPlayerToPlayer() {
    players.getPlayerToPlay();
    assertThat(players.getPlayerToPlay(),is(secondPlayer));
  }
}