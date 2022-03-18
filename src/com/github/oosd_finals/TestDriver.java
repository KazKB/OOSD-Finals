package com.github.oosd_finals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestDriver {
    public static Scanner ansScanner = new Scanner(System.in);
    public static boolean answer = false;
    public static String ans = "";

    static void genesis() {
        do {
            System.out.print("Do want to sign-up(s) or login(l): ");
            ans = String.valueOf(ansScanner.next().charAt(0));
        } while (!((ans.equalsIgnoreCase("s")) || (ans.equalsIgnoreCase("l"))));
    }

    static void entrySignIn() throws IOException {
        String[] signInCredentials = new String[6];
        File user = new File("user.txt");

        user.createNewFile();
        Scanner fileReader = new Scanner(user);
        fileReader.useDelimiter("\r\n|,");
        FileWriter writer = new FileWriter(user, true);

        if (ans.equalsIgnoreCase("s")) {
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


            if (user.length() > 0) {
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
        }
    }

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
            System.out.println();

            entrySignIn();
            System.out.println();

            exit();
        } while (answer);
    }
}
