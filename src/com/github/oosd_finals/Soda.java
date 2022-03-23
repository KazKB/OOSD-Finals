package com.github.oosd_finals;

public class Soda extends Stock {
    private final String ITEM_CATEGORY = "Soda";

    public Soda() {
        this.setItemName();
    }

    public Soda(String name, double price) {
        super(name, price);
    }

    public Soda(String name, String id, double price) {
        super(name, id, price);
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
