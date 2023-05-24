package com.ConsoleProject.Restaurant;

import java.util.*;

public class Restaurant {
   static FoodItem fi = new FoodItem();
   private static Integer totalSale = 0;
   private static Scanner scanner = new Scanner(System.in);
   static List<Customer> customers = new ArrayList<>();

     public static void start(){
         System.out.println("\'Enter as\'" +
                 "\n" + "1. Admin" +
                 " \n2. Customer" +
                 "\n" + "3. Exit");
         System.out.print("-->");
         int in = scanner.nextInt();

         if (in == 1) {
             AdminLogin();
         }
         else if (in == 2) {
             addCustomer();
         }
         else if (in == 3) {
             System.exit(0);
         }
         else {
             System.out.println("_____________Wrong input__________");
             Restaurant.start();
         }


         }



}
