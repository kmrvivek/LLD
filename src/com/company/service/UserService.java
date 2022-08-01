package com.company.service;

import com.company.model.Food;
import com.company.model.Restaurant;
import com.company.model.User;

public class UserService implements IUserService{

  private IRatingUtilityFunction ratingUtilityFunction = new RatingUtilityFunction();

  @Override
  public void giveFoodRating(User user, int rating, Food food){
      if(food.getUserRating().containsKey(user)) {
        food.setTotalRating(food.getTotalRating()+1);
      } else {
        food.setTotalRating(food.getTotalRating()+1);
        food.setTotalUser(food.getTotalUser()+1);
        food.getUserRating().put(user, rating);
      }
    ratingUtilityFunction.calculateAvgRating(food);
  }

  @Override
  public void giveRestaurantRating(User user, int rating, Restaurant restaurant){
    if(restaurant.getUserRating().containsKey(user)) {
      restaurant.setTotalRating(restaurant.getTotalRating()+1);
    } else {
      restaurant.setTotalRating(restaurant.getTotalRating()+1);
      restaurant.setTotalUser(restaurant.getTotalUser()+1);
      restaurant.getUserRating().put(user, rating);
    }
    ratingUtilityFunction.calculateAvgRating(restaurant);
  }
}
