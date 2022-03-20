package com.github.oosd_finals;

import org.jetbrains.annotations.NotNull;

public class Spirit extends Stock {
    private final String ITEM_CATEGORY = "Spirit";

    public Spirit() {
        this.setItemName();
    }

    public Spirit(String name, double price, @NotNull User user) {
        super(name, price, user);
    }

    public Spirit(String name, String id, double price, @NotNull User user) {
        super(name, id, price, user);
    }

    public String getITEM_CATEGORY() {
        return ITEM_CATEGORY;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%n" +
                        "ID: %s%n" +
                        "Category: %s%n" +
                        "Quantity: %d%n" +
                        "Price: $%.2f"
                , this.getItemName(), this.getItemID(), this.ITEM_CATEGORY, this.getItemQuantity(), this.getItemPrice());
    }
}