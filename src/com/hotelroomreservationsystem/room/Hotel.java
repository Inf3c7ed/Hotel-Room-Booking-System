package com.hotelroomreservationsystem.room;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private static double totalIncome;
    private static double totalCancellationFees;

    public static List<Room> rooms = new ArrayList<>();

    @Override
    public String toString() {
        return rooms.toString();
    }

    public static void showAvailableRooms(){
        int cnt = 0;
        for (var element :
                rooms) {
            if (element.isAvailable()){
                System.out.println(
                        "  Room number: " + element.getRoomNumber() + "\n" +
                        "  Room type: " + element.getRoomType() + "\n" +
                        "  Price per night: $" + element.getPricePerNight() + "\n" +
                        "  Cancellation fee: $" + element.getCancellationFee() + "\n" +
                        "  Bed type: " + element.getBedType() + "\n" +
                        "  Maximum occupancy: " + element.getMaximumOccupancy() + "\n\n");
            }
        }
    }

    public static double getTotalIncome() {
        return totalIncome;
    }

    public static double getTotalCancellationFees() {
        return totalCancellationFees;
    }

    public static void bookRoom(int roomNumber, int nightNumber){
        for (var element :
                rooms) {
            if (element.getRoomNumber() == roomNumber && element.isAvailable()) {
                element.setAvailable(false);
                System.out.println("You successfully booked room number " + element.getRoomNumber() +
                        ". Your room ID is: " + element.getId() + "\n");
                totalIncome += element.getPricePerNight() * nightNumber;
                element.setBookedNights(nightNumber);
                break;
            }
            else if(!element.isAvailable()){
                System.out.println("\n Room has already been booked. Please choose another one \n");
            }
        }
    }

    public static void showBookedRooms(){
        int cnt = 0;
        System.out.println("Booked Rooms: \n");
        for (var element :
                rooms) {
            if (!element.isAvailable()){
                System.out.println(
                        "  Room number: " + element.getRoomNumber() + "\n" +
                        "  Room type: " + element.getRoomType() + "\n" +
                        "  Price per night: $" + element.getPricePerNight() + "\n" +
                        "  Cancellation fee: $" + element.getCancellationFee() + "\n" +
                        "  Bed type: " + element.getBedType() + "\n" +
                        "  Maximum occupancy: " + element.getMaximumOccupancy() + "\n\n");
            }
        }
    }

    public static void cancelBooking(int roomNumber){
        System.out.println("");
        for (var element :
                rooms) {
            if (element.getRoomNumber() == roomNumber) {
                element.setAvailable(true);
                System.out.println("You successfully cancelled booking for room number " + element.getRoomNumber() + "\n");
                totalCancellationFees += element.getCancellationFee();
                totalIncome -= element.getPricePerNight() * element.getBookedNights();
                element.setBookedNights(0);
                break;
            }
        }
    }
}
