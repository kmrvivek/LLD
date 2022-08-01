package com.company.Ludo.model;

import lombok.Getter;

@Getter
public abstract class Blocker {

  final int firstPos;
  final int lastPos;
  final BlockerType type;

  public Blocker(int firstPos, int lastPos, BlockerType type){
    this.firstPos = firstPos;
    this.lastPos = lastPos;
    this.type = type;
  }

  @Override
  public String toString() {
    return "Blocker " + type+
        " firstPos=" + firstPos +
        ", lastPos=" + lastPos;
  }
}
