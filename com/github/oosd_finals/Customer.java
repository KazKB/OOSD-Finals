package com.github.oosd_finals;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Customer {
    private String customerName, customerEmail, customerContactNumber;
    private String[][] purchasedItemsList = new String[10][3];
    private int salesReceiptNumber = 0, i = 0;

    public Customer() {
         this.customerName = "";
    }

    public Customer(String name, String email, String contactNumber) {
        this.customerName = name;
        this.customerEmail = email;
        this.customerContactNumber = contactNumber;
    }

    public Customer(String firstName, String lastName, String email, String contactNumber) {
        this.customerName = firstName + " " + lastName;
        this.customerEmail = email;
        this.customerContactNumber = contactNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    //Basically the constructor but as a method
    public void editCustomerInformation(String name, String email, String contactNumber) {
        this.customerName = name;
        this.customerEmail = email;
        this.customerContactNumber = contactNumber;
    }

    //Adds an item, its price and quantity to list of items purchased by the customer
    public void addPurchasedItem(String item, double price, int quantity) {
        //Temporary array that is 10 spaces bigger than original
        String[][] temp = new String[this.purchasedItemsList.length + 10][3];
        
        if (i >= this.purchasedItemsList.length) {
            //Loops through rows of the original 2d array and copies the columns to the temporary 2d array
            for (int j = 0; j < this.purchasedItemsList.length; j++) {
                    temp[j] = Arrays.copyOf(this.purchasedItemsList[j], this.purchasedItemsList[j].length);
            }
            //Resizes the original to the temporary 2d array's size
            this.purchasedItemsList = new String[temp.length][3];
            //Loops through rows of the temporary 2d array and copies the columns to the original 2d array
            for (int j = 0; j < this.purchasedItemsList.length; j++) {
                    this.purchasedItemsList[j] = Arrays.copyOf(temp[j], temp[j].length);
            }
        }
        //Adds the item, its price and quantity to the list
        //Moves to the next array position
        this.purchasedItemsList[i][0] = item;
        this.purchasedItemsList[i][1] = String.valueOf(String.format("%.2f", price));
        this.purchasedItemsList[i][2] = String.valueOf(quantity);
        i++;
    }

    //Removes and item from the purchased item list
    public void removePurchasedItem(String item, int quantity) {
         if(User.getUserType().equalsIgnoreCase("a")) {
            if (this.purchasedItemsList[0][0] != null) {
                int j = 0;

                //Searches for the position of the target if it is in the purchasable items list
                //Or runs till the end of the array or if the next position is null
                while ((!(this.purchasedItemsList[j][0].equalsIgnoreCase(item))) && (!(this.purchasedItemsList[j][2].equalsIgnoreCase(String.valueOf(quantity)))) && (j < this.purchasedItemsList.length - 1) && (this.purchasedItemsList[j + 1][0] != null)) {
                    j++;
                }

                //Adds back the subtracted quantity from stock
                if (User.checkIfBeerInStock(item)) {
                    User.addQuantityToBeerStock(item, quantity);
                    User.setWallet(User.getWallet() - Double.parseDouble(this.purchasedItemsList[j][1]) * Double.parseDouble(this.purchasedItemsList[j][2]));
                }
                else if (User.checkIfSpiritInStock(item)) {
                    User.addQuantityToSpiritStock(item, quantity);
                    User.setWallet(User.getWallet() - Double.parseDouble(this.purchasedItemsList[j][1]) * Double.parseDouble(this.purchasedItemsList[j][2]));
                }
                else if (User.checkIfJuiceInStock(item)) {
                    User.addQuantityToJuiceStock(item, quantity);
                    User.setWallet(User.getWallet() - Double.parseDouble(this.purchasedItemsList[j][1]) * Double.parseDouble(this.purchasedItemsList[j][2]));
                }
                else if (User.checkIfSodaInStock(item)) {
                    User.addQuantityToSodaStock(item, quantity);
                    User.setWallet(User.getWallet() - Double.parseDouble(this.purchasedItemsList[j][1]) * Double.parseDouble(this.purchasedItemsList[j][2]));
                }
                else if (User.checkIfWaterInStock(item)) {
                    User.addQuantityToWaterStock(item, quantity);
                    User.setWallet(User.getWallet() - Double.parseDouble(this.purchasedItemsList[j][1]) * Double.parseDouble(this.purchasedItemsList[j][2]));
                }
                else if (User.checkIfWineInStock(item)) {
                    User.addQuantityToWineStock(item, quantity);
                    User.setWallet(User.getWallet() - Double.parseDouble(this.purchasedItemsList[j][1]) * Double.parseDouble(this.purchasedItemsList[j][2]));
                }
                else if (User.checkIfChampagneInStock(item)) {
                    User.addQuantityToChampagneStock(item, quantity);
                    User.setWallet(User.getWallet() - Double.parseDouble(this.purchasedItemsList[j][1]) * Double.parseDouble(this.purchasedItemsList[j][2]));
                }

                if ((this.purchasedItemsList[j][0].equalsIgnoreCase(item)) && (this.purchasedItemsList[j][2].equalsIgnoreCase(String.valueOf(quantity)))) {
                    String[][] temp = new String[this.purchasedItemsList.length][3];
                    int l = 0;

                    //Copies from after the target in the original array into a temporary array
                    //If the position is not in the first position which is 0, subtract that
                    //from the length to loop the exact amount
                    if (j > 0) {
                        for (int k = j + 1; k <= i - l; k++) {
                            temp[l] = Arrays.copyOf(this.purchasedItemsList[k], 3);
                            l++;
                        }
                    } else {
                        //If the position is in the first position which is 0, subtract 1
                        //from the length to loop the exact amount
                        for (int k = j + 1; k <= i - j; k++) {
                            temp[l] = Arrays.copyOf(this.purchasedItemsList[k], 3);
                            l++;
                        }
                    }

                    int k = j;

                    //Copies the contents of the temporary array back into the original from the position of the target go up
                    for (l = 0; l < temp.length - j; l++) {
                        this.purchasedItemsList[k] = Arrays.copyOf(temp[l], 3);
                        k++;
                    }

                    i--;
                } else {
                    System.out.println(item.toUpperCase() + " hasn't been bought.\n");
                }
            }
            else {
                System.out.println("No items have been purchased.\n");
            }
        }
        else {
            System.out.println("You do not have admin privileges.\n");
        }
    }

    public void printPurchasedItems() {
        int j = 0;

        //Checks if the list of purchased items is null
        if (this.purchasedItemsList[0][0] == null) {
            System.out.println("No items have been purchased.\n");
        }
        else {
            double total;

            //Cycles through the list and prints the items, its prices and quantity, and the total
            while (this.purchasedItemsList[j][0] != null) {
                total = Double.parseDouble(this.purchasedItemsList[j][1]) * Integer.parseInt(this.purchasedItemsList[j][2]);
                System.out.printf("Item %d - %s: $%.2f * %d = $%.2f\n", j + 1, this.purchasedItemsList[j][0].toUpperCase(), Double.parseDouble(this.purchasedItemsList[j][1]), Integer.parseInt(this.purchasedItemsList[j][2]), total);
                j++;
            }
        }
    }

    public void createAndPrintSalesReceipt (String item, int quantity) {
        double salesReceiptTotal;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        //Checks if item is in stock
        if (User.checkIfBeerInStock(item)) {
            this.salesReceiptNumber += 1;

            //Removes from the amount owned
            //Adds item to the purchased item list
            User.removeQuantityFromBeerStock(item, quantity);
            addPurchasedItem(item, User.getBeerStock(item).getItemPrice(), quantity);
            salesReceiptTotal = Double.parseDouble(this.purchasedItemsList[i - 1][1]) * quantity;

            User.setWallet(User.getWallet() + salesReceiptTotal);

            System.out.printf(
                    """
                    Sales Receipt: %d
                    Date: %s
                    Customer: %s

                    Item: %s
                    Price: $%.2f
                    Quantity: %d
                    Total: $%.2f
                    """,
                    this.salesReceiptNumber, formatter.format(date), this.customerName, item.toUpperCase(), Double.parseDouble(this.purchasedItemsList[i - 1][1]), quantity, salesReceiptTotal);
        }
        else if (User.checkIfSpiritInStock(item)) {
            this.salesReceiptNumber += 1;

            //Removes from the amount owned
            //Adds item to the purchased item list
            User.removeQuantityFromSpiritStock(item, quantity);
            addPurchasedItem(item, User.getSpiritStock(item).getItemPrice(), quantity);
            salesReceiptTotal = Double.parseDouble(this.purchasedItemsList[i - 1][1]) * quantity;

            User.setWallet(User.getWallet() + salesReceiptTotal);

            System.out.printf(
                    """
                    Sales Receipt: %d
                    Date: %s
                    Customer: %s

                    Item: %s
                    Price: $%.2f
                    Quantity: %d
                    Total: $%.2f
                    """,
                    this.salesReceiptNumber, formatter.format(date), this.customerName, item.toUpperCase(), Double.parseDouble(this.purchasedItemsList[i - 1][1]), quantity, salesReceiptTotal);
        }
        else if (User.checkIfJuiceInStock(item)) {
            this.salesReceiptNumber += 1;

            //Removes from the amount owned
            //Adds item to the purchased item list
            User.removeQuantityFromJuiceStock(item, quantity);
            addPurchasedItem(item, User.getJuiceStock(item).getItemPrice(), quantity);
            salesReceiptTotal = Double.parseDouble(this.purchasedItemsList[i - 1][1]) * quantity;

            User.setWallet(User.getWallet() + salesReceiptTotal);

            System.out.printf(
                    """
                    Sales Receipt: %d
                    Date: %s
                    Customer: %s

                    Item: %s
                    Price: $%.2f
                    Quantity: %d
                    Total: $%.2f
                    """,
                    this.salesReceiptNumber, formatter.format(date), this.customerName, item.toUpperCase(), Double.parseDouble(this.purchasedItemsList[i - 1][1]), quantity, salesReceiptTotal);
        }
        else if (User.checkIfSodaInStock(item)) {
            this.salesReceiptNumber += 1;

            //Removes from the amount owned
            //Adds item to the purchased item list
            User.removeQuantityFromSodaStock(item, quantity);
            addPurchasedItem(item, User.getSodaStock(item).getItemPrice(), quantity);
            salesReceiptTotal = Double.parseDouble(this.purchasedItemsList[i - 1][1]) * quantity;

            User.setWallet(User.getWallet() + salesReceiptTotal);

            System.out.printf(
                    """
                    Sales Receipt: %d
                    Date: %s
                    Customer: %s

                    Item: %s
                    Price: $%.2f
                    Quantity: %d
                    Total: $%.2f
                    """,
                    this.salesReceiptNumber, formatter.format(date), this.customerName, item.toUpperCase(), Double.parseDouble(this.purchasedItemsList[i - 1][1]), quantity, salesReceiptTotal);
        }
        else if (User.checkIfWaterInStock(item)) {
            this.salesReceiptNumber += 1;

            //Removes from the amount owned
            //Adds item to the purchased item list
            User.removeQuantityFromWaterStock(item, quantity);
            addPurchasedItem(item, User.getWaterStock(item).getItemPrice(), quantity);
            salesReceiptTotal = Double.parseDouble(this.purchasedItemsList[i - 1][1]) * quantity;

            User.setWallet(User.getWallet() + salesReceiptTotal);

            System.out.printf(
                    """
                    Sales Receipt: %d
                    Date: %s
                    Customer: %s

                    Item: %s
                    Price: $%.2f
                    Quantity: %d
                    Total: $%.2f
                    """,
                    this.salesReceiptNumber, formatter.format(date), this.customerName, item.toUpperCase(), Double.parseDouble(this.purchasedItemsList[i - 1][1]), quantity, salesReceiptTotal);
        }
        else if (User.checkIfWineInStock(item)) {
            this.salesReceiptNumber += 1;

            //Removes from the amount owned
            //Adds item to the purchased item list
            User.removeQuantityFromWineStock(item, quantity);
            addPurchasedItem(item, User.getWineStock(item).getItemPrice(), quantity);
            salesReceiptTotal = Double.parseDouble(this.purchasedItemsList[i - 1][1]) * quantity;

            User.setWallet(User.getWallet() + salesReceiptTotal);

            System.out.printf(
                    """
                    Sales Receipt: %d
                    Date: %s
                    Customer: %s

                    Item: %s
                    Price: $%.2f
                    Quantity: %d
                    Total: $%.2f
                    """,
                    this.salesReceiptNumber, formatter.format(date), this.customerName, item.toUpperCase(), Double.parseDouble(this.purchasedItemsList[i - 1][1]), quantity, salesReceiptTotal);
        }
        else if (User.checkIfChampagneInStock(item)) {
            this.salesReceiptNumber += 1;

            //Removes from the amount owned
            //Adds item to the purchased item list
            User.removeQuantityFromChampagneStock(item, quantity);
            addPurchasedItem(item, User.getChampagneStock(item).getItemPrice(), quantity);
            salesReceiptTotal = Double.parseDouble(this.purchasedItemsList[i - 1][1]) * quantity;

            User.setWallet(User.getWallet() + salesReceiptTotal);

            System.out.printf(
                    """
                    Sales Receipt: %d
                    Date: %s
                    Customer: %s

                    Item: %s
                    Price: $%.2f
                    Quantity: %d
                    Total: $%.2f
                    """,
                    this.salesReceiptNumber, formatter.format(date), this.customerName, item.toUpperCase(), Double.parseDouble(this.purchasedItemsList[i - 1][1]), quantity, salesReceiptTotal);
        }
        else {
            System.out.println(item.toUpperCase() + " is not in stock.\n");
        }
    }
}
