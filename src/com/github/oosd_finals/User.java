package com.github.oosd_finals;

import java.util.Arrays;

import static java.lang.Math.abs;

public class User {
    private String userName, userEmail, userID, userType, password;
    private static Beer[] beerList = new Beer[10];
    private static Spirit[] spiritList = new Spirit[10];
    private static Juice[] juiceList = new Juice[10];
    private static Soda[] sodaList = new Soda[10];
    private static Water[] waterList = new Water[10];
    private static Wine[] wineList = new Wine[10];
    private static Champagne[] champagneList = new Champagne[10];
    private static int beer = 0, spirit = 0, juice = 0, soda = 0, water = 0, wine = 0, champagne = 0;
    private static double wallet;

    public User() {
        beerList[0] = new Beer();
        spiritList[0] = new Spirit();
        juiceList[0] = new Juice();
        sodaList[0] = new Soda();
        waterList[0] = new Water();
        wineList[0] = new Wine();
        champagneList[0] = new Champagne();
    }

    public User(String type, String id) {
        this.userType = type;
        this.userID = id;
        beerList[0] = new Beer();
        spiritList[0] = new Spirit();
        juiceList[0] = new Juice();
        sodaList[0] = new Soda();
        waterList[0] = new Water();
        wineList[0] = new Wine();
        champagneList[0] = new Champagne();
    }

    public User(String firstName, String lastName, String email, String id, String type, String password) {
        this.userName = firstName + " " + lastName;
        this.userEmail = email;
        this.userID = id;
        this.userType = type;
        this.password = password;
        beerList[0] = new Beer();
        spiritList[0] = new Spirit();
        juiceList[0] = new Juice();
        sodaList[0] = new Soda();
        waterList[0] = new Water();
        wineList[0] = new Wine();
        champagneList[0] = new Champagne();
    }

    //Getters and Setters will be used to edit this Class
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserName(String firstName, String lastName) {
        this.userName = firstName + " " + lastName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserType() {
        return userType;
    }

    public static void setWallet(double wallet) {
        User.wallet = wallet;
    }

    public static double getWallet() {
        return wallet;
    }

    public String printProfitAndLoss() {
        String s = null;

        if(wallet > 0) {
            s = String.format("You made a profit of $%.2f.%n", wallet);
        }
        else if (wallet == 0) {
            s = String.format("You broke even.%n");
        }
        else if (wallet < 0) {
            s= String.format("You made a loss of $%.2f.%n", abs(wallet));
        }

        return s;
    }

    public void addToStockList(Beer stock) {
        if (this.userType.equalsIgnoreCase("admin")) {
            //Increases list's max size when capacity is reached
            if (beer >= beerList.length) {
                beerList = Arrays.copyOf(beerList, beerList.length + 5);
            }
            //Adds stock to list and increases the position to the next location
            beerList[beer] = stock;
            beer++;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void addToStockList(Spirit stock) {
        if (this.userType.equalsIgnoreCase("admin")) {
            //Increases list's max size when capacity is reached
            if (spirit >= spiritList.length) {
                spiritList = Arrays.copyOf(spiritList, spiritList.length + 5);
            }
            //Adds stock to list and increases the position to the next location
            spiritList[spirit] = stock;
            spirit++;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void addToStockList(Juice stock) {
        if (this.userType.equalsIgnoreCase("admin")) {
            //Increases list's max size when capacity is reached
            if (juice >= juiceList.length) {
                juiceList = Arrays.copyOf(juiceList, juiceList.length + 5);
            }
            //Adds stock to list and increases the position to the next location
            juiceList[juice] = stock;
            juice++;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void addToStockList(Soda stock) {
        if (this.userType.equalsIgnoreCase("admin")) {
            //Increases list's max size when capacity is reached
            if (soda >= sodaList.length) {
                sodaList = Arrays.copyOf(sodaList, sodaList.length + 5);
            }
            //Adds stock to list and increases the position to the next location
            sodaList[soda] = stock;
            soda++;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void addToStockList(Water stock) {
        if (this.userType.equalsIgnoreCase("admin")) {
            //Increases list's max size when capacity is reached
            if (water >= waterList.length) {
                waterList = Arrays.copyOf(waterList, waterList.length + 5);
            }
            //Adds stock to list and increases the position to the next location
            waterList[water] = stock;
            water++;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void addToStockList(Wine stock) {
        if (this.userType.equalsIgnoreCase("admin")) {
            //Increases list's max size when capacity is reached
            if (wine >= wineList.length) {
                wineList = Arrays.copyOf(wineList, wineList.length + 5);
            }
            //Adds stock to list and increases the position to the next location
            wineList[wine] = stock;
            wine++;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void addToStockList(Champagne stock) {
        if (this.userType.equalsIgnoreCase("admin")) {
            //Increases list's max size when capacity is reached
            if (champagne >= champagneList.length) {
                champagneList = Arrays.copyOf(champagneList, champagneList.length + 5);
            }
            //Adds stock to list and increases the position to the next location
            champagneList[champagne] = stock;
            champagne++;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void removeFromBeerList(String stock) {
        int k = 0;

        if (this.userType.equalsIgnoreCase("admin")) {
            if (beerList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while ((!beerList[k].getItemName().equalsIgnoreCase(stock)) && (k < beer - 1)) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (beerList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(beerList, k + 1, beerList, k, beer);
                    beer--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.\n");
                }
            }
            else {
                System.out.println("No beer is in stock.\n");
            }
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void removeFromSpiritList(String stock) {
        int k = 0;

        if (this.userType.equalsIgnoreCase("admin")) {
            if (spiritList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while ((!spiritList[k].getItemName().equalsIgnoreCase(stock)) && (k < spirit - 1)) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (spiritList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(spiritList, k + 1, spiritList, k, spirit);
                    spirit--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.\n");
                }
            }
            else {
                System.out.println("No spirit is in stock.\n");
            }
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void removeFromJuiceList(String stock) {
        int k = 0;

        if (this.userType.equalsIgnoreCase("admin")) {
            if (juiceList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while ((!juiceList[k].getItemName().equalsIgnoreCase(stock)) && (k < juice - 1)) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (juiceList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(juiceList, k + 1, juiceList, k, juice);
                    juice--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.\n");
                }
            }
            else {
                System.out.println("No juice is in stock.\n");
            }
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void removeFromSodaList(String stock) {
        int k = 0;

        if (this.userType.equalsIgnoreCase("admin")) {
            if (sodaList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while ((!sodaList[k].getItemName().equalsIgnoreCase(stock)) && (k < soda - 1)) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (sodaList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(sodaList, k + 1, sodaList, k, soda);
                    soda--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.\n");
                }
            }
            else {
                System.out.println("No soda is in stock.\n");
            }
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }


    public void removeFromWaterList(String stock) {
        int k = 0;

        if (this.userType.equalsIgnoreCase("admin")) {
            if (waterList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while ((!waterList[k].getItemName().equalsIgnoreCase(stock)) && (k < water - 1)) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (waterList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(waterList, k + 1, waterList, k, water);
                    water--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.\n");
                }
            }
            else {
                System.out.println("No water is in stock.\n");
            }
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }


    public void removeFromWineList(String stock) {
        int k = 0;

        if (this.userType.equalsIgnoreCase("admin")) {
            if (wineList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while ((!wineList[k].getItemName().equalsIgnoreCase(stock)) && (k < wine - 1)) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (wineList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(wineList, k + 1, wineList, k, wine);
                    wine--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.\n");
                }
            }
            else {
                System.out.println("No wine is in stock.\n");
            }
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }


    public void removeFromChampagneList(String stock) {
        int k = 0;

        if (this.userType.equalsIgnoreCase("admin")) {
            if (champagneList[0] != null) {
                //Cycles through until the end of the array or until the target is found
                while ((!champagneList[k].getItemName().equalsIgnoreCase(stock)) && (k < champagne - 1)) {
                    k++;
                }
                //If target is found, remove it and the rest stock after it from the list
                //Then copy the stock after the list back to the list
                //As well decrease the position for where the next stock item will be added
                if (champagneList[k].getItemName().equalsIgnoreCase(stock)) {
                    System.arraycopy(champagneList, k + 1, champagneList, k, champagne);
                    champagne--;
                } else {
                    System.out.println(stock.toUpperCase() + " is not in stock.\n");
                }
            }
            else {
                System.out.println("No champagne is in stock.\n");
            }
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void viewBeerList() {
        //Checks if list is empty
        if (beerList[0] == null) {
            System.out.println("No beer is in stock.\n");
        }
        else {
            //If not empty print what is in the list's name
            for (int k = 0; k < beer; k++) {
                System.out.println(beerList[k].getItemName().toUpperCase());
            }
            System.out.println();
        }
    }

    public void viewSpiritList() {
        //Checks if list is empty
        if (spiritList[0] == null) {
            System.out.println("No spirit is in stock.\n");
        }
        else {
            //If not empty print what is in the list's name
            for (int k = 0; k < spirit; k++) {
                System.out.println(spiritList[k].getItemName().toUpperCase());
            }
            System.out.println();
        }
    }

    public boolean checkIfBeerInStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while ((!beerList[k].getItemName().equalsIgnoreCase(stock)) && (k < beer) && (beerList[k + 1] != null)) {
            k++;
        }

        //Returns whether the target was found or not
        return beerList[k].getItemName().equalsIgnoreCase(stock);
    }

    public boolean checkIfSpiritInStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while ((!spiritList[k].getItemName().equalsIgnoreCase(stock)) && (k < spirit) && (spiritList[k + 1] != null)) {
            k++;
        }

        //Returns whether the target was found or not
        return spiritList[k].getItemName().equalsIgnoreCase(stock);
    }

    public void addQuantityToBeerStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while ((!beerList[k].getItemName().equalsIgnoreCase(stock)) && (k < beer) && (beerList[k + 1] != null)) {
            k++;
        }

        //Add to the amount of stock owned
        beerList[k].addToStock(quantity);
    }

    public void addQuantityToSpiritStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while ((!spiritList[k].getItemName().equalsIgnoreCase(stock)) && (k < spirit && (spiritList[k + 1] != null))) {
            k++;
        }

        //Add to the amount of stock owned
        spiritList[k].addToStock(quantity);
    }

    public void removeQuantityFromBeerStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while ((!beerList[k].getItemName().equalsIgnoreCase(stock)) && (k < beer) && (beerList[k + 1] != null)) {
            k++;
        }

        //Remove from amount of stock owned
        beerList[k].removeFromStock(quantity);
    }

    public void removeQuantityFromSpiritStock(String stock, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while ((!spiritList[k].getItemName().equalsIgnoreCase(stock)) && (k < spirit) && (spiritList[k + 1] != null)) {
            k++;
        }

        //Remove from amount of stock owned
        spiritList[k].removeFromStock(quantity);
    }

    public Beer getBeerStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while ((!beerList[k].getItemName().equalsIgnoreCase(stock)) && (k < beer) && (beerList[k + 1] != null)) {
            k++;
        }

        //Returns target if found
        return beerList[k];
    }

    public Spirit getSpiritStock(String stock) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while ((!spiritList[k].getItemName().equalsIgnoreCase(stock)) && (k < spirit) && (spiritList[k + 1] != null)) {
            k++;
        }

        //Returns target if found
        return spiritList[k];
    }
}