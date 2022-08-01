package com.company.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Food extends Rating {
  private String foodName;
  private double price;
  private int quantity;
  private double avgRating;

  public Food(String foodName, double price, int quantity) {
    this.foodName = foodName;
    this.price = price;
    this.quantity = quantity;
  }

}
