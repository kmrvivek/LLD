package com.company.Elevator.service;

import com.company.Elevator.model.Direction;
import com.company.Elevator.model.Lift;
import com.company.Elevator.model.UserInput;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;
import lombok.Data;


public class InsideLiftStrategy extends LiftServiceStrategy {


  public InsideLiftStrategy() {
    super();
  }

  @Override
  public void pressLiftFloor(Lift lift, UserInput userInput) {
    Direction direction = lift.getDirection();
    int currFloor = lift.getCurrFloor();
    if(Objects.nonNull(userInput.getFloorPressed())){
      if(direction.equals(Direction.DOWN) && userInput.getFloorPressed() < currFloor){
        inputQueue.add(userInput.getFloorPressed());
      } else if(direction.equals(Direction.UP) && userInput.getFloorPressed() > currFloor){
        inputQueue.add(userInput.getFloorPressed());
      } else {
        if(currFloor - userInput.getFloorPressed() != 0){
          Direction liftNewDirection = currFloor > userInput.getFloorPressed() ?
              Direction.DOWN : Direction.UP;
          lift.setDirection(liftNewDirection);
          inputQueue.add(userInput.getFloorPressed());
        }
      }
    }

     if(lift.getDirection().equals(Direction.DOWN)){
        insideQueue.addAll(inputQueue.stream().sorted(Collections.reverseOrder())
            .collect(Collectors.toList()));
     } else {
       insideQueue.addAll(inputQueue.stream().sorted().collect(Collectors.toList()));
     }
  }
}
