package com.company.Ludo.service;

import com.company.Ludo.model.Place;
import com.company.Ludo.model.Player;

public class SnakeStrategyPos implements LadderSnakeStrategy {

  @Override
  public void setLadderSnakePlayerPos(Player player, Place place) {
    if(place.isBlocked()){
      player.setPos(place.getBlocker().getLastPos());
      System.out.println("Ouch !! Player "+player.getName()+" bitten by snake, go back to position "+
          place.getBlocker().getLastPos());
    }
  }

}
