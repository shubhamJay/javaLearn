package com.step;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

  @Test
  public void addMoveShouldAddGivenMoveToPlayerMoves() {
    Player john = new Player("john");
    john.addMove(3);
    assertThat(john.getMoves(),hasItem(3));
  }
}