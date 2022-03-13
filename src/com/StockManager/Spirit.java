package com.StockManager;

import org.jetbrains.annotations.NotNull;

public class Spirit extends Stock {
    private final String ITEM_CATEGORY = "Spirit";

    public Spirit() {
    }

    public Spirit(String name, double price, @NotNull User user) {
        super(name, price, user);
    }

    public Spirit(String name, String description, String id, String size, double price, @NotNull User user) {
        super(name, description, id, size, price, user);
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
                        "Quantity: %d%n" +
                        "Price: $%.2f%n%n"
                , this.itemName, this.itemID, this.itemDescription, this.ITEM_CATEGORY, this.itemQuantity, this.itemPrice);
    }
}