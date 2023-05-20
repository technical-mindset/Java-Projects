package com.ConsoleProject.Restaurant;


public class Customer extends User{
    private int bill;
    Customer(String name, String gender){
        super(name, gender);
        this.bill = 0;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public int getBill() {
        return bill;
    }
}

