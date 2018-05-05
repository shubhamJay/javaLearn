package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

//ensures that chances of not occurrences of event are complementary to probability.
public class ProbabilityTest {
  @Test
  public void shouldGiveHalfForChancesOfNotOccurrenceWhenChancesOfOccurrenceIsGivenAsHalf () {
    assertThat(new Probability(0.5).not(),is(new Probability(0.5)));
  }

  @Test
  public void shouldGiveChancesOfNotOccurrenceWhenChancesOfOccurrenceIsGiven() {
    assertThat(new Probability(0.2).not(),is(new Probability(0.8)));
  }

  @Test
  public void shouldGiveTrueForComparingSameObject() {
    Probability probability = new Probability(0.2);
    assertTrue(probability.equals(probability));
  }

  @Test
  public void shouldGiveTrueForComparingTwoEqualObjects() {
    Probability firstProb = new Probability(0.2);
    Probability secondProb = new Probability(0.2);
    assertTrue(firstProb.equals(secondProb));
    assertTrue(secondProb.equals(firstProb));
  }

  @Test
  public void shouldGiveTrueForFirstEqualsToThirdWhenFirstIsSecondAndSecondIsEqualToThird() {
    Probability firstProb = new Probability(0.4);
    Probability secondProb= new Probability(0.4);
    Probability thirdProb = new Probability(0.4);
    assertTrue(firstProb.equals(secondProb));
    assertTrue(secondProb.equals(thirdProb));
    assertTrue(thirdProb.equals(firstProb));
  }

  @Test
  public void shouldGiveFalseForCheckingEquqlsWithNull() {
    Probability probability = new Probability(0.2);
    assertFalse(probability.equals(null));
  }

  @Test
  public void shouldGiveFalseIsObjectsAreInstanceOfDifferentClass() {
    Probability probability = new Probability(0.2);
    Object obj = new Object();
    assertFalse(probability.equals(obj));
  }

  @Test
  public void shouldGiveTrue() {
    Probability probability = new Probability(0.8).not();
    assertEquals(probability,new Probability(0.2));
  }
// todo : failing tests are remaining.

  @Test
  public void shouldGiveChancesOfGettingTailsOnTwoCoins() {
    assertThat(new Probability(0.5).and(new Probability(0.5)),is(new Probability(0.25)));
  }

  @Test
  public void shouldGiveChancesOfGettingTailOnCoinAnd5OnADice() {
    assertThat(new Probability(0.5).and(new Probability(0.167)),is(new Probability(0.0835)));
  }

  @Test
  public void shouldGiveChancesOfGettingTailOnACoinAnd5OnADiceAndRedCardFromDeck() {
    Probability coin = new Probability(0.5);
    Probability dice = new Probability(0.167);
    Probability deck = new Probability(0.25);
    assertThat(coin.and(dice).and(deck),is(new Probability(0.020875)));
  }

  @Test
  public void shouldGiveProbabilityOfGettingAtLeastTailOnCoin() {
    assertThat(new Probability(0.5)
            .or(new Probability(0.5))
            ,is(new Probability(0.75)));
  }

  @Test
  public void shouldCheckProbabilityOfGettingAtLeast6OnDice() {
    assertThat(new Probability(0.1667)
            .or(new Probability(0.1667)),
            is(new Probability(0.3056)));
  }
}
