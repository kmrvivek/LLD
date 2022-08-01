package com.company.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Restaurant extends Rating {

  private String restaurantName;
  private List<String> pinCodes = new ArrayList<>();
  private Map<String, Food> foods = new HashMap<>();
  private String owner;
  private double avgRating;

  public Restaurant(String name, List<String> pinCodes) {
    this.restaurantName = name;
    this.pinCodes = pinCodes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Restaurant that = (Restaurant) o;
    return Objects.equals(restaurantName, that.restaurantName) && Objects.equals(
        pinCodes, that.pinCodes) && Objects.equals(owner, that.owner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(restaurantName, pinCodes, owner);
  }

}
