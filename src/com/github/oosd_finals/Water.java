package com.github.oosd_finals;

import org.jetbrains.annotations.NotNull;

public class Water extends Stock {
    private final String ITEM_CATEGORY = "Water";

    public Water() {
        this.itemName = "null";
    }

    public Water(String name, double price, @NotNull User user) {
        super(name, price, user);
    }

    public Water(String name, String description, String id, double price, @NotNull User user) {
        super(name, description, id, price, user);
    }

    public String getITEM_CATEGORY() {
        return ITEM_CATEGORY;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%n" +
                        "ID: %s%n" +
                        "Description: %s%n" +
                        "Category: %s%n" +
                        "Quantity: %dl/ml%n" +
                        "Price: $%.2f%n%n"
                , this.itemName, this.itemID, this.itemDescription, this.ITEM_CATEGORY, this.itemQuantity, this.itemPrice);
    }
}
