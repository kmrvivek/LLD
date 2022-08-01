package com.company.Elevator.model;

import lombok.Data;

@Data
public class Lift {
  private final int floors;
  private final int base;
  private final int top;
  private final int maxCapacity;
  private Direction direction;
  private int currFloor;

  public Lift(int base, int top){
    this.base = base;
    this.top = top;
    this.floors = (top - base)+1;
    this.maxCapacity = 10;
  }



}
