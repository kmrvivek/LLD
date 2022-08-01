package com.company.Elevator.model;

import lombok.Data;

@Data
public class UserInput {
    private UserPosition userPosition;
    private Integer floorPressed;
    private Direction direction;

    public UserInput(){}

    public UserInput(UserPosition userPosition, Integer floorPressed) {
      this.userPosition = userPosition;
      this.floorPressed = floorPressed;
    }

}
