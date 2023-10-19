import com.hotelroomreservationsystem.room.AdminMenu;
import com.hotelroomreservationsystem.room.CSV;
import com.hotelroomreservationsystem.room.Hotel;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String adminPassword = "123admin";

        CSV.fillCSV();
        CSV.fillCSVFinance();

        while(true){                                                      // Main Menu

            System.out.println("1.View Available Rooms");
            System.out.println("2.Book a Room");
            System.out.println("3.Cancel Booking");
            System.out.println("4.Enter Admin Mode");
            System.out.println("5.End Program");

            int command = Integer.parseInt(scanner.nextLine());

            if (command == 5){
                break;
            }

            switch(command){

                case 1:                                                 // Available Rooms Menu
                    Hotel.showAvailableRooms();
                    while(true){
                        System.out.println();
                        System.out.println("1.Go To Main Menu");

                        if (Integer.parseInt(scanner.nextLine()) == 1){
                            break;
                        }

                        else{
                            System.out.println("Wrong command. Please try again");
                        }
                    }
                     break;

                case 2:                                               // Book a room

                    System.out.print("Please enter the numbers of nights you want to book: ");
                    int nightNumber = Integer.parseInt(scanner.nextLine());
                    Hotel.showAvailableRooms();
                    System.out.print("Please write the room number you want to book: ");
                    int roomNumber = Integer.parseInt(scanner.nextLine());
                    Hotel.bookRoom(roomNumber, nightNumber);
                    break;

                case 3:                                              // Cancel a reservation
                    System.out.println("\n");
                    Hotel.showBookedRooms();
                    System.out.print("Please write the room number you would like to cancel a reservation to: ");
                    int roomNumberForCancellation = Integer.parseInt(scanner.nextLine());
                    System.out.println("");
                    Hotel.cancelBooking(roomNumberForCancellation);
                    break;

                case 4:                                             // Enter Admin Menu
                    System.out.print("Please enter admin password: ");
                    String input = scanner.nextLine().trim();
                    if (input.equals(adminPassword)){
                        AdminMenu.adminMenu();
                    }
                    break;
            }

        }

        CSV.ClearCSV();
        CSV.ClearCSVFinance();
        CSV.fillCSVWithNewData(Hotel.rooms);
        CSV.fillCSVWithNewDataFinance(Hotel.getTotalIncome(), Hotel.getTotalCancellationFees());


    }
}