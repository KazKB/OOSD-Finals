package com.github.oosd_finals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestDriver {
    public static Scanner ansScanner = new Scanner(System.in);
    public static boolean answer = false;
    public static String ans = "";
    public static int choice = 0;
    public static File userFile = new File("user.txt");
    public static User user;

    static void genesis() throws IOException {
        do {
            System.out.print("Do want to sign-up(s) or login(l): ");
            ans = String.valueOf(ansScanner.next().charAt(0));
        } while (!((ans.equalsIgnoreCase("s")) || (ans.equalsIgnoreCase("l"))));

        System.out.println();

        switch (ans.toLowerCase()) {
            case "l" -> entryLogIn();
            case "s" -> entrySignIn();
        }
    }

    static void entrySignIn() throws IOException {
        String[] signInCredentials = new String[6];
        Scanner fileReader = new Scanner(userFile);
        fileReader.useDelimiter("[\n,]");
        FileWriter writer = new FileWriter(userFile, true);

        userFile.createNewFile();

        System.out.print("Enter your first name: ");
        signInCredentials[0] = ansScanner.next().trim();
        System.out.print("Enter your last name: ");
        signInCredentials[1] = ansScanner.next().trim();
        System.out.print("Enter your email: ");
        signInCredentials[2] = ansScanner.next().trim();

        do {
            System.out.print("Enter your account type (admin/regular): ");
            signInCredentials[3] = String.valueOf(ansScanner.next().charAt(0));
        } while (!((signInCredentials[3].equalsIgnoreCase("a")) || (signInCredentials[3].equalsIgnoreCase("r"))));
        System.out.print("Enter your ID: ");
        signInCredentials[4] = ansScanner.next().trim();

        do {
            System.out.print("Enter your password (at least 8 characters: ");
            signInCredentials[5] = ansScanner.next().trim();
        } while (signInCredentials[5].length() < 8);


        if (userFile.length() > 0) {
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
        Scanner fileReader = new Scanner(userFile);
        fileReader.useDelimiter("[\n,]");

        userFile.createNewFile();

        if (userFile.length() == 0) {
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

                    if ((loginCredentials[4].equals(login[0])) && (loginCredentials[5].equals(login[1]))) {
                        user = new User(loginCredentials[3], loginCredentials[4]);
                        System.out.println();
                        menuSelection();
                    }
                    else if (!(fileReader.hasNext())) {
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

    static void menuSelection() throws FileNotFoundException {
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
        }
    }

    static void userMenu() throws FileNotFoundException {
        System.out.println("""
                User Menu
                What would you like to do:
                0. View User Information
                1. Add Item To Stock List
                2. Remove Item From Stock List
                3. View Stock Lists
                4. View Profit/Loss
                5. Back to Menu Selection""");
        System.out.print("Enter number: ");
        choice = ansScanner.nextInt();

        Scanner fileReader = new Scanner(userFile);
        fileReader.useDelimiter("[\n,]");
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

                String[] stockInfo = new String[3];
                double stockPrice;
                String stockCategory;

                System.out.print("Enter item's name: ");
                stockInfo[0] = ansScanner.next().trim();
                System.out.print("Enter item's description: ");
                stockInfo[1] = ansScanner.next().trim();
                System.out.print("Enter item's id: ");
                stockInfo[2] = ansScanner.next().trim();

                do {
                    System.out.print("Enter item's price: $");
                    stockPrice = ansScanner.nextDouble();
                } while (stockPrice == 0.0);

                do {
                    System.out.print("Enter item's category (beer, champagne, juice, soda, spirit, water, wine): ");
                    stockCategory = ansScanner.next().trim();
                } while (!((stockCategory.equalsIgnoreCase("beer")) || (stockCategory.equalsIgnoreCase("champagne")) || (stockCategory.equalsIgnoreCase("juice")) || (stockCategory.equalsIgnoreCase("soda")) || (stockCategory.equalsIgnoreCase("spirit")) || (stockCategory.equalsIgnoreCase("water")) || (stockCategory.equalsIgnoreCase("wine"))));


                if (stockCategory.equalsIgnoreCase("beer")) {
                    if (user.checkIfBeerInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    }
                    else {
                        user.addToStockList(new Beer(stockInfo[0], stockInfo[1], stockInfo[2], stockPrice, user));
                        System.out.println();
                    }
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("spirit")) {
                    if (user.checkIfSpiritInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    }
                    else {
                        user.addToStockList(new Spirit(stockInfo[0], stockInfo[1], stockInfo[2], stockPrice, user));
                        System.out.println();
                    }
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("juice")) {
                    if (user.checkIfJuiceInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    }
                    else {
                        user.addToStockList(new Juice(stockInfo[0], stockInfo[1], stockInfo[2], stockPrice, user));
                        System.out.println();
                    }
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("soda")) {
                    if (user.checkIfSodaInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    }
                    else {
                        user.addToStockList(new Soda(stockInfo[0], stockInfo[1], stockInfo[2], stockPrice, user));
                        System.out.println();
                    }
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("water")) {
                    if (user.checkIfWaterInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    }
                    else {
                        user.addToStockList(new Water(stockInfo[0], stockInfo[1], stockInfo[2], stockPrice, user));
                        System.out.println();
                    }
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("wine")) {
                    if (user.checkIfWineInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    }
                    else {
                        user.addToStockList(new Wine(stockInfo[0], stockInfo[1], stockInfo[2], stockPrice, user));
                        System.out.println();
                    }
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("champagne")) {
                    if (user.checkIfChampagneInStock(stockInfo[0])) {
                        System.out.println("Already in stock.\n");
                    }
                    else {
                        user.addToStockList(new Champagne(stockInfo[0], stockInfo[1], stockInfo[2], stockPrice, user));
                        System.out.println();
                    }
                    userMenu();
                }
            case 2:
                System.out.println();

                String[] stockInformation = new String[2];

                System.out.print("Enter the item's name: ");
                stockInformation[0] = ansScanner.next().trim();

                do {
                    System.out.print("Enter item's category (beer, champagne, juice, soda, spirit, water, wine): ");
                    stockCategory = ansScanner.next().trim();
                } while (!((stockCategory.equalsIgnoreCase("beer")) || (stockCategory.equalsIgnoreCase("champagne")) || (stockCategory.equalsIgnoreCase("juice")) || (stockCategory.equalsIgnoreCase("soda")) || (stockCategory.equalsIgnoreCase("spirit")) || (stockCategory.equalsIgnoreCase("water")) || (stockCategory.equalsIgnoreCase("wine"))));

                if (stockInformation[1].equalsIgnoreCase("beer")) {
                    if (user.checkIfBeerInStock(stockInformation[0])) {
                        user.removeFromBeerList(stockInformation[0]);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    userMenu();
                }
                else if (stockInformation[1].equalsIgnoreCase("spirit")) {
                    if (user.checkIfSpiritInStock(stockInformation[0])) {
                        user.removeFromSpiritList(stockInformation[0]);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    userMenu();
                }
                else if (stockInformation[1].equalsIgnoreCase("juice")) {
                    if (user.checkIfJuiceInStock(stockInformation[0])) {
                        user.removeFromJuiceList(stockInformation[0]);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    userMenu();
                }
                else if (stockInformation[1].equalsIgnoreCase("soda")) {
                    if (user.checkIfSodaInStock(stockInformation[0])) {
                        user.removeFromSodaList(stockInformation[0]);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    userMenu();
                }
                else if (stockInformation[1].equalsIgnoreCase("water")) {
                    if (user.checkIfWaterInStock(stockInformation[0])) {
                        user.removeFromWaterList(stockInformation[0]);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    userMenu();
                }
                else if (stockInformation[1].equalsIgnoreCase("wine")) {
                    if (user.checkIfWineInStock(stockInformation[0])) {
                        user.removeFromWineList(stockInformation[0]);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    userMenu();
                }
                else if (stockInformation[1].equalsIgnoreCase("champagne")) {
                    if (user.checkIfChampagneInStock(stockInformation[0])) {
                        user.removeFromChampagneList(stockInformation[0]);
                    } else {
                        System.out.println("Not in stock");
                    }
                    System.out.println();
                    userMenu();
                }
            case 3:
                System.out.println();

                do {
                    System.out.print("Enter list category (beer, champagne, juice, soda, spirit, water, wine): ");
                    stockCategory = ansScanner.next().trim();
                } while (!((stockCategory.equalsIgnoreCase("beer")) || (stockCategory.equalsIgnoreCase("champagne")) || (stockCategory.equalsIgnoreCase("juice")) || (stockCategory.equalsIgnoreCase("soda")) || (stockCategory.equalsIgnoreCase("spirit")) || (stockCategory.equalsIgnoreCase("water")) || (stockCategory.equalsIgnoreCase("wine"))));

                if (stockCategory.equalsIgnoreCase("beer")) {
                    user.viewBeerList();
                    System.out.println();
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("spirit")) {
                    user.viewSpiritList();
                    System.out.println();
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("juice")) {
                    user.viewJuiceList();
                    System.out.println();
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("soda")) {
                    user.viewSodaList();
                    System.out.println();
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("water")) {
                    user.viewWaterList();
                    System.out.println();
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("wine")) {
                    user.viewWineList();
                    System.out.println();
                    userMenu();
                }
                else if (stockCategory.equalsIgnoreCase("champagne")) {
                    user.viewChampagneList();
                    System.out.println();
                    userMenu();
                }
            case 4:
                System.out.println();
                System.out.println(user.printProfitAndLoss());
                System.out.println();
                menuSelection();
            case 5:
                System.out.println();
                menuSelection();
        }
    }

    static void stockMenu() {}

    static void supplierMenu() {}

    static void customerMenu() {}

    static void exit() {

        System.out.print("Do you want to re-login or sign-up (y/n): ");
        ans = ansScanner.next();

        if ((ans.equalsIgnoreCase("y"))) {
            answer = true;
        }
        else if (ans.equalsIgnoreCase("n")) {
            System.exit(0);
        }
        else {
            System.out.println("Enter a y or n please.");
            exit();
        }
    }

    public static void main(String[] args) throws IOException {
        do {
            genesis();
        } while (answer);
    }
}
