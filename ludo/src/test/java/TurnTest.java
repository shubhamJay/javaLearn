import org.junit.Test;

import static org.mockito.Mockito.*;

public class TurnTest {
  Dice mockedDice = mock(Dice.class);

  @Test
  public void shouldRollGivenDice() {
    Turn turn = new Turn(mockedDice);
    turn.rollDice(mockedDice);
    verify(mockedDice).roll();
    when(turn.rollDice(mockedDice)).thenReturn(2);
  }
}