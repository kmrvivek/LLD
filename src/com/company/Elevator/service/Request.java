package com.company.Elevator.service;

import lombok.Data;

@Data
public class Request implements Comparable<Request>{
  private InternalRequest internalRequest;
  private ExternalRequest externalRequest;

  public Request(InternalRequest internalRequest, ExternalRequest externalRequest){
    this.internalRequest = internalRequest;
    this.externalRequest = externalRequest;
  }

  @Override
  public int compareTo(Request req) {
    if(this.getInternalRequest().)
    return 0;
  }
}
