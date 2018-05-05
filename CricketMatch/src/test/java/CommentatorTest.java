import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommentatorTest {

  @Test
  public void getPlayerShouldIncludeNameOfGivenPlayersNameInData() {
    Player mockedPlayer = mock(Player.class);
    Commentator commentator = new Commentator();
    commentator.showScore(2,1,mockedPlayer);
    verify(mockedPlayer).accept(commentator);
  }
}