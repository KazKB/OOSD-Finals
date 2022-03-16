package com.github.oosd_finals;

import java.util.Scanner;

public class TestDriver {
    public static Scanner ansScanner = new Scanner(System.in);
    public static boolean answer = false;
    public static String ans = "";

    static void entry() {
        do {
            System.out.print("Do want to sign-up(s) or login(l): ");
            ans = String.valueOf(ansScanner.next().charAt(0));
        } while (!((ans.equalsIgnoreCase("s")) || (ans.equalsIgnoreCase("l"))));
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
            entry();

            exit();
        } while (answer);
    }
}
