package com.StockManager;

import org.jetbrains.annotations.NotNull;

public class Beer extends Stock {
    private final String itemCategory = "Beer";
    private String itemSize;

    public Beer() {
    }

    public Beer(String name, double price, @NotNull User user) {
        super(name, price, user);
    }

    public Beer(String name, String description, String id, double price, @NotNull User user, String itemSize) {
        super(name, description, id, price, user);
        this.itemSize = itemSize;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    @Override
    public String toString() {
        String s;

        if (this.itemName != null && this.itemID != null && this.itemPrice != 0.0) {
            s = String.format("Name: %s%n" +
                            "ID: %s%n" +
                            "Description: %s%n" +
                            "Category: %s%n" +
                            "Quantity: %d%n" +
                            "Price: $%.2f%n%n"
                    , this.itemName, this.itemID, this.itemDescription, this.itemCategory, this.itemQuantity, this.itemPrice);
        }
        else
            s = "Empty item!";
        
        return s;
    }
}
