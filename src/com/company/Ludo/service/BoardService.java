package com.company.Ludo.service;

import com.company.Ludo.model.Place;
import com.company.Ludo.model.Player;


public class BoardService {
 private LadderSnakeStrategy ladderSnakeStrategy;
  public void setBlockerPosition(Player player, Place place) {
    try {
      setPlayerPosition(player, place);
    } finally {
      ladderSnakeStrategy = null;
    }

  }

  private void setPlayerPosition(Player player, Place place) {

    switch (place.getBlocker().getType()){
      case SNAKE:
        ladderSnakeStrategy = new SnakeStrategyPos();
        ladderSnakeStrategy.setLadderSnakePlayerPos(player, place);
        break;

      case LADDER:
        ladderSnakeStrategy = new LadderStrategyPos();
        ladderSnakeStrategy.setLadderSnakePlayerPos(player, place);
        break;

      default:
        break;
    }
  }
}
