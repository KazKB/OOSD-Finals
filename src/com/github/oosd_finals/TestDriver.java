package com.github.oosd_finals;

public class TestDriver {
    public static void main(String[] args) {
        User user = new User("admin", "sd");
        Beer beer = new Beer("Beer", "Beer", "Beer", "1l", 10, user);
        Spirit spirit = new Spirit("Spirit", "Spirit", "Spirit", "Spirit", 15, user);

        user.addToStockList(beer);
        user.addToStockList(spirit);

        System.out.print(beer);
        System.out.print(spirit);

        Supplier supplier = new Supplier("Supplier", "e", "n", user);
        supplier.addPurchasableItem("Beer", "10", user);
        supplier.addPurchasableItem("Spirit", "15", user);
        supplier.createAndPrintInvoice("Beer", 5, user);
        supplier.createAndPrintInvoice("Spirit", 5, user);

        System.out.print(beer);
        System.out.print(spirit);

        Customer customer = new Customer("Customer", "e", "n", user);
        customer.createAndPrintSalesReceipt("Beer", 5, user);
        customer.createAndPrintSalesReceipt("Spirit", 5, user);

        System.out.print(beer);
        System.out.print(spirit);

        customer.printPurchasedItems();
        customer.removePurchasedItem("Beer", 5, user);
        customer.removePurchasedItem("Spirit", 5, user);

        System.out.print(beer);
        System.out.print(spirit);
    }
}
