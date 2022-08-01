package com.company;

import com.company.model.Food;
import com.company.model.Rating;
import com.company.model.Restaurant;
import java.util.List;

public class RestaurantUtility {

  public void showRestaurant(List<Restaurant> areaRestaurants){
    areaRestaurants.forEach(restaurant -> System.out.println(restaurant));
  }

}
