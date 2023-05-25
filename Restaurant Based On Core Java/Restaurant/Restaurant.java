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


    private static Customer selection_of_order(Customer customer, Map<String,Integer> listOfFood){
        System.out.print("\n     !!    Press number according to the assignment and \"0\" for exit    !!    \n -->");

        int enter = scanner.nextInt();
        Set<String> keySet = listOfFood.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);

        if (enter >= 1) {
            String keyValue = (enter <= 8 ? keyArray[enter-1] : keyArray[7]);
            customer.setOrder(keyValue,listOfFood.get(keyValue));
            customer.setBill(customer.getBill() + listOfFood.get(keyValue));
            customer = selection_of_order(customer, listOfFood);
        }
        else if (enter <= 0) {
            System.out.print("-> Exit from taking orders\n" +
                    "      ----       Enter your choice according to the options:         ----" +
                    "\n" +
                    "1. Menu." +
                    "\n" +
                    "2. Details and total bill." +
                    "\n" +
                    "-->");

            int option = scanner.nextInt();
            if (option == 1) {
               customer = displayFood(customer);
            }
            else if (option >= 2 || option < 1) {
                System.out.println("== Safely Exit From Orders ==");
            }


        }

        return customer;
     }


    private static void AdminLogin(){
         System.out.println("Enter Password");
         switch (scanner.next()){
             default:
                 System.out.println("          *****    Wrong Password     *****");
                 AdminLogin();
             case "abc123":

                 screenForAdmin();
         }
     }
    
   private static void screenForAdmin(){
         Admin admin = new Admin("Admin","male");
         System.out.println("\033[0;1m" +
                 "\'Press According To The Relevance Position:\'" +
                 "\n" + "1. About customers" +
                 " \n2. Total earning" +
                 "\n" + "3. Sale units");
         System.out.print("-->");

         int input = scanner.nextInt();

         if (input == 1)
             cus_Details(input, admin);

         else if (input == 2) {
             totalEarning();
         }

         else if (input == 3) {
             unitSale();
         }

         else screenForAdmin();


     }
  
  private static void cus_Details(int input, Admin admin){

         System.out.println("\033[0;1m" +
                 "\'Information of:\'" +
                 "\n" + "1. All customer's name" +
                 " \n2. Each customer's bill" +
                 "\n" + "3. Complete details");
         System.out.print("-->");
         input = scanner.nextInt();
         if (input == 1) {
             int index = 0;
             for (Customer cus: customers) {
                 System.out.println((++index) + ". " + cus.getName());
             }
         }
         else if (input == 2) {
             System.out.print("Name:                    Bill:\n");

             for (Customer cus: customers) {
                 System.out.print("\033[0;1m" + cus.getName());

                 for (int i = 0; i < (25-cus.getName().length()); i++) {
                     System.out.print(" ");
                 }
                 System.out.println(cus.getBill()+" Rs.");
             }
         }
         else if (input == 3) {
             System.out.print("Name:                    Bill:                          Items:                      Price:\n");

             for (Customer cus: customers) {
                 System.out.print("\033[0;1m" + cus.getName());

                 for (int i = 0; i < (25-cus.getName().length()); i++) {
                     System.out.print(" ");
                 }
                 System.out.print(cus.getBill()+" Rs.");

                 int  j = 0;

                 for (Map.Entry map : cus.getOrder().getFoodItem().entrySet()) {

                     if (j == 0) {
                         for ( int i = 0; i < (23) ; i++) {

                             System.out.print(" ");
                         }
                     }
                     if (j != 0) {
                         for (int i = 0; i < (56); i++) {

                             System.out.print(" ");
                         }
                     }
                         System.out.print(map.getKey());

                         for (int i = 0; i < (28 - map.getKey().toString().length()); i++) {
                             System.out.print(" ");
                         }
                         System.out.println(map.getValue() + " Rs.");
                     j++;

                     }

                 System.out.println("---------------------------------------------------------------------------------------------------");
             }
         }


     }





}
