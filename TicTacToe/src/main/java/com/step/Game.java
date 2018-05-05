package com.step;

import java.util.HashSet;

public class Game {
  private final Player firstPlayer;
  private final Player secondPlayer;
  private Posotions availablePostions;
  private Positions winningCombinations;

  public Game(Player firstPlayer , Player secondPlayer) {
    this.firstPlayer = firstPlayer;
    this.secondPlayer = secondPlayer;
  }
  public static Game start(String firstPlayerName, String secondPlayerName){
    Player firstPlayer = new Player(firstPlayerName);
    Player secondPlayer = new Player(secondPlayerName);
    return new Game(firstPlayer,secondPlayer);
  }
}
