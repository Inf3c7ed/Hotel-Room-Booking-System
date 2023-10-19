package com.hotelroomreservationsystem.room;

import java.io.*;
import java.util.List;

public class CSV {
    public static void ClearCSV() {

        String filePath = "src/resources/Rooms.csv";

        try {
            FileWriter writer = new FileWriter(filePath);

            writer.write("");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillCSV() {
        String line = "";
        try {                                      // reading all input from the CSV file and creating the room objects
            BufferedReader br = new BufferedReader(new FileReader("src/resources/Rooms.csv"));
            while ((line = br.readLine()) != null) {
                String[] roomProperties = line.split("\\s*,\\s*");
                Room room = new Room(Integer.parseInt(roomProperties[0]),
                        RoomType.valueOf(roomProperties[1]),
                        Double.parseDouble(roomProperties[2]),
                        Double.parseDouble(roomProperties[3]),
                        Boolean.parseBoolean(roomProperties[4]),
                        roomProperties[5],
                        Integer.parseInt(roomProperties[6]),
                        Integer.parseInt(roomProperties[7]),
                        roomProperties[8]);

                Hotel.rooms.add(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillCSVWithNewData(List<Room> rooms) {
        String filePath = "src/resources/Rooms.csv";

        try {
            FileWriter writer = new FileWriter(filePath);

            for (var room :
                    rooms) {
                writer.write(String.valueOf(room));
                writer.write("\n");
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ClearCSVFinance() {

        String filePath = "src/resources/Finances.csv";

        try {
            FileWriter writer = new FileWriter(filePath);

            writer.write("");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillCSVFinance() {
        double totalIncome;
        double totalCancellationFees;
        try {                                      // reading all input from the CSV file and creating the room objects
            BufferedReader br = new BufferedReader(new FileReader("src/resources/Finances.csv"));
            totalIncome = Double.parseDouble(br.readLine().trim());
            totalCancellationFees = Double.parseDouble(br.readLine().trim());


        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void fillCSVWithNewDataFinance(double income, double cancellations) {
        String filePath = "src/resources/Finances.csv";

        try {
            FileWriter writer = new FileWriter(filePath);

            writer.write(String.valueOf(income));
            writer.write("\n");
            writer.write(String.valueOf(cancellations));

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

