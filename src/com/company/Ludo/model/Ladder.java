package com.company.Ludo.model;

public class Ladder extends Blocker {

    public Ladder(int top, int base){
       super(top, base, BlockerType.LADDER);
    }

  @Override
  public String toString() {
    return "Ladder " +
        "top =" + firstPos +
        ", base =" + lastPos;
  }
}

