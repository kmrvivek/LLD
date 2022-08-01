package com.company.Elevator.service;

import lombok.Data;

@Data
public class InternalRequest {
  private int destinationFloor;

  public InternalRequest(int destinationFloor){
    this.destinationFloor = destinationFloor;
  }

}
