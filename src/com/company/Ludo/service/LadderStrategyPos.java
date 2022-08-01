package com.company.Ludo.service;

import com.company.Ludo.model.Place;
import com.company.Ludo.model.Player;

public class LadderStrategyPos implements LadderSnakeStrategy {

  @Override
  public void setLadderSnakePlayerPos(Player player, Place place) {
    if(place.isBlocked()){
      player.setPos(place.getBlocker().getFirstPos());
      System.out.println("Player "+player.getName()+" climbed the ladder, climb to position "+
          place.getBlocker().getFirstPos());
    }
  }

}
