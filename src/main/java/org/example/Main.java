package org.example;

import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static String[] guests = new String[10];

    public static void main(String[] args) {

        do {
            displayGuest();
            displayMenu();
            int option = getOption();
            if (option == 0) {
                insertTestName();
            } else if (option == 1) {
                addGuest();
            } else if (option == 2) {
                insertGuest();
            } else if (option == 3) {
                renameGuest();
            } else if (option == 4) {
                removeGuest();
            } else if (option == 5) {
                System.out.println("...exiting");
                break;
            } else {
                System.out.printf("Error: '%d' as an option is not valid.%n", option);
            }
        } while (true);

    }

    static void displayGuest() {
        System.out.println("\n--- GUESTS ---");
        boolean isEmpty = true;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                System.out.println((i + 1) + "." + " " + guests[i]);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("Guest list is empty.");
        }
    }

    static void displayMenu() {
        System.out.println("\n");
        System.out.println("--- MENU ---");
        System.out.println("0 - Insert test names");
        System.out.println("1 - Add guest");
        System.out.println("2 - Insert guest");
        System.out.println("3 - Rename guest");
        System.out.println("4 - Delete guest");
        System.out.println("5 - Exit program");
        System.out.println("\n");
    }

    static int getOption() {
        System.out.println("Choose an option: ");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println("\n");
        return option;
    }

    static void addGuest() {
        System.out.println("--- ADD GUEST ---");
        int guestCount = 0;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                guestCount++;
            }
        }
        if (guestCount < 10) {
            for (int i = 0; i < guests.length; i++) {
                if (guests[i] == null) {
                    System.out.print("Enter guest name: ");
                    guests[i] = sc.nextLine();
                    break;
                }
            }
        } else {
            System.out.println("Guest list is full.");
        }
    }

    static void insertGuest() {
        System.out.println("Enter the number where you want to insert your guest: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the new name: ");
        String newName = sc.nextLine();
        for (int i = guests.length - 1; i > number - 1; i--) {
            guests[i] = guests[i - 1];
        }
        guests[number - 1] = newName;
    }

    static void renameGuest() {
        System.out.println("Enter the number of the guest you want to rename: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the new name: ");
        String newName = sc.nextLine();
        guests[number - 1] = newName;
    }

    static void removeGuest() {
        System.out.println("--- REMOVE GUEST ---");
        System.out.println("Enter guest number to be removed: ");
        //System.out.println("Enter guest name to be removed: ");
        // String name sc.next();
        int rmChoice = sc.nextInt();
        if (rmChoice - 1 >= 0 && rmChoice - 1 <= 9) {
            for (int i = 0; i < guests.length; i++) {
                //          if (guests[i] != null && guests[i].equals(name)) {
                if (guests[i] != null) {
                    guests[rmChoice - 1] = null;
                    break;
                }
            }
        } else {
            System.out.println("ERROR: Guest number must be between 1-10");
        }
        // reorder array
        String[] tempArr = new String[guests.length];
        int tmpIndex = 0;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                tempArr[tmpIndex] = guests[i];
                tmpIndex++;
            }
        }
        guests = tempArr;
    }

    static void insertTestName() {
        guests[0] = "Tom";
        guests[1] = "Laura";
        guests[2] = "Jerry";
        guests[3] = "Patty";
        guests[4] = "Sam";
    }

}