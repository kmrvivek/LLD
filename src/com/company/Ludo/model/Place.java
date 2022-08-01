package com.company.Ludo.model;

import lombok.Data;

@Data
public class Place {

  final int number;
  private boolean isBlocked;
  private Blocker blocker;

  public Place(int number){
    this.number = number;
  }

}
