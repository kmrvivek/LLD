package com.company.service;

import com.company.model.Food;
import com.company.model.Restaurant;

public class RatingUtilityFunction<E> implements IRatingUtilityFunction<E>{

  @Override
  public void calculateAvgRating(E rateType){
    if(rateType instanceof Food){
      Food food = (Food) rateType;
      food.setAvgRating(Math.round((double)(food.getTotalRating()/food.getTotalUser()) * 100/ 100.00));
    } else if(rateType instanceof Restaurant){
      Restaurant restaurant = (Restaurant) rateType;
      restaurant.setAvgRating(Math.round((double)(restaurant.getTotalRating()/restaurant.getTotalUser()) * 100/ 100.00));
    }
  }
}
