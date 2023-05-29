package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager {


    public Dealership getDealership() {
        Dealership Exclusive = new Dealership("Exclusive", "7511 Venetian Street", "954-638-2352");
        try {
            FileReader theFileWeWantToWorkWith = new FileReader("carlist.csv");
            BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);
            String theLine;
            while ((theLine = theFileFromTheHDD.readLine()) != null) {
                String[] linePieces = theLine.split("\\|");
                if (linePieces.length == 8) {
                    Vehicle T = new Vehicle(Integer.parseInt(linePieces[0]), Integer.parseInt(linePieces[1]), linePieces[2], linePieces[3], linePieces[4], linePieces[5], Integer.parseInt(linePieces[6]), Double.parseDouble(linePieces[7]));
                    Exclusive.addVehicle(T);
                }
            }
            theFileFromTheHDD.close();

        } catch (IOException e) {
            e.getMessage();
        }
        return Exclusive;
    }

    public void saveDealership(Dealership Exculsive) {

        try {
            // This line reads in the CSV file
            BufferedWriter theFile = new BufferedWriter(new FileWriter("carlist.csv", true));
            Scanner scan = new Scanner(System.in);

            System.out.println("PLEASE ENTER VEHICLE VIN NUMBER");
            int vinNum = scan.nextInt();
            System.out.println("PLEASE ENTER VEHICLE YEAR");
            int yearDate = scan.nextInt();
            scan.nextLine();
            System.out.println("PLEASE ENTER VEHICLE MAKE");
            String make = scan.nextLine();
            System.out.println("PLEASE ENTER VEHICLE MODEL");
            String model = scan.nextLine();
            System.out.println("PLEASE ENTER VEHICLE TYPE");
            String type = scan.nextLine();
            System.out.println("PLEASE ENTER VEHICLE COLOR");
            String color = scan.nextLine();
            System.out.println("PLEASE ENTER VEHICLE MILEAGE AMOUNT");
            int mileNum = scan.nextInt();
            System.out.println("PLEASE ENTER VEHICLE PRICE");
            double price = scan.nextDouble();
            Vehicle motor = new Vehicle(vinNum, yearDate, make, model, type, color, mileNum, price); // Creating a constructor
            Exculsive.addVehicle(motor);
            String word = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n", motor.getVin(), motor.getYear(), motor.getMake(), motor.getModel(), motor.getVehicleType(),
                    motor.getColor(), motor.getOdometer(), motor.getPrice());
            theFile.write(word);
            theFile.close();
        } catch (IOException E) {
            E.getMessage();
        }


    }


    public void removeitem(Dealership E){
        // This line reads in the CSV file
      try {
          BufferedWriter theFile = new BufferedWriter(new FileWriter("carlist.csv", false));
          Scanner scan = new Scanner(System.in);

          System.out.println("Please enter the vin number of the Vehicle you would like to remove");
          int num4= scan.nextInt();
          E.removeVehicle(num4);
          for(Vehicle hey : E.getAllVehicles()){
            String newFile = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n", hey.getVin(), hey.getYear(), hey.getMake(), hey.getModel(), hey.getVehicleType(),
                    hey.getColor(), hey.getOdometer(), hey.getPrice());
              theFile.write(newFile);
          }
          theFile.close();

      }
      catch(IOException l){
          l.getMessage();
      }

    }
}

// remove from the arraylist
// clear out the file
//rewrite everthing to the file.