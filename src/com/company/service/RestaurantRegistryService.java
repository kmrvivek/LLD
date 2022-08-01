package com.company.service;

import com.company.model.Food;
import com.company.model.Restaurant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RestaurantRegistryService implements IRestaurantRegisterService {


  @Override
  public Restaurant addRestaurant(String name, List<String> pinCodes, Food food) {
    Restaurant restaurant = new Restaurant(name, pinCodes);
    if(restaurant.getFoods().containsKey(food.getFoodName())){
      Food updateFood = restaurant.getFoods().get(food.getFoodName());
      updateFood.setQuantity(food.getQuantity());
    } else {
      restaurant.getFoods().put(food.getFoodName(), food);
    }

    return  restaurant;
  }

  @Override
  public void updateFoodQuantity(Restaurant restaurant, String name, int quantity) {
      Food food = restaurant.getFoods().get(name);
      food.setQuantity(quantity);
  }




}
