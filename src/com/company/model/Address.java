package com.company.model;

import lombok.Data;

@Data
public class Address {
    private String houseNo;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private Integer pinCode;
}
