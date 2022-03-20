package com.github.oosd_finals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestDriver {
    public static Scanner ansScanner = new Scanner(System.in);
    public static String ans = "";
    public static int choice = 0;
    public static File file = new File("user.txt");
    public static Scanner fileReader;
    public static User user;

    static {
        try {
            fileReader = new Scanner(file);
            fileReader.useDelimiter("[\n,]");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void genesis() throws IOException {
        do {
            System.out.print("Choose either to sign-up(s) or login(l): ");
            ans = String.valueOf(ansScanner.next().charAt(0));
        } while (!(ans.equalsIgnoreCase("s") || ans.equalsIgnoreCase("l")));

        System.out.println();

        switch (ans.toLowerCase()) {
            case "l" -> entryLogIn();
            case "s" -> entrySignIn();
        }
    }

    static void entrySignIn() throws IOException {
        String[] signInCredentials = new String[6];
        Scanner fileReader = new Scanner(file);
        fileReader.useDelimiter("[\n,]");
        FileWriter writer = new FileWriter(file, true);

        file.createNewFile();

        System.out.print("Enter your first name: ");
        signInCredentials[0] = ansScanner.next().trim();
        System.out.print("Enter your last name: ");
        signInCredentials[1] = ansScanner.next().trim();
        System.out.print("Enter your email: ");
        signInCredentials[2] = ansScanner.next().trim();

        do {
            System.out.print("Enter your account type (admin/regular): ");
            signInCredentials[3] = String.valueOf(ansScanner.next().charAt(0));
        } while (!(signInCredentials[3].equalsIgnoreCase("a") || signInCredentials[3].equalsIgnoreCase("r")));
        System.out.print("Enter your ID: ");
        signInCredentials[4] = ansScanner.next().trim();

        do {
            System.out.print("Enter your password (at least 8 characters: ");
            signInCredentials[5] = ansScanner.next().trim();
        } while (signInCredentials[5].length() < 8);


        if (file.length() > 0) {
            while (fileReader.hasNext()) {
                if (fileReader.next().equals(signInCredentials[4])) {
                    entrySignIn();
                }

                fileReader.next();
            }

            for (int i = 0; i < signInCredentials.length-1; i++) {
                writer.append(signInCredentials[i]).append(",");
            }

            writer.append(signInCredentials[5]);
        }
        else {
            for (int i = 0; i < signInCredentials.length-1; i++) {
                writer.append(signInCredentials[i]).append(",");
            }

            writer.append(signInCredentials[5]);
        }

        writer.append("\n");
        writer.close();
        System.out.println();
        user = new User(signInCredentials[3], signInCredentials[4]);
        menuSelection();
    }

    static void entryLogIn() throws IOException {
        Scanner fileReader = new Scanner(file);
        fileReader.useDelimiter("[\n,]");

        file.createNewFile();

        if (file.length() == 0) {
            entrySignIn();
        }
        else {
            String[] loginCredentials = new String[6];
            String[] login = new String[2];
            int i = 0;

            System.out.print("Enter id: ");
            login[0] = ansScanner.next().trim();
            System.out.print("Enter password: ");
            login[1] = ansScanner.next().trim();

            while (fileReader.hasNext()) {
                loginCredentials[i] = fileReader.next();
                i++;

                if (i == 6) {
                    i = 0;

                    if (loginCredentials[4].equals(login[0]) && loginCredentials[5].equals(login[1])) {
                        user = new User(loginCredentials[3], loginCredentials[4]);
                        System.out.println();
                        menuSelection();
                    }
                    else if (!fileReader.hasNext()) {
                        System.out.println();
                        System.out.print("Try again(t) or Sign-up(s): ");
                        ans = String.valueOf(ansScanner.next().charAt(0));

                        switch (ans.toLowerCase()) {
                            case "t" -> {
                                entryLogIn();
                                System.out.println();
                            }
                            case "s" -> {
                                entrySignIn();
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
    }

    static void menuSelection() throws IOException {
        System.out.println("""
                Menu Selection
                Choose the number that corresponds to where you want to go:
                0. User
                1. Stock
                2. Supplier
                3. Customer
                4. Log Out""");
        System.out.print("Enter number: ");
        choice = ansScanner.nextInt();

        switch (choice) {
            case 0:
                System.out.println();
                userMenu();
            case 1:
                System.out.println();
                stockMenu();
            case 2:
                System.out.println();
                supplierMenu();
            case 3:
                System.out.println();
                customerMenu();
            case 4:
                System.out.println();
                exit();
            default:
                System.out.println();
                menuSelection();
        }
    }

    static void userMenu() throws IOException {
        System.out.println("""
                User Menu
                What would you like to do:
                0. View User Information
                1. View Profit/Loss
                2. Back to Menu Selection""");
        System.out.print("Enter number: ");
        choice = ansScanner.nextInt();

        String[] userCredentials = new String[6];
        int i = 0;

        switch (choice) {
            case 0:
                System.out.println();

                while (fileReader.hasNext()) {
                    userCredentials[i] = fileReader.next();
                    i++;

                    if (i == 6) {
                        if (userCredentials[4].equals(user.getUserID())) {
                            System.out.println("User Information");

                            for (String s : userCredentials) {
                                System.out.println(s);
                            }

                            System.out.println();
                            userMenu();
                        } else {
                            i = 0;
                        }
                    }
                }
            case 1:
                System.out.println();
                System.out.println(user.printProfitAndLoss());
                menuSelection();
            case 2:
                System.out.println();
                menuSelection();
            default:
                System.out.println();
                userMenu();
        }
    }

    static void stockMenu() throws IOException {
        System.out.println("""
                Stock Menu
                What would you like to do:
                0. View Item Information
                1. Edit Item Price
                2. Add Item To Stock List
                3. Remove Item From Stock List
                4. View Stock Lists
                5. Back to Menu Selection""");
        System.out.print("Enter number: ");
        choice = ansScanner.nextInt();

        switch (choice) {
            case 0:
                System.out.println();
                
                String itemName;
                String itemCategory;

                System.out.print("Enter item's name: ");
                itemName = ansScanner.next().trim();

                do {
                    System.out.print("Enter item's category (beer, champagne, juice, soda, spirit, water, wine): ");
                    itemCategory = ansScanner.next().trim();
                } while (!(itemCategory.equalsIgnoreCase("beer") || itemCategory.equalsIgnoreCase("champagne") || itemCategory.equalsIgnoreCase("juice") || itemCategory.equalsIgnoreCase("soda") || itemCategory.equalsIgnoreCase("spirit") || itemCategory.equalsIgnoreCase("water") || itemCategory.equalsIgnoreCase("wine")));

                if (itemCategory.equalsIgnoreCase("beer")) {
                    if (user.checkIfBeerInStock(itemName)) {
                        System.out.println(user.getBeerStock(itemName));
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("spirit")) {
                    if (user.checkIfSpiritInStock(itemName)) {
                        System.out.println(user.getSpiritStock(itemName));
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("juice")) {
                    if (user.checkIfJuiceInStock(itemName)) {
                        System.out.println(user.getJuiceStock(itemName));
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("soda")) {
                    if (user.checkIfSodaInStock(itemName)) {
                        System.out.println(user.getSodaStock(itemName));
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("water")) {
                    if (user.checkIfWaterInStock(itemName)) {
                        System.out.println(user.getWaterStock(itemName));
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("wine")) {
                    if (user.checkIfWineInStock(itemName)) {
                        System.out.println(user.getWineStock(itemName));
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("champagne")) {
                    if (user.checkIfChampagneInStock(itemName)) {
                        System.out.println(user.getChampagneStock(itemName));
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                }
            case 1:
                System.out.println();

                double itemPrice;

                System.out.print("Enter item's name: ");
                itemName = ansScanner.next().trim();
                System.out.print("Enter item's new price: $");
                itemPrice = ansScanner.nextDouble();

                do {
                    System.out.print("Enter item's category (beer, champagne, juice, soda, spirit, water, wine): ");
                    itemCategory = ansScanner.next().trim();
                } while (!(itemCategory.equalsIgnoreCase("beer") || itemCategory.equalsIgnoreCase("champagne") || itemCategory.equalsIgnoreCase("juice") || itemCategory.equalsIgnoreCase("soda") || itemCategory.equalsIgnoreCase("spirit") || itemCategory.equalsIgnoreCase("water") || itemCategory.equalsIgnoreCase("wine")));

                if (itemCategory.equalsIgnoreCase("beer")) {
                    if (user.checkIfBeerInStock(itemName)) {
                        user.getBeerStock(itemName).setItemPrice(itemPrice, user);
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("spirit")) {
                    if (user.checkIfSpiritInStock(itemName)) {
                        user.getSpiritStock(itemName).setItemPrice(itemPrice, user);
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("juice")) {
                    if (user.checkIfJuiceInStock(itemName)) {
                        user.getJuiceStock(itemName).setItemPrice(itemPrice, user);
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("soda")) {
                    if (user.checkIfSodaInStock(itemName)) {
                        user.getSodaStock(itemName).setItemPrice(itemPrice, user);
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("water")) {
                    if (user.checkIfWaterInStock(itemName)) {
                        user.getWaterStock(itemName).setItemPrice(itemPrice, user);
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("wine")) {
                    if (user.checkIfWineInStock(itemName)) {
                        user.getWineStock(itemName).setItemPrice(itemPrice, user);
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("champagne")) {
                    if (user.checkIfChampagneInStock(itemName)) {
                        user.getChampagneStock(itemName).setItemPrice(itemPrice, user);
                    } else {
                        System.out.println(itemName.toUpperCase() + " doesn't exist.");
                    }
                    System.out.println();
                    stockMenu();
                }
            case 2:
                System.out.println();

                String[] stockInfo = new String[2];
                double stockPrice;

                System.out.print("Enter item's name: ");
                stockInfo[0] = ansScanner.next().trim();
                System.out.print("Enter item's id: ");
                stockInfo[1] = ansScanner.next().trim();

                do {
                    System.out.print("Enter item's price: $");
                    stockPrice = ansScanner.nextDouble();
                } while (stockPrice == 0.0);

                do {
                    System.out.print("Enter item's category (beer, champagne, juice, soda, spirit, water, wine): ");
                    itemCategory = ansScanner.next().trim();
                } while (!(itemCategory.equalsIgnoreCase("beer") || itemCategory.equalsIgnoreCase("champagne") || itemCategory.equalsIgnoreCase("juice") || itemCategory.equalsIgnoreCase("soda") || itemCategory.equalsIgnoreCase("spirit") || itemCategory.equalsIgnoreCase("water") || itemCategory.equalsIgnoreCase("wine")));


                if (itemCategory.equalsIgnoreCase("beer")) {
                    if (user.checkIfBeerInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    } else {
                        user.addToStockList(new Beer(stockInfo[0], stockInfo[1], stockPrice, user));
                        System.out.println();
                    }
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("spirit")) {
                    if (user.checkIfSpiritInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    } else {
                        user.addToStockList(new Spirit(stockInfo[0], stockInfo[1], stockPrice, user));
                        System.out.println();
                    }
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("juice")) {
                    if (user.checkIfJuiceInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    } else {
                        user.addToStockList(new Juice(stockInfo[0], stockInfo[1], stockPrice, user));
                        System.out.println();
                    }
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("soda")) {
                    if (user.checkIfSodaInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    } else {
                        user.addToStockList(new Soda(stockInfo[0], stockInfo[1], stockPrice, user));
                        System.out.println();
                    }
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("water")) {
                    if (user.checkIfWaterInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    } else {
                        user.addToStockList(new Water(stockInfo[0], stockInfo[1], stockPrice, user));
                        System.out.println();
                    }
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("wine")) {
                    if (user.checkIfWineInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    } else {
                        user.addToStockList(new Wine(stockInfo[0], stockInfo[1], stockPrice, user));
                        System.out.println();
                    }
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("champagne")) {
                    if (user.checkIfChampagneInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    } else {
                        user.addToStockList(new Champagne(stockInfo[0], stockInfo[1], stockPrice, user));
                        System.out.println();
                    }
                    stockMenu();
                }
            case 3:
                System.out.println();

                System.out.print("Enter the item's name: ");
                itemName = ansScanner.next().trim();

                do {
                    System.out.print("Enter item's category (beer, champagne, juice, soda, spirit, water, wine): ");
                    itemCategory = ansScanner.next().trim();
                } while (!(itemCategory.equalsIgnoreCase("beer") || itemCategory.equalsIgnoreCase("champagne") || itemCategory.equalsIgnoreCase("juice") || itemCategory.equalsIgnoreCase("soda") || itemCategory.equalsIgnoreCase("spirit") || itemCategory.equalsIgnoreCase("water") || itemCategory.equalsIgnoreCase("wine")));

                if (itemCategory.equalsIgnoreCase("beer")) {
                    if (user.checkIfBeerInStock(itemName)) {
                        user.removeFromBeerList(itemName);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("spirit")) {
                    if (user.checkIfSpiritInStock(itemName)) {
                        user.removeFromSpiritList(itemName);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("juice")) {
                    if (user.checkIfJuiceInStock(itemName)) {
                        user.removeFromJuiceList(itemName);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("soda")) {
                    if (user.checkIfSodaInStock(itemName)) {
                        user.removeFromSodaList(itemName);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("water")) {
                    if (user.checkIfWaterInStock(itemName)) {
                        user.removeFromWaterList(itemName);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("wine")) {
                    if (user.checkIfWineInStock(itemName)) {
                        user.removeFromWineList(itemName);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("champagne")) {
                    if (user.checkIfChampagneInStock(itemName)) {
                        user.removeFromChampagneList(itemName);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    stockMenu();
                }
            case 4:
                System.out.println();

                do {
                    System.out.print("Enter list category (beer, champagne, juice, soda, spirit, water, wine): ");
                    itemCategory = ansScanner.next().trim();
                } while (!(itemCategory.equalsIgnoreCase("beer") || itemCategory.equalsIgnoreCase("champagne") || itemCategory.equalsIgnoreCase("juice") || itemCategory.equalsIgnoreCase("soda") || itemCategory.equalsIgnoreCase("spirit") || itemCategory.equalsIgnoreCase("water") || itemCategory.equalsIgnoreCase("wine")));

                if (itemCategory.equalsIgnoreCase("beer")) {
                    user.viewBeerList();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("spirit")) {
                    user.viewSpiritList();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("juice")) {
                    user.viewJuiceList();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("soda")) {
                    user.viewSodaList();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("water")) {
                    user.viewWaterList();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("wine")) {
                    user.viewWineList();
                    stockMenu();
                } else if (itemCategory.equalsIgnoreCase("champagne")) {
                    user.viewChampagneList();
                    stockMenu();
                }
            case 5:
                System.out.println();
                menuSelection();
            default:
                System.out.println();
                stockMenu();
        }
    }

    static void supplierMenu() throws IOException {
        System.out.println("""
                Stock Menu
                What would you like to do:
                0. View Supplier Information
                1. Edit Supplier Information
                2. Add Item To Supplier's Item List
                3. Remove Item From Supplier's Item List
                4. View Supplier's Item List
                5. Buy From Supplier
                6. Back to Menu Selection""");
        System.out.print("Enter number: ");
        choice = ansScanner.nextInt();
    }

    static void customerMenu() throws IOException {}

    static void exit() throws IOException {

        System.out.print("Do you want to re-login or sign-up (y/n): ");
        ans = ansScanner.next();

        if (ans.equalsIgnoreCase("y")) {
            System.out.println();
            genesis();
        }
        else if (ans.equalsIgnoreCase("n")) {
            System.exit(0);
        }
        else {
            System.out.println("Enter a y or n please.");
            System.out.println();
            exit();
        }
    }

    public static void main(String[] args) throws IOException {
        genesis();
    }
}