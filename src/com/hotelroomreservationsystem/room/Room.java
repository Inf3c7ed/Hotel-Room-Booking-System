package com.hotelroomreservationsystem.room;

public class Room {

    private int roomNumber;
    private RoomType roomType;
    private double pricePerNight;
    private double cancellationFee;
    private boolean isAvailable;
    private String bedType;
    private int maximumOccupancy;
    private int bookedNights;
    private String id;

    public Room(int roomNumber,
                RoomType roomType,
                double pricePerNight,
                double cancellationFee,
                boolean isAvailable,
                String bedType,
                int maximumOccupancy,
                int bookedNights,
                String id) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.cancellationFee = cancellationFee;
        this.isAvailable = isAvailable;
        this.bedType = bedType;
        this.maximumOccupancy = maximumOccupancy;
        this.bookedNights = bookedNights;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBookedNights() {
        return bookedNights;
    }

    public void setBookedNights(int bookedNights) {
        this.bookedNights = bookedNights;
    }

    @Override
    public String toString() {
        return roomNumber + "," +
                roomType + "," +
                pricePerNight + "," +
                cancellationFee + "," +
                isAvailable + "," +
                bedType + "," +
                maximumOccupancy + "," +
                bookedNights + "," +
                id;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
        roomType = RoomType.Single;

    }

    public String getBedType() {
        return bedType;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getMaximumOccupancy() {
        return maximumOccupancy;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public double getCancellationFee() {
        return cancellationFee;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom(int roomNumber){
        System.out.printf("You booked room %d %n.", roomNumber);

    }

}
