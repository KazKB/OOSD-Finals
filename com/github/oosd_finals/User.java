package com.github.oosd_finals;

import java.util.Arrays;

import static java.lang.Math.abs;

public class User {
    private static String userID;
    private static String userType;
    private static Beer[] beerList = new Beer[10];
    private static Spirit[] spiritList = new Spirit[10];
    private static Juice[] juiceList = new Juice[10];
    private static Soda[] sodaList = new Soda[10];
    private static Water[] waterList = new Water[10];
    private static Wine[] wineList = new Wine[10];
    private static Champagne[] champagneList = new Champagne[10];
    private static Supplier[] suppliers = new Supplier[10];
    private static Customer[] customers = new Customer[10];
    private static int beer = 0, spirit = 0, juice = 0, soda = 0, water = 0, wine = 0, champagne = 0, supplier = 0, customer = 0;
    private static double wallet = 0.0;

    public User() {
        beerList[0] = new Beer();
        spiritList[0] = new Spirit();
        juiceList[0] = new Juice();
        sodaList[0] = new Soda();
        waterList[0] = new Water();
        wineList[0] = new Wine();
        champagneList[0] = new Champagne();
        suppliers[0] = new Supplier();
        customers[0] = new Customer();
    }

    public User(String type, String id) {
        userType = type;
        userID = id;
        beerList[0] = new Beer();
        spiritList[0] = new Spirit();
        juiceList[0] = new Juice();
        sodaList[0] = new Soda();
        waterList[0] = new Water();
        wineList[0] = new Wine();
        champagneList[0] = new Champagne();
        suppliers[0] = new Supplier();
        customers[0] = new Customer();
    }

    //Getters and Setters will be used to edit this Class
    public static String getUserID() {
        return userID;
    }

    public static String getUserType() {
        return userType;
    }

    public static void setWallet(double wallet) {
        User.wallet = wallet;
    }

    public static double getWallet() {
        return wallet;
    }

    public static String printProfitAndLoss() {
        String s = null;

        if(wallet > 0) {
            s = String.format("You made a profit of $%.2f.%n", wallet);
         } else if (wallet == 0) {
            s = String.format("You broke even.%n");
         } else if (wallet < 0) {
            s= String.format("You made a loss of $%.2f.%n", abs(wallet));
        }

        return s;
    }

    public static void addToSuppliers(Supplier person) {
         if(getUserType().equalsIgnoreCase("a")) {
            //Increases list's max size when capacity is reached
            if (supplier >= suppliers.length) {
                suppliers = Arrays.copyOf(suppliers, suppliers.length + 1);
            }
            //Adds supplier to list and increases the position to the next location
            suppliers[supplier] = person;
            supplier++;
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void addToCustomers(Customer person) {
         if(getUserType().equalsIgnoreCase("a")) {
            //Increases list's max size when capacity is reached
            if (customer >= customers.length) {
                customers = Arrays.copyOf(customers, customers.length + 1);
            }
            //Adds customer to list and increases the position to the next location
            customers[customer] = person;
            customer++;
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void addToStockList(Beer stock) {
        if(getUserType().equalsIgnoreCase("a")) {
            //Increases list's max size when capacity is reached
            if (beer >= beerList.length) {
                beerList = Arrays.copyOf(beerList, beerList.length + 1);
            }
            //Adds stock to list and increases the position to the next location
            beerList[beer] = stock;
            beer++;
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void addToStockList(Spirit stock) {
         if(getUserType().equalsIgnoreCase("a")) {
            //Increases list's max size when capacity is reached
            if (spirit >= spiritList.length) {
                spiritList = Arrays.copyOf(spiritList, spiritList.length + 1);
            }
            //Adds stock to list and increases the position to the next location
            spiritList[spirit] = stock;
            spirit++;
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void addToStockList(Juice stock) {
         if(getUserType().equalsIgnoreCase("a")) {
            //Increases list's max size when capacity is reached
            if (juice >= juiceList.length) {
                juiceList = Arrays.copyOf(juiceList, juiceList.length + 1);
            }
            //Adds stock to list and increases the position to the next location
            juiceList[juice] = stock;
            juice++;
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void addToStockList(Soda stock) {
         if(getUserType().equalsIgnoreCase("a")) {
            //Increases list's max size when capacity is reached
            if (soda >= sodaList.length) {
                sodaList = Arrays.copyOf(sodaList, sodaList.length + 1);
            }
            //Adds stock to list and increases the position to the next location
            sodaList[soda] = stock;
            soda++;
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void addToStockList(Water stock) {
         if(getUserType().equalsIgnoreCase("a")) {
            //Increases list's max size when capacity is reached
            if (water >= waterList.length) {
                waterList = Arrays.copyOf(waterList, waterList.length + 1);
            }
            //Adds stock to list and increases the position to the next location
            waterList[water] = stock;
            water++;
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void addToStockList(Wine stock) {
         if(getUserType().equalsIgnoreCase("a")) {
            //Increases list's max size when capacity is reached
            if (wine >= wineList.length) {
                wineList = Arrays.copyOf(wineList, wineList.length + 1);
            }
            //Adds stock to list and increases the position to the next location
            wineList[wine] = stock;
            wine++;
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void addToStockList(Champagne stock) {
         if(getUserType().equalsIgnoreCase("a")) {
            //Increases list's max size when capacity is reached
            if (champagne >= champagneList.length) {
                champagneList = Arrays.copyOf(champagneList, champagneList.length + 1);
            }
            //Adds stock to list and increases the position to the next location
            champagneList[champagne] = stock;
            champagne++;
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void removeFromSuppliers(String person) {
        int k = 0;

         if(getUserType().equalsIgnoreCase("a")) {
            if (suppliers[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while (!suppliers[k].getSupplierName().equalsIgnoreCase(person) && k < supplier && suppliers[k + 1] != null) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the suppliers after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (suppliers[k].getSupplierName().equalsIgnoreCase(person)) {
                    System.arraycopy(suppliers, k + 1, suppliers, k, supplier);
                    supplier--;
                } else {
                    System.out.println(person.toUpperCase() + " is not an added supplier.");
                }
             } else {
                System.out.println("No suppliers available.");
            }
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void removeFromCustomers(String person) {
        int k = 0;

         if(getUserType().equalsIgnoreCase("a")) {
            if (customers[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while (!customers[k].getCustomerName().equalsIgnoreCase(person) && k < customer && customers[k + 1] != null) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the suppliers after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (customers[k].getCustomerName().equalsIgnoreCase(person)) {
                    System.arraycopy(customers, k + 1, customers, k, customer);
                    customer--;
                } else {
                    System.out.println(person.toUpperCase() + " is not an added customer.");
                }
             } else {
                System.out.println("No customers available.");
            }
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void removeFromBeerList(String stock) {
        int k = 0;

         if(getUserType().equalsIgnoreCase("a")) {
            if (beerList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while (!beerList[k].getItemName().equalsIgnoreCase(stock) && k < beer && beerList[k + 1] != null) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (beerList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(beerList, k + 1, beerList, k, beer);
                    beer--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.");
                }
             } else {
                System.out.println("No beer is in stock.");
            }
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void removeFromSpiritList(String stock) {
        int k = 0;

         if(getUserType().equalsIgnoreCase("a")) {
            if (spiritList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while (!spiritList[k].getItemName().equalsIgnoreCase(stock) && k < spirit && spiritList[k + 1] != null) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (spiritList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(spiritList, k + 1, spiritList, k, spirit);
                    spirit--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.");
                }
             } else {
                System.out.println("No spirit is in stock.");
            }
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void removeFromJuiceList(String stock) {
        int k = 0;

         if(getUserType().equalsIgnoreCase("a")) {
            if (juiceList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while (!juiceList[k].getItemName().equalsIgnoreCase(stock) && k < juice && juiceList[k + 1] != null) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (juiceList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(juiceList, k + 1, juiceList, k, juice);
                    juice--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.");
                }
             } else {
                System.out.println("No juice is in stock.");
            }
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void removeFromSodaList(String stock) {
        int k = 0;

         if(getUserType().equalsIgnoreCase("a")) {
            if (sodaList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while (!sodaList[k].getItemName().equalsIgnoreCase(stock) && k < soda && sodaList[k + 1] != null) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (sodaList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(sodaList, k + 1, sodaList, k, soda);
                    soda--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.");
                }
             } else {
                System.out.println("No soda is in stock.");
            }
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void removeFromWaterList(String stock) {
        int k = 0;

         if(getUserType().equalsIgnoreCase("a")) {
            if (waterList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while (!waterList[k].getItemName().equalsIgnoreCase(stock) && k < water && waterList[k + 1] != null) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (waterList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(waterList, k + 1, waterList, k, water);
                    water--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.");
                }
             } else {
                System.out.println("No water is in stock.");
            }
         } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void removeFromWineList(String stock) {
        int k = 0;

         if(getUserType().equalsIgnoreCase("a")) {
            if (wineList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while (!wineList[k].getItemName().equalsIgnoreCase(stock) && k < wine && wineList[k + 1] != null) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (wineList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(wineList, k + 1, wineList, k, wine);
                    wine--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.");
                }
            } else {
                System.out.println("No wine is in stock.");
            }
        } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void removeFromChampagneList(String stock) {
        int k = 0;

         if(getUserType().equalsIgnoreCase("a")) {
            if (champagneList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while (!champagneList[k].getItemName().equalsIgnoreCase(stock) && k < champagne && champagneList[k + 1] != null) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (champagneList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(champagneList, k + 1, champagneList, k, champagne);
                    champagne--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.");
                }
            } else {
                System.out.println("No champagne is in stock.");
            }
        } else {
            System.out.println("You do not have admin privileges.");
        }
    }

    public static void viewSuppliers() {
        //Checks if list is empty
        if (suppliers[0].getSupplierName().equals("")) {
            System.out.println("No suppliers available.");
         } else {
            //If not empty print what is in the list's name
            for (int k = 0; k < supplier; k++) {
                System.out.println(suppliers[k].getSupplierName().toUpperCase());
            }
            System.out.println();
        }
    }

    public static void viewCustomers() {
        //Checks if list is empty
        if (customers[0].getCustomerName().equals("")) {
            System.out.println("No customers available.");
         } else {
            //If not empty print what is in the list's name
            for (int k = 0; k < customer; k++) {
                System.out.println(customers[k].getCustomerName().toUpperCase());
            }
            System.out.println();
        }
    }

    public static void viewBeerList() {
        //Checks if list is empty
        if (beerList[0].getItemName().equals("")) {
            System.out.println("No beer is in stock.");
         } else {
            //If not empty print what is in the list's name
            for (int k = 0; k < beer; k++) {
                System.out.println(beerList[k].getItemName().toUpperCase());
            }
            System.out.println();
        }
    }

    public static void viewSpiritList() {
        //Checks if list is empty
        if (spiritList[0].getItemName().equals("")) {
            System.out.println("No spirit is in stock.");
         } else {
            //If not empty print what is in the list's name
            for (int k = 0; k < spirit; k++) {
                System.out.println(spiritList[k].getItemName().toUpperCase());
            }
            System.out.println();
        }
    }

    public static void viewJuiceList() {
        //Checks if list is empty
        if (juiceList[0].getItemName().equals("")) {
            System.out.println("No juice is in stock.");
         } else {
            //If not empty print what is in the list's name
            for (int k = 0; k < juice; k++) {
                System.out.println(juiceList[k].getItemName().toUpperCase());
            }
            System.out.println();
        }
    }

    public static void viewSodaList() {
        //Checks if list is empty
        if (sodaList[0].getItemName().equals("")) {
            System.out.println("No soda is in stock.");
         } else {
            //If not empty print what is in the list's name
            for (int k = 0; k < soda; k++) {
                System.out.println(sodaList[k].getItemName().toUpperCase());
            }
            System.out.println();
        }
    }

    public static void viewWaterList() {
        //Checks if list is empty
        if (waterList[0].getItemName().equals("")) {
            System.out.println("No water is in stock.");
         } else {
            //If not empty print what is in the list's name
            for (int k = 0; k < water; k++) {
                System.out.println(waterList[k].getItemName().toUpperCase());
            }
            System.out.println();
        }
    }

    public static void viewWineList() {
        //Checks if list is empty
        if (wineList[0].getItemName().equals("")) {
            System.out.println("No wine is in stock.");
         } else {
            //If not empty print what is in the list's name
            for (int k = 0; k < wine; k++) {
                System.out.println(wineList[k].getItemName().toUpperCase());
            }
            System.out.println();
        }
    }

    public static void viewChampagneList() {
        //Checks if list is empty
        if (champagneList[0].getItemName().equals("")) {
            System.out.println("No champagne is in stock.");
         } else {
            //If not empty print what is in the list's name
            for (int k = 0; k < champagne; k++) {
                System.out.println(champagneList[k].getItemName().toUpperCase());
            }
            System.out.println();
        }
    }

    public static boolean checkIfPersonInSuppliers(String person) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!suppliers[k].getSupplierName().equalsIgnoreCase(person) && k < supplier && suppliers[k + 1] != null) {
            k++;
        }

        //Returns whether the target was found or not
        return suppliers[k].getSupplierName().equalsIgnoreCase(person);
    }

    public static boolean checkIfPersonInCustomers(String person) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!customers[k].getCustomerName().equalsIgnoreCase(person) && k < customer && customers[k + 1] != null) {
            k++;
        }

        //Returns whether the target was found or not
        return customers[k].getCustomerName().equalsIgnoreCase(person);
    }

    public static boolean checkIfBeerInStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!beerList[k].getItemName().equalsIgnoreCase(stock) && k < beer && beerList[k + 1] != null) {
            k++;
        }

        //Returns whether the target was found or not
        return beerList[k].getItemName().equalsIgnoreCase(stock);
    }

    public static boolean checkIfSpiritInStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!spiritList[k].getItemName().equalsIgnoreCase(stock) && k < spirit && spiritList[k + 1] != null) {
            k++;
        }

        //Returns whether the target was found or not
        return spiritList[k].getItemName().equalsIgnoreCase(stock);
    }

    public static boolean checkIfJuiceInStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!juiceList[k].getItemName().equalsIgnoreCase(stock) && k < juice && juiceList[k + 1] != null) {
            k++;
        }

        //Returns whether the target was found or not
        return juiceList[k].getItemName().equalsIgnoreCase(stock);
    }

    public static boolean checkIfSodaInStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!sodaList[k].getItemName().equalsIgnoreCase(stock) && k < soda && sodaList[k + 1] != null) {
            k++;
        }

        //Returns whether the target was found or not
        return sodaList[k].getItemName().equalsIgnoreCase(stock);
    }

    public static boolean checkIfWaterInStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!waterList[k].getItemName().equalsIgnoreCase(stock) && k < water && waterList[k + 1] != null) {
            k++;
        }

        //Returns whether the target was found or not
        return waterList[k].getItemName().equalsIgnoreCase(stock);
    }

    public static boolean checkIfWineInStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!wineList[k].getItemName().equalsIgnoreCase(stock) && k < wine && wineList[k + 1] != null) {
            k++;
        }

        //Returns whether the target was found or not
        return wineList[k].getItemName().equalsIgnoreCase(stock);
    }

    public static boolean checkIfChampagneInStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!champagneList[k].getItemName().equalsIgnoreCase(stock) && k < champagne && champagneList[k + 1] != null) {
            k++;
        }

        //Returns whether the target was found or not
        return champagneList[k].getItemName().equalsIgnoreCase(stock);
    }

    public static void addQuantityToBeerStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!beerList[k].getItemName().equalsIgnoreCase(stock) && k < beer && beerList[k + 1] != null) {
            k++;
        }

        //Add to the amount of stock owned
        beerList[k].addToStock(quantity);
    }

    public static void addQuantityToSpiritStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!spiritList[k].getItemName().equalsIgnoreCase(stock) && k < spirit && spiritList[k + 1] != null) {
            k++;
        }

        //Add to the amount of stock owned
        spiritList[k].addToStock(quantity);
    }

    public static void addQuantityToJuiceStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!juiceList[k].getItemName().equalsIgnoreCase(stock) && k < juice && juiceList[k + 1] != null) {
            k++;
        }

        //Add to the amount of stock owned
        juiceList[k].addToStock(quantity);
    }

    public static void addQuantityToSodaStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!sodaList[k].getItemName().equalsIgnoreCase(stock) && k < soda && sodaList[k + 1] != null) {
            k++;
        }

        //Add to the amount of stock owned
        sodaList[k].addToStock(quantity);
    }

    public static void addQuantityToWaterStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!waterList[k].getItemName().equalsIgnoreCase(stock) && k < water && waterList[k + 1] != null) {
            k++;
        }

        //Add to the amount of stock owned
        waterList[k].addToStock(quantity);
    }

    public static void addQuantityToWineStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!wineList[k].getItemName().equalsIgnoreCase(stock) && k < wine && wineList[k + 1] != null) {
            k++;
        }

        //Add to the amount of stock owned
        wineList[k].addToStock(quantity);
    }

    public static void addQuantityToChampagneStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!champagneList[k].getItemName().equalsIgnoreCase(stock) && k < champagne && champagneList[k + 1] != null) {
            k++;
        }

        //Add to the amount of stock owned
        champagneList[k].addToStock(quantity);
    }

    public static void removeQuantityFromBeerStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!beerList[k].getItemName().equalsIgnoreCase(stock) && k < beer && beerList[k + 1] != null) {
            k++;
        }

        //Remove from amount of stock owned
        beerList[k].removeFromStock(quantity);
    }

    public static void removeQuantityFromSpiritStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!spiritList[k].getItemName().equalsIgnoreCase(stock) && k < spirit && spiritList[k + 1] != null) {
            k++;
        }

        //Remove from amount of stock owned
        spiritList[k].removeFromStock(quantity);
    }

    public static void removeQuantityFromJuiceStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!juiceList[k].getItemName().equalsIgnoreCase(stock) && k < juice && juiceList[k + 1] != null) {
            k++;
        }

        //Remove from amount of stock owned
        juiceList[k].removeFromStock(quantity);
    }

    public static void removeQuantityFromSodaStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!sodaList[k].getItemName().equalsIgnoreCase(stock) && k < soda && sodaList[k + 1] != null) {
            k++;
        }

        //Remove from amount of stock owned
        sodaList[k].removeFromStock(quantity);
    }

    public static void removeQuantityFromWaterStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!waterList[k].getItemName().equalsIgnoreCase(stock) && k < water && waterList[k + 1] != null) {
            k++;
        }

        //Remove from amount of stock owned
        waterList[k].removeFromStock(quantity);
    }

    public static void removeQuantityFromWineStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!wineList[k].getItemName().equalsIgnoreCase(stock) && k < wine && wineList[k + 1] != null) {
            k++;
        }

        //Remove from amount of stock owned
        wineList[k].removeFromStock(quantity);
    }

    public static void removeQuantityFromChampagneStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while (!champagneList[k].getItemName().equalsIgnoreCase(stock) && k < champagne && champagneList[k + 1] != null) {
            k++;
        }

        //Remove from amount of stock owned
        champagneList[k].removeFromStock(quantity);
    }

    public static Supplier getSupplier(String person) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!suppliers[k].getSupplierName().equalsIgnoreCase(person) && k < supplier && suppliers[k + 1] != null) {
            k++;
        }

        //Returns target if found
        return suppliers[k];
    }

    public static Customer getCustomer(String person) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!customers[k].getCustomerName().equalsIgnoreCase(person) && k < customer && customers[k + 1] != null) {
            k++;
        }

        //Returns target if found
        return customers[k];
    }

    public static Beer getBeerStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!beerList[k].getItemName().equalsIgnoreCase(stock) && k < beer && beerList[k + 1] != null) {
            k++;
        }

        //Returns target if found
        return beerList[k];
    }

    public static Spirit getSpiritStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!spiritList[k].getItemName().equalsIgnoreCase(stock) && k < spirit && spiritList[k + 1] != null) {
            k++;
        }

        //Returns target if found
        return spiritList[k];
    }

    public static Juice getJuiceStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!juiceList[k].getItemName().equalsIgnoreCase(stock) && k < juice && juiceList[k + 1] != null) {
            k++;
        }

        //Returns target if found
        return juiceList[k];
    }

    public static Soda getSodaStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!sodaList[k].getItemName().equalsIgnoreCase(stock) && k < soda && sodaList[k + 1] != null) {
            k++;
        }

        //Returns target if found
        return sodaList[k];
    }

    public static Water getWaterStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!waterList[k].getItemName().equalsIgnoreCase(stock) && k < water && waterList[k + 1] != null) {
            k++;
        }

        //Returns target if found
        return waterList[k];
    }

    public static Wine getWineStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!wineList[k].getItemName().equalsIgnoreCase(stock) && k < wine && wineList[k + 1] != null) {
            k++;
        }

        //Returns target if found
        return wineList[k];
    }

    public static Champagne getChampagneStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while (!champagneList[k].getItemName().equalsIgnoreCase(stock) && k < champagne && champagneList[k + 1] != null) {
            k++;
        }

        //Returns target if found
        return champagneList[k];
    }
}