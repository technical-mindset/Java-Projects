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

 private static void addCustomer(){
        Customer customer;
        System.out.println("  ---- Enter Name: ------");
        String name = scanner.next();

        System.out.println("  ---- Enter Gender: ------");
        String gender = scanner.next();

        customer = new Customer(name,gender);
        customers.add(displayFood(customer));
         totalBill(customer);


    }
    private static Customer displayFood(Customer customer){
        System.out.println("Please enter '1' for \"Fast Food\" or '2' for \"Desi Food\"");
        System.out.print("--> ");
        // for number on food list
        int index = 0;
        int input = scanner.nextInt();

        if (input == 1) {
            System.out.println("   ^^^^^^^   Fast Food   ^^^^^^   ");

           for (Map.Entry foodItem: fi.getFastFood().entrySet()) {
                System.out.print((++index) +". Food Items: "+foodItem.getKey()+ " , Price: " +foodItem.getValue()+ " Rs.");

                    //total spaces are 19
                    for (int i = 0; i < (19 - ((foodItem.getKey().toString().length() + foodItem.getValue().toString().length()) - 11)); i++) {
                        System.out.print(" ");

                    }
                if (index % 2 == 0) {
                    System.out.println();
                }
            }

                customer = selection_of_order(customer,fi.getFastFood());


        }
        else if (input == 2) {
            System.out.println("   ++++++   Desi Food   ++++++   ");
//            fi.getDesiFood().forEach((food, price) -> System.out.println("Food Items: "+food+ " , Price: " +price+ " Rs."));

           for (Map.Entry foodItem: fi.getDesiFood().entrySet()) {
                System.out.print((++index) +". Food Items: "+foodItem.getKey()+ " , Price: " +foodItem.getValue()+ " Rs.");

                    //total spaces are 19
                    for (int i = 0; i < (19 - ((foodItem.getKey().toString().length() + foodItem.getValue().toString().length()) - 11)); i++) {
                        System.out.print(" ");
                    }

                if (index % 2 == 0) {
                    System.out.println();
                }
            }
            customer = selection_of_order(customer,fi.getDesiFood());
        }
        else if (input >= 3 || input < 0) {
            System.out.println("\033[0;1m" +"Invalid Insertion!");
            customer = displayFood(customer);
        }

        //

        return (customer);
    }

}
