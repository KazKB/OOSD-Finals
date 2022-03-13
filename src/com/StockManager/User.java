package com.StockManager;

import java.util.Arrays;

public class User {
    private String userName, userEmail, userID, userType, password;
    private static Beer[] beerList = new Beer[10];
    private static int i = 0;

    public User() {
        beerList[0] = new Beer();
    }

    public User(String type, String id) {
        this.userType = type;
        this.userID = id;
        beerList[0] = new Beer();
    }

    public User(String firstName, String lastName, String email, String id, String type, String password) {
        this.userName = firstName + " " + lastName;
        this.userEmail = email;
        this.userID = id;
        this.userType = type;
        this.password = password;
        beerList[0] = new Beer();
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

    public void addToStockList(Beer beer) {
        if (this.userType.equalsIgnoreCase("admin")) {
            //Increases beerList's max size when capacity is reached
            if (i >= beerList.length) {
                beerList = Arrays.copyOf(beerList, beerList.length + 5);
            }
            //Adds beer to beer list and increases the position to the next location
            beerList[i] = beer;
            i++;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void removeFromStockList(Beer beer) {
        int k = 0;

        if (this.userType.equalsIgnoreCase("admin")) {
            if (beerList[0] != null) {
                //Cycles through until the end of the array or until the particular beer is found
                while ((!beerList[k].getItemName().equalsIgnoreCase(beer.getItemName())) && (k < i - 1)) {
                    k++;
                }
                //If target is found, remove it and the rest beer after it from the list
                //Then copy the beer after the list back to the list
                //As well decrease the position for where the next beer item will be added
                if (beerList[k].getItemName().equalsIgnoreCase(beer.getItemName())) {
                    System.arraycopy(beerList, k + 1, beerList, k, i);
                    i--;
                } else {
                    System.out.println(beer.getItemName().toUpperCase() + " is not in stock.\n");
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

    public void viewStockList() {
        //Checks if beer list is empty
        if (beerList[0] == null) {
            System.out.println("No beer is in stock.\n");
        }
        else {
            //If not empty print what is in the list's name
            for (int k = 0; k < i; k++) {
                System.out.println(beerList[k].getItemName().toUpperCase());
            }
            System.out.println();
        }
    }

    public boolean checkIfInStock(String beer) {
        int k = 0;

        //Cycles through array until target is found, end was reached or the next item is null
        while ((!beerList[k].getItemName().equalsIgnoreCase(beer)) && (k < i) && (beerList[k + 1] != null)) {
            k++;
        }

        //Returns whether the target was found or not
        return beerList[k].getItemName().equalsIgnoreCase(beer);
    }

    public void addQuantityToStock(String beer, int quantity) {
        int k = 0;

        //Cycles through array until target is found, end has reached or the next item is null
        while ((!beerList[k].getItemName().equalsIgnoreCase(beer)) && (k < i) && (beerList[k + 1] != null)) {
            k++;
        }

        //Add to the amount of beer owned
        beerList[k].addToStock(quantity);
    }

    public void removeQuantityFromStock(String beer, int quantity) {
        int k = 0;

        //Cycles through array until beer is found, end was reached or the next item is null
        while ((!beerList[k].getItemName().equalsIgnoreCase(beer)) && (k < i) && (beerList[k + 1] != null)) {
            k++;
        }

        //Remove from amount of beer owned
        beerList[k].removeFromStock(quantity);
    }

    public Beer getStock(String beer) {
        int k = 0;

        //Cycles through array until beer is found, end has reached or the next item is null
        while ((!beerList[k].getItemName().equalsIgnoreCase(beer)) && (k < i) && (beerList[k + 1] != null)) {
            k++;
        }

        //Returns target if found
        return beerList[k];
    }
}
