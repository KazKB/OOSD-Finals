package com.StockManager;

import org.jetbrains.annotations.NotNull;

public class Beer extends Stock {
    private final String itemCategory = "Beer";


    public Beer() {
    }

    public Beer(String name, double price, @NotNull User user) {
        super(name, price, user);
    }

    public Beer(String name, String description, String id, String size, double price, @NotNull User user) {
        super(name, description, id, size, price, user);
    }

    public String getItemCategory() {
        return itemCategory;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%n" +
                        "ID: %s%n" +
                        "Description: %s%n" +
                        "Category: %s%n" +
                        "Quantity: %d%n" +
                        "Price: $%.2f%n%n"
                , this.itemName, this.itemID, this.itemDescription, this.itemCategory, this.itemQuantity, this.itemPrice);
    }
}
