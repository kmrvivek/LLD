package com.company.service;

import com.company.model.Food;
import com.company.model.Restaurant;
import java.util.List;

public interface IRestaurantRegisterService {

  public Restaurant addRestaurant(String name, List<String> pinCodes, Food food);

  public void updateFoodQuantity(Restaurant restaurant, String name, int quantity);

}
