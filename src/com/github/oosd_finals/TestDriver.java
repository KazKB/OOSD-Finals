package com.github.oosd_finals;

public class TestDriver {
    public static void main(String[] args) {
        User user = new User("admin", "sd");
        Beer beer = new Beer("Beer", "Beer", "Beer", 10, user);
        Spirit spirit = new Spirit("Spirit", "Spirit", "Spirit", 15, user);

        user.addToStockList(beer);
        user.addToStockList(spirit);

        Supplier supplier = new Supplier("Supplier", "e", "n", user);
        supplier.addPurchasableItem("Beer", "5", user);
        supplier.addPurchasableItem("Spirit", "10", user);
        supplier.createAndPrintInvoice("Beer", 5, user);
        supplier.createAndPrintInvoice("Spirit", 5, user);

        System.out.println(user.printProfitAndLoss());

        Customer customer = new Customer("Customer", "e", "n", user);
        customer.createAndPrintSalesReceipt("Beer", 5, user);
        customer.createAndPrintSalesReceipt("Spirit", 5, user);

        System.out.println(user.printProfitAndLoss());

        customer.printPurchasedItems();
        customer.removePurchasedItem("Beer", 5, user);
        customer.removePurchasedItem("Spirit", 5, user);

        System.out.println(beer);
        System.out.println(spirit);

        System.out.println(user.printProfitAndLoss());
    }
}
