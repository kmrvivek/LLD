package com.company.model;

import lombok.Data;

@Data
public class User {
  private String name;
  private String mobileNumber;
  private Address address;
}
