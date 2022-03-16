package com.github.oosd_finals;

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

    static void entry() {
        String[] signInCredentials = new String[6];
        if (ans.equalsIgnoreCase("s")) {
            System.out.print("Enter your first name: ");
            signInCredentials[0] = ansScanner.next();
            System.out.print("Enter your last name: ");
            signInCredentials[1] = ansScanner.next();
            System.out.print("Enter your email: ");
            signInCredentials[2] = ansScanner.next();
            do {
                System.out.print("Enter your account type (admin/regular): ");
                signInCredentials[3] = ansScanner.next();
            } while (!((signInCredentials[3].equalsIgnoreCase("admin")) || (signInCredentials[3].equalsIgnoreCase("regular"))));
            System.out.print("Enter your ID: ");
            signInCredentials[4] = ansScanner.next();
            do {
                System.out.print("Enter your password (at least 8 characters: ");
                signInCredentials[5] = ansScanner.next();
            } while (signInCredentials[5].length() < 8);
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

    public static void main(String[] args) {
        do {
            genesis();

            entry();

            exit();
        } while (answer);
    }
}
