package com.StockManager;

import org.jetbrains.annotations.NotNull;

import static java.lang.Math.abs;

public abstract class Stock {
    protected String itemName, itemDescription, itemID, itemSize;
    protected int itemQuantity = 0;
    protected double itemPrice;

    protected Stock() {
        this.itemName = "";
    }

    protected Stock(String name, double price, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("admin")) {
            this.itemName = name;
            this.itemPrice = price;
        }
    }

    protected Stock(String name, String description, String id, String size, double price, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("admin")) {
            this.itemName = name;
            this.itemDescription = description;
            this.itemID = id;
            this.itemSize = size;
            this.itemPrice = price;
        }
        else {
            System.out.println("You do not have admin privileges.");
        }
    }

    //Setters are edited to allow only admins to edit them
    protected String getItemName() {
        return itemName;
    }

    protected void setItemName(String itemName, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("admin"))
            this.itemName = itemName;
        else
            System.out.println("You do not have admin privileges.");
    }

    protected String getItemDescription() {
        return itemDescription;
    }

    protected void setItemDescription(String itemDescription, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("admin"))
            this.itemDescription = itemDescription;
        else
            System.out.println("You do not have admin privileges.");
    }

    protected String getItemID() {
        return itemID;
    }

    protected void setItemID(String itemID, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("admin"))
            this.itemID = itemID;
        else
            System.out.println("You do not have admin privileges.");
    }

    protected String getItemSize() {
        return itemSize;
    }

    protected void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    protected double getItemPrice() {
        return itemPrice;
    }

    protected void setItemPrice(double itemPrice, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("admin"))
            this.itemPrice = itemPrice;
        else
            System.out.println("You do not have admin privileges.");
    }

    //Basically the constructor all over again
    protected void editItemInformation(String name, String description, String id, String size, double price, @NotNull User user) {
        if(user.getUserType().equalsIgnoreCase("admin")) {
            this.itemName = name;
            this.itemDescription = description;
            this.itemID = id;
            this.itemSize = size;
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
