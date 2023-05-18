package com.ConsoleProject.Restaurant;


import java.util.Map;
import java.util.HashMap;

public class Order {
 Map<String, Integer> foodItem;
 Order(){
 foodItem = new HashMap();
 }

    public void setFoodItem(String foodKey, Integer foodValue){
        this.foodItem.put(foodKey,foodValue);
    }
    public Map<String, Integer> getFoodItem() {
        return foodItem;
    }
}
