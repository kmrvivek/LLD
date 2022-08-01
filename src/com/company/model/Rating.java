package com.company.model;

import java.util.Map;
import lombok.Data;

@Data
public class Rating<E> {
    private int totalUser;
    private int totalRating;
    private Map<User, Integer> userRating;
}
