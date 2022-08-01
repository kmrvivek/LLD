package com.company.service;

@FunctionalInterface
public interface IRatingUtilityFunction<E> {

  public void calculateAvgRating(E ratType);

}
