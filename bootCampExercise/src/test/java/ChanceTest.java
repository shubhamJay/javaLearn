import com.thoughtworks.step.bootcamp.Chance;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


//ensures correctness of chance
public class ChanceTest {
  @Test
  public void shouldCheckNot() {
    Chance chance = new Chance(0.8);
    assertTrue(chance.not().equals(new Chance(0.2)));
  }

  @Test
  public void checkEquals() {
    Chance chance = new Chance(0.8);
    assertTrue(chance.equals(chance));
  }

  @Test
  public void checkNotEquals() {
    Chance chance = new Chance(0.8);
    assertFalse(chance.equals(new Object()));
  }

  @Test
  public void checkTwoEquals() {
    Chance chance1 = new Chance(0.8);
    Chance chance2 = new Chance(0.8);
    assertTrue(chance1.equals(chance2));
    assertTrue(chance2.equals(chance1));
  }

  @Test
  public void checkThreeEquals() {
    Chance chance1 = new Chance(0.8);
    Chance chance2 = new Chance(0.8);
    Chance chance3 = new Chance(0.8);
    assertTrue(chance1.equals(chance2));
    assertTrue(chance2.equals(chance3));
    assertTrue(chance3.equals(chance1));
  }

  @Test
  public void checkNull() {
    Chance chance1 = new Chance(0.8);
    assertFalse(chance1.equals(null));
  }
  
  @Test
  public void shouldGiveProbabilityOfFlippingTwoCoins() {
    Chance chance = new Chance(0.5);
    assertThat(chance.and(new Chance(0.7)),is(new Chance(0.35)));
  }
  
  //tail on coin, 5 on dice, red on cards
  @Test
  public void shouldGiveProbability() {
    Chance tailOnCoin = new Chance(0.5);
    Chance fiveOnDice = new Chance((double)1/6);
    Chance redCard = new Chance(0.5);
    Chance expected = new Chance(0.04);
    assertThat(tailOnCoin.and(fiveOnDice).and(redCard),is(expected));
  }
  
  @Test
  public void shouldGiveProbabilityOfGettingOneTail() {
    Chance tailOnCoin = new Chance(0.5);
    Chance expected = new Chance(0.75);
    assertThat(tailOnCoin.or(new Chance(0.5)),is(expected));
  }
  
  @Test
  public void shouldGiveProbabilityOfGettingAtleastOneSix() {
    Chance ofSixOnOneDice = new Chance((double) 1/6);
  }
}
