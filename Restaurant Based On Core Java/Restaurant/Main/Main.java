package com.ConsoleProject.Restaurant;


public class Main {
    public static void main(String[] args) {

       long time1 = System.nanoTime();

        Restaurant.start();

        long time2 = System.nanoTime();

        System.out.println(" Time Taken: "+ (time2-time1) + "");

    }
}
