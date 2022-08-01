package com.company.Elevator.service;

import com.company.Elevator.model.Direction;
import com.company.Elevator.model.Lift;
import com.company.Elevator.model.UserInput;
import java.util.Queue;

public class OutsideLiftStrategy extends LiftServiceStrategy {

  public OutsideLiftStrategy(Queue<Integer> queue) {
    super();
  }

  @Override
  public void pressLiftFloor(Lift lift, UserInput userInput) {
    if(lift.getDirection().equals(Direction.UP) &&
        userInput.getFloorPressed() > lift.getCurrFloor()
        && !inputQueue.contains(userInput.getFloorPressed())){
      inputQueue.add(userInput.getFloorPressed());
    } else if(lift.getDirection().equals(Direction.DOWN) &&
        userInput.getFloorPressed() < lift.getCurrFloor()
        && !inputQueue.contains(userInput.getFloorPressed())){
      inputQueue.add(userInput.getFloorPressed());
    } else {

    }
  }
}
