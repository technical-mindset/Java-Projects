package com.ConsoleProject.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class User {
    private String name;
    private String gender;
    private Order order;
    private static FoodItem foodItem;
    User(String name, String gender){
        this.name = name;
        this.gender = gender;
        foodItem = new FoodItem();
        order = new Order();
    }
    public String getGender() {
        return gender;
    }
    public Order getOrder() {
        return order;
    }
    public String getName() {
        return name;
    }
    public void setOrder(String foodKey, Integer foodValue){
        this.order.setFoodItem(foodKey,foodValue);
    }

    public void getFastFood() {
        System.out.println(" ~ ~ ~ ~ ~ Fast Food  ~ ~ ~ ~ ~ ");
        this.getFoodItems(foodItem.getFastFood());

        //        foodItem.getFastFood().forEach((food, price) -> System.out.println("Food Items: "+food+ " , Price: " +price+ " Rs."));
    }
    public void getDesiFood() {
        System.out.println(" ~ ~ ~ ~ ~ Desi Food  ~ ~ ~ ~ ~ ");
        this.getFoodItems(foodItem.getDesiFood());
//        foodItem.getDesiFood().forEach((food, price) -> System.out.println("Food Items: "+food+ " , Price: " +price+ " Rs."));
    }
    private void getFoodItems(Map<String, Integer> fooditem) {
        int i = 0;
        for (Map.Entry mapFood : fooditem.entrySet()){
            System.out.println("Item "+ (++i) +". : "+mapFood.getKey()+ " , Price: " +mapFood.getValue()+ " Rs.");
        }
    }

}

class Admin extends User{

    Admin(String name, String gender) {
        super(name, gender);
    }
}
