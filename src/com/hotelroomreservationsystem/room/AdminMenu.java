package com.hotelroomreservationsystem.room;

import java.util.Scanner;

public class AdminMenu {

    public static void adminMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {                        // Admin menu after check for password
            System.out.println("\n");
            System.out.println("1.View all bookings");
            System.out.println("2.View total income and total cancellation fees");
            System.out.println("3. Back to Main Menu");
            int adminCommand = Integer.parseInt(scanner.nextLine());
            if (adminCommand == 3) {
                break;
            }

            switch (adminCommand) {

                case 1:
                    Hotel.showBookedRooms();
                    while (true) {                                        // Available Rooms Menu
                        System.out.println();
                        System.out.println("1.Go To Main Menu");

                        if (Integer.parseInt(scanner.nextLine()) == 1) {
                            break;
                        } else {
                            System.out.println("Wrong command. Please try again");
                        }

                    }

                    break;

                case 2:
                    System.out.println("Total income: $" + Hotel.getTotalIncome());
                    System.out.println("Total cancellation fees: $" + Hotel.getTotalCancellationFees());
                    while (true) {                                        // Available Rooms Menu
                        System.out.println();
                        System.out.println("1.Go To Main Menu");

                        if (Integer.parseInt(scanner.nextLine()) == 1) {
                            break;
                        } else {
                            System.out.println("Wrong command. Please try again");
                        }
                    }
                    break;
            }
        }
    }
}