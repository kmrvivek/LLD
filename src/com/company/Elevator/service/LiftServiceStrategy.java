package com.company.Elevator.service;

import com.company.Elevator.model.Lift;
import com.company.Elevator.model.UserInput;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public abstract class LiftServiceStrategy {
  protected Queue<Integer> insideQueue;
  protected Set<Integer> inputQueue;
  public LiftServiceStrategy(){
    this.insideQueue = new LinkedList<>();
    this.inputQueue = Collections.synchronizedSet(new HashSet<>());
  }

  public abstract void pressLiftFloor(Lift lift, UserInput userInput);

}
