package com.company.Ludo.model;

import lombok.Data;

@Data
public class Player {
  private int pos;
  private final String name;
  private boolean isWinner;

  public Player(String name){
    this.name = name;
    this.pos = 1;
  }

  @Override
  public String toString() {
    return "Player " +name;
  }
}
