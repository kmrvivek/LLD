package com.company.Elevator.model;

import com.company.Elevator.service.Request;
import java.util.TreeSet;

public class Elevator {
  private int currentFloor = 0;
  private Direction currentDirection = Direction.UP;
  private State currentState = State.IDLE;

  private TreeSet<Request> currentJobs = new TreeSet<>();
  private TreeSet<Request> upPendingJobs = new TreeSet<>();
  private TreeSet<Request> downPendingJobs = new TreeSet<>();

  public void startElevator(){
    while (true){
      if(checkIfJob()){
        if(currentDirection == Direction.UP){
          Request request = currentJobs.pollFirst();
          processUpRequest(request);
          if(currentJobs.isEmpty()){
            addPendingDownJobsToCurrentJobs();
          }
        } else if(currentDirection == Direction.DOWN){
          Request request = currentJobs.pollLast();
          processDownRequest(request);
          if(currentJobs.isEmpty()){
            addPendingUpJobsToCurrentJobs();
          }
        }
      }
    }
  }

  private void addPendingUpJobsToCurrentJobs() {

  }

  private void processDownRequest(Request request) {
  }

  private void addPendingDownJobsToCurrentJobs() {
  }

  private void processUpRequest(Request request) {
    // The elevator is not on the floor where the person has requested it i.e. source floor.
    // So first bring it there.
    int startFloor = currentFloor;
    if(startFloor < request.getExternalRequest().getSourceFloor()){
      for (int i = startFloor; i < request.getExternalRequest().getSourceFloor(); i++){
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("We have reached floor -- "+i);
        currentFloor = i;
      }
    }
    // The elevator is now on the floor where the person has requested it i.e. source floor.
    // User can enter and go to the destination floor.
    System.out.println("Reached Source Floor--opening door");
    startFloor = currentFloor;
    for (int i = startFloor; i <= request.getInternalRequest().getDestinationFloor(); i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("We have reached floor -- " + i);
      currentFloor = i;
      if (checkIfNewJobCanBeProcessed(request)) {
        break;
      }
    }
  }

  private boolean checkIfJob() {
    return currentJobs.isEmpty();
  }

  
}
