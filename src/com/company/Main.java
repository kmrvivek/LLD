package com.company;

import com.company.model.Food;
import com.company.model.Restaurant;
import com.company.service.IRestaurantRegisterService;
import com.company.service.RestaurantRegistryService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static IRestaurantRegisterService restaurantRegisterService = new RestaurantRegistryService();
    private  static RestaurantUtility restaurantUtility = new RestaurantUtility();
    static  Map<String, List<Restaurant>> allRestaurants = new HashMap<>();
    public static void main(String[] args) throws IOException {
        List<Restaurant> restaurants = new ArrayList<>();
       // BufferedReader br = new BufferedReader(new FileReader("D:/My_Code/Interview/input.txt"));
        String[] inputs = {"Register_restaurant,Food Court-1,BTM/HSR,NI Thali,100,5",
            "Show_restaurant,BTM",
            "Show_restaurant,HSR",
            "Register_restaurant,Food Court-2,BTM,Burger,120,3",
            "Show_restaurant,BTM"};

        for(String input:  inputs){
            String[] command = input.split(",");
           followCommand(command, command[0]);
            System.out.println("*********************");
        }

    }

    static void followCommand(String[] command, String input){
        switch (input){
            case "Register_restaurant" :
                String name = command[1];
                String pinCodeList = command[2];
                String[] pinCodes = pinCodeList.split("/");
                String item = command[3];
                double price = Double.parseDouble(command[4]);
                int quantity = Integer.parseInt(command[5]);
                Food food = new Food(item, price, quantity);
                Restaurant restaurant = restaurantRegisterService.addRestaurant(name, Arrays.asList(pinCodes),
                    food);
                for(String pinCode : pinCodes ){
                    if(allRestaurants.containsKey(pinCode)){
                        allRestaurants.get(pinCode).add(restaurant);
                    } else {
                        List<Restaurant> restaurantsList = new ArrayList<>();
                        restaurantsList.add(restaurant);
                        allRestaurants.put(pinCode, restaurantsList);
                    }
                }


                break;
            case "Show_restaurant" :
                restaurantUtility.showRestaurant(allRestaurants.get(command[1]));
                break;
        }
    }
}


