package com.company.service;

import com.company.model.Food;
import com.company.model.Restaurant;
import com.company.model.User;

public interface IUserService {
  public void giveFoodRating(User user, int rating, Food food);
  public void giveRestaurantRating(User user, int rating, Restaurant restaurant);
}
