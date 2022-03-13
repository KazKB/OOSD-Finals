package com.StockManager;

public class TestDriver {
    public static void main(String[] args) {
        Beer beer = new Beer();
        User user = new User("admin", "sd");
        Beer beer2 = new Beer("sf", "dsf", "sdfsd", "sdfa", 23, user);
        Beer beer3 = new Beer("sf", "sadfsa", "hdshf", "sadf", 23, user);

        System.out.println(beer.toString());
        System.out.println(beer2.toString());
        System.out.println(beer3.toString());
    }
}
