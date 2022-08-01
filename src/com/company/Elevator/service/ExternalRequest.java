package com.company.Elevator.service;

import com.company.Elevator.model.Direction;
import lombok.Data;

@Data
public class ExternalRequest {
  private Direction directionToGo;
  private int sourceFloor;

  public ExternalRequest(Direction directionToGo, int sourceFloor){
    this.directionToGo = directionToGo;
    this.sourceFloor = sourceFloor;
  }
}
