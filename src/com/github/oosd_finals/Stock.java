package com.github.oosd_finals;

import static java.lang.Math.abs;

public abstract class Stock {
    private String itemName, itemID;
    private int itemQuantity = 0;
    private double itemPrice;

    protected Stock() {
    }

    protected Stock(String name, double price) {
        if(User.getUserType().equalsIgnoreCase("a")) {
            this.itemName = name;
            this.itemPrice = price;
        }
    }

    protected Stock(String name, String id, double price) {
        if(User.getUserType().equalsIgnoreCase("a")) {
            this.itemName = name;
            this.itemID = id;
            this.itemPrice = price;
        }
    }

    //Setters are edited to allow only admins to edit them
    protected String getItemName() {
        return itemName;
    }

    protected void setItemName() {
        this.itemName = "";
    }

    protected String getItemID() {
        return itemID;
    }

    protected void setItemID(String itemID) {
        if(User.getUserType().equalsIgnoreCase("a"))
            this.itemID = itemID;
        else
            System.out.println("You do not have admin privileges.");
    }

    protected double getItemPrice() {
        return itemPrice;
    }

    protected void setItemPrice(double itemPrice) {
        if(User.getUserType().equalsIgnoreCase("a"))
            this.itemPrice = itemPrice;
        else
            System.out.println("You do not have admin privileges.");
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    //Add to amount of item owned
    protected void addToStock(int num) {
        this.itemQuantity += num;
    }

    //Remove from amount of item owned
    protected void removeFromStock(int num) {
        if(this.itemQuantity <= 0) {
            System.out.println("No more " + this.itemName + " to take from.");
        }
        else if (this.itemQuantity - num < 0) {
            System.out.println("Removing " +  abs(num) + " extra " + this.itemName + " from inventory.");
        }
        else {
            this.itemQuantity -= num;
        }
    }
}
