package com.ConsoleProject.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class FoodItem {
    static private Map<String, Integer> fastFood;
    static private Map<String, Integer> desiFood;
     FoodItem(){
         if (fastFood == null && desiFood == null) {
             // ------------ Fast Food ------------------ //
             fastFood = new HashMap<String, Integer>();
             //     Put keys and values
             fastFood.put("\"Zinger Burger\"", 360);
             fastFood.put("\"Zingerattha\"", 700);
             fastFood.put("\"Chicken Cheese Burger\"", 450);
             fastFood.put("\"Chicken Burger\"", 300);
             fastFood.put("\"Chatni Roll\"", 170);
             fastFood.put("\"Mayo Cheese Roll\"", 270);
             fastFood.put("\"Mayo Garlic Roll\"", 250);

             // ------------ Desi Food ------------------ //
             desiFood = new HashMap<String, Integer>();
             //     Put keys and values
             desiFood.put("\"Chicken Karhai\"", 1500);
             desiFood.put("\"Beef Boti\"", 550);
             desiFood.put("\"Chicken Tikka\"", 600);
             desiFood.put("\"Malai Boti\"", 300);
             desiFood.put("\"Paratha\"", 70);
             desiFood.put("\"Roti\"", 30);

         }
    }

    public Map<String, Integer> getFastFood() {
        return fastFood;
    }
    public Map<String, Integer> getDesiFood() {
        return desiFood;
    }
}
