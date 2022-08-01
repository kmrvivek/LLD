package com.company.Ludo.model;

public class Snake extends Blocker {

  public Snake(int head, int tail){
    super(head, tail, BlockerType.SNAKE);
  }

  @Override
  public String toString() {
    return "Snake " +
        "head =" + firstPos +
        ", tail =" + lastPos;
  }
}
