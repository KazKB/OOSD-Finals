package com.github.oosd_finals;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Supplier {
    private String supplierName, supplierEmail, supplierContactNumber;
    private int invoiceNumber = 0, i = 0;
    private String[][] supplierItemList = new String[10][2];

    public Supplier() {
        if(User.getUserType().equalsIgnoreCase("a")) {
            this.supplierName = "";
        } else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public Supplier(String name, String email, String contactNumber) {
        if(User.getUserType().equalsIgnoreCase("a")) {
            this.supplierName = name;
            this.supplierEmail = email;
            this.supplierContactNumber = contactNumber;
        } else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        if (User.getUserType().equalsIgnoreCase("a")) {
            this.supplierName = supplierName;
        } else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        if (User.getUserType().equalsIgnoreCase("a")) {
            this.supplierEmail = supplierEmail;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public String getSupplierContactNumber() {
        return supplierContactNumber;
    }

    public void setSupplierContactNumber(String supplierContactNumber) {
        if (User.getUserType().equalsIgnoreCase("a")) {
            this.supplierContactNumber = supplierContactNumber;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    //Basically the constructor but as a method
    public void editSupplierInformation(String name, String email, String contactNumber) {
        if(User.getUserType().equalsIgnoreCase("a")) {
            this.supplierName = name;
            this.supplierEmail = email;
            this.supplierContactNumber = contactNumber;
        }
    }

    //Adds an item and its price to a list that contains what is sold by the supplier
    //Only admins have access to this action
    public void addPurchasableItem(String item, double price) {
        //Temporary array that is 10 spaces bigger than original
        String[][] temp = new String[this.supplierItemList.length + 10][2];

        if(User.getUserType().equalsIgnoreCase("a")) {
            if (i >= this.supplierItemList.length) {
                //Loops through rows of the original 2d array and copies the columns to the temporary 2d array
                for (int j = 0; j < this.supplierItemList.length; j++) {
                    System.arraycopy(this.supplierItemList[j], 0, temp[j], 0, 2);
                }
                //Resizes the original to the temporary 2d array's size
                this.supplierItemList = new String[temp.length][2];
                //Loops through rows of the temporary 2d array and copies the columns to the original 2d array
                for (int j = 0; j < this.supplierItemList.length; j++) {
                    System.arraycopy(temp[j], 0, this.supplierItemList[j], 0, 2);
                }
            }
            //Adds the item and price to the list and moves to the next array location
            this.supplierItemList[i][0] = item;
            this.supplierItemList[i][1] = String.valueOf(String.format("%.2f", price));
            i++;
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    //Removes an item and its price to a list that contains what is sold by the supplier
    //Only admins have access to this action
    public void removePurchasableItem(String item) {
        if (User.getUserType().equalsIgnoreCase("a")) {
            if (this.supplierItemList[0][0] != null) {
                int j = 0;

                //Searches for the position of the target if it is in the purchasable items list
                //Or runs till the end of the array or if the next position is null
                while ((!(this.supplierItemList[j][0].equalsIgnoreCase(item))) && (j < this.supplierItemList.length - 1) && (this.supplierItemList[j + 1][0] != null)) {
                    j++;
                }

                if (this.supplierItemList[j][0].equalsIgnoreCase(item)) {
                    String[][] temp = new String[this.supplierItemList.length][2];
                    int l = 0;

                    //Copies from after the target in the original array into a temporary array
                    //If the position is not in the first position which is 0
                    //Subtract the position from the length to loop the exact amount
                    if (j > 0) {
                        for (int k = j + 1; k <= i - l; k++) {
                            temp[l] = Arrays.copyOf(this.supplierItemList[k], 2);
                            l++;
                        }
                    } else {
                        //If the position is in the first position which is 0
                        //Subtract 1 from the length to loop the exact amount
                        for (int k = j + 1; k <= i - j; k++) {
                            temp[l] = Arrays.copyOf(this.supplierItemList[k], 2);
                            l++;
                        }
                    }

                    int k = j;

                    //Copies the contents of the temporary array back into the original from the position of the target go up
                    for (l = 0; l < temp.length - j; l++) {
                        this.supplierItemList[k] = Arrays.copyOf(temp[l], 2);
                        k++;
                    }
                    i--;
                } else {
                    System.out.println(item.toUpperCase() + " doesn't exist.\n");
                }
            }
            else {
                System.out.println("No items that can be purchased have been added.\n");
            }
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void printPurchasableItems() {
        int j = 0;

        //Checks if the list of sellable items is null
        if (this.supplierItemList[0][0] == null) {
            System.out.println("There are no purchasable items.\n");
        }
        else {
            //Cycles through the list and prints the items and their prices
            while (this.supplierItemList[j][0] != null) {
                System.out.printf("Item %d - %s: $%.2f\n", j + 1, this.supplierItemList[j][0].toUpperCase(), Double.parseDouble(this.supplierItemList[j][1]));
                j++;
            }
        }
    }

    public void createAndPrintInvoice (String item, int quantity) {
        double invoiceTotal;
        int j = 0;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        //Checks if item is the sellable items
        //If the end of the array is found
        //If the next position contains nothing
        while ((!(this.supplierItemList[j][0].equalsIgnoreCase(item))) && (j < this.supplierItemList.length - 1) && (this.supplierItemList[j + 1][0] != null)) {
            j++;
        }

        //If the item was found
        //Check if the user is an admin
        //Check if the stock list has the item in it
        //Otherwise print the corresponding error
        if (this.supplierItemList[j][0].equalsIgnoreCase(item)) {
            if(User.getUserType().equalsIgnoreCase("a")) {
                if (User.checkIfBeerInStock(item)) {
                    this.invoiceNumber += 1;
                    invoiceTotal = Double.parseDouble(this.supplierItemList[j][1]) * quantity;

                    User.setWallet(User.getWallet() - invoiceTotal);

                    //Add to the amount of stock owned
                    User.addQuantityToBeerStock(item, quantity);

                    System.out.printf(
                            """
                                    Invoice Number: %d
                                    Date: %s
                                    Supplier: %s

                                    Item: %s
                                    Price: $%.2f
                                    Quantity: %d
                                    Total: $%.2f
                                    """,
                            this.invoiceNumber, formatter.format(date), this.supplierName, item.toUpperCase(), Double.parseDouble(this.supplierItemList[j][1]), quantity, invoiceTotal);
                }
                else if (User.checkIfSpiritInStock(item)) {
                    this.invoiceNumber += 1;
                    invoiceTotal = Double.parseDouble(this.supplierItemList[j][1]) * quantity;

                    User.setWallet(User.getWallet() - invoiceTotal);

                    //Add to the amount of stock owned
                    User.addQuantityToSpiritStock(item, quantity);

                    System.out.printf(
                            """
                                    Invoice Number: %d
                                    Date: %s
                                    Supplier: %s

                                    Item: %s
                                    Price: $%.2f
                                    Quantity: %d
                                    Total: $%.2f
                                    """,
                            this.invoiceNumber, formatter.format(date), this.supplierName, item.toUpperCase(), Double.parseDouble(this.supplierItemList[j][1]), quantity, invoiceTotal);
                }
                else if (User.checkIfJuiceInStock(item)) {
                    this.invoiceNumber += 1;
                    invoiceTotal = Double.parseDouble(this.supplierItemList[j][1]) * quantity;

                    User.setWallet(User.getWallet() - invoiceTotal);

                    //Add to the amount of stock owned
                    User.addQuantityToJuiceStock(item, quantity);

                    System.out.printf(
                            """
                                    Invoice Number: %d
                                    Date: %s
                                    Supplier: %s

                                    Item: %s
                                    Price: $%.2f
                                    Quantity: %d
                                    Total: $%.2f
                                    """,
                            this.invoiceNumber, formatter.format(date), this.supplierName, item.toUpperCase(), Double.parseDouble(this.supplierItemList[j][1]), quantity, invoiceTotal);
                }
                else if (User.checkIfSodaInStock(item)) {
                    this.invoiceNumber += 1;
                    invoiceTotal = Double.parseDouble(this.supplierItemList[j][1]) * quantity;

                    User.setWallet(User.getWallet() - invoiceTotal);

                    //Add to the amount of stock owned
                    User.addQuantityToSodaStock(item, quantity);

                    System.out.printf(
                            """
                                    Invoice Number: %d
                                    Date: %s
                                    Supplier: %s

                                    Item: %s
                                    Price: $%.2f
                                    Quantity: %d
                                    Total: $%.2f
                                    """,
                            this.invoiceNumber, formatter.format(date), this.supplierName, item.toUpperCase(), Double.parseDouble(this.supplierItemList[j][1]), quantity, invoiceTotal);
                }
                else if (User.checkIfWaterInStock(item)) {
                    this.invoiceNumber += 1;
                    invoiceTotal = Double.parseDouble(this.supplierItemList[j][1]) * quantity;

                    User.setWallet(User.getWallet() - invoiceTotal);

                    //Add to the amount of stock owned
                    User.addQuantityToWaterStock(item, quantity);

                    System.out.printf(
                            """
                                    Invoice Number: %d
                                    Date: %s
                                    Supplier: %s

                                    Item: %s
                                    Price: $%.2f
                                    Quantity: %d
                                    Total: $%.2f
                                    """,
                            this.invoiceNumber, formatter.format(date), this.supplierName, item.toUpperCase(), Double.parseDouble(this.supplierItemList[j][1]), quantity, invoiceTotal);
                }
                else if (User.checkIfWineInStock(item)) {
                    this.invoiceNumber += 1;
                    invoiceTotal = Double.parseDouble(this.supplierItemList[j][1]) * quantity;

                    User.setWallet(User.getWallet() - invoiceTotal);

                    //Add to the amount of stock owned
                    User.addQuantityToWineStock(item, quantity);

                    System.out.printf(
                            """
                                    Invoice Number: %d
                                    Date: %s
                                    Supplier: %s

                                    Item: %s
                                    Price: $%.2f
                                    Quantity: %d
                                    Total: $%.2f
                                    """,
                            this.invoiceNumber, formatter.format(date), this.supplierName, item.toUpperCase(), Double.parseDouble(this.supplierItemList[j][1]), quantity, invoiceTotal);
                }
                else if (User.checkIfChampagneInStock(item)) {
                    this.invoiceNumber += 1;
                    invoiceTotal = Double.parseDouble(this.supplierItemList[j][1]) * quantity;

                    User.setWallet(User.getWallet() - invoiceTotal);

                    //Add to the amount of stock owned
                    User.addQuantityToChampagneStock(item, quantity);

                    System.out.printf(
                            """
                                    Invoice Number: %d
                                    Date: %s
                                    Supplier: %s

                                    Item: %s
                                    Price: $%.2f
                                    Quantity: %d
                                    Total: $%.2f
                                    """,
                            this.invoiceNumber, formatter.format(date), this.supplierName, item.toUpperCase(), Double.parseDouble(this.supplierItemList[j][1]), quantity, invoiceTotal);
                }
                else {
                    System.out.println(item.toUpperCase() + " is not in stock.\n");
                }
            }
            else {
                System.out.println("You do not have admin privileges.\n");
            }
        }
        else {
            System.out.println(item.toUpperCase() + " is not sold by " + this.supplierName + ".\n");
        }
    }

    @Override
    public String toString() {
        return 
                "Name: " + supplierName + '\n' +
                "Email: " + supplierEmail + '\n' +
                "Contact Number: " + supplierContactNumber;
    }
}
