package com.github.oosd_finals;

import org.jetbrains.annotations.NotNull;

import static java.lang.Math.abs;

public abstract class Stock {
    protected String itemName, itemDescription, itemID;
    protected int itemQuantity = 0;
    protected double itemPrice;

    protected Stock() {
    }

    protected Stock(String name, double price, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("a")) {
            this.itemName = name;
            this.itemPrice = price;
        }
    }

    protected Stock(String name, String description, String id, double price, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("a")) {
            this.itemName = name;
            this.itemDescription = description;
            this.itemID = id;
            this.itemPrice = price;
        }
    }

    //Setters are edited to allow only admins to edit them
    protected String getItemName() {
        return itemName;
    }

    protected void setItemName(String itemName, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("a"))
            this.itemName = itemName;
    }

    protected String getItemDescription() {
        return itemDescription;
    }

    protected void setItemDescription(String itemDescription, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("a"))
            this.itemDescription = itemDescription;
    }

    protected String getItemID() {
        return itemID;
    }

    protected void setItemID(String itemID, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("a"))
            this.itemID = itemID;
        else
            System.out.println("You do not have admin privileges.");
    }

    protected double getItemPrice() {
        return itemPrice;
    }

    protected void setItemPrice(double itemPrice, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("a"))
            this.itemPrice = itemPrice;
        else
            System.out.println("You do not have admin privileges.");
    }

    //Basically the constructor all over again
    protected void editItemInformation(String name, String description, String id, double price, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("a")) {
            this.itemName = name;
            this.itemDescription = description;
            this.itemID = id;
            this.itemPrice = price;
        }
        else {
            System.out.println("You do not have admin privileges.");
        }
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
