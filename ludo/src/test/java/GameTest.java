import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

  private Game ludo;

  @Before
  public void setUp() throws Exception {
    ludo = new Game("ludo",4);
  }

  @Test
  public void shouldAddPlayerToGame() {
    assertTrue(ludo.addPlayer("alex"));
  }

  @Test
  public void shouldGiveFalseWhenGamedoNotHaveEnoughPlayersToPlay() {
    assertFalse(ludo.hasEnoughPlayers());
  }

  @Test
  public void shouldAddPlayerToGameWhenEnoughPlayersAreNotThereInGame() {
    assertTrue(ludo.addPlayer("alex"));
    assertTrue(ludo.addPlayer("ram"));
    assertTrue(ludo.addPlayer("shyam"));
    assertTrue(ludo.addPlayer("john"));
  }

  @Test
  public void shouldNotAddPlayerToGameWhenEnoughPlayersAreThereInGame() {
    ludo.addPlayer("alex");
    ludo.addPlayer("ram");
    ludo.addPlayer("shyam");
    ludo.addPlayer("john");
    assertFalse(ludo.addPlayer("Pandu"));
  }

  @Test
  public void shouldGiveTrueWhenGameHasEnoughPlayresToPlay() {
    ludo.addPlayer("alex");
    ludo.addPlayer("john");
    ludo.addPlayer("ram");
    ludo.addPlayer("shyam");
    assertTrue(ludo.hasEnoughPlayers());
  }

//  @Test
//  public void shouldStartToPlayIfThereAreFourPlayersJoin() {
//    ludo.addPlayer("alex");
//    ludo.addPlayer("john");
//    ludo.addPlayer("ram");
//    ludo.addPlayer("shyam");
//    assertTrue(ludo.isStarted());
//  }
}