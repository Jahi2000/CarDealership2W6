package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public UserInterface(){

        init();
    }


   private void init()  {
        DealershipFileManager deal = new DealershipFileManager();
       this.dealership = deal.getDealership();
   }

   private void displayvehicles(ArrayList <Vehicle> List){
        for (Vehicle motor : List){
           System.out.println(motor.getVin() + " - " + motor.getYear() + " - " + motor.getMake() + " - " + motor.getModel() +
                   " - " + motor.getColor() + " - " +  motor.getPrice() + " - " +  motor.getOdometer());
       }
   }

    private void processAllvehiclesrequest(){
        displayvehicles(this.dealership.getAllVehicles());

    }

    public void display(){
     boolean set = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = scan.nextLine();
        System.out.println("Hey " + name + ". Welcome to the Exclusive Auto Dealership\n");

        while(set){
         System.out.println("Please choose an option\n");
         System.out.println("TYPE P TO VIEW CARLIST BY SELECTED PRICE RANGE.");
         System.out.println("TYPE M TO VIEW CARLIST BY SELECTED MAKE & MODEL RANGE.");
         System.out.println("TYPE Y TO VIEW CARLIST BY SELECTED YEAR RANGE.");
         System.out.println("TYPE C TO VIEW CARLIST BY SELECTED COLOR.");
         System.out.println("TYPE R TO VIEW CARLIST BY SELECTED MILEAGE RANGE.");
         System.out.println("TYPE V TO VIEW CARLIST BY SELECTED VEHICLE TYPE");
         System.out.println("TYPE L TO VIEW CARLIST FOR ALL VEHICLES");
         System.out.println("TYPE A TO ADD A CAR TO THE DEALERSHIP");
         System.out.println("TYPE Q TO REMOVE A CAR TO THE DEALERSHIP");
         System.out.println("TYPE S IF YOU WOULD LIKE TO SALE OR LEASE A CAR");
         System.out.println("TYPE X TO EXIT THE PROGRAM");

         String choice = scan.nextLine();

         switch (choice.toUpperCase()){
             case "P":
                 System.out.println("PLEASE ENTER THE PRICE RANGES OF THE VEHICLE");
                 System.out.println("ENTER THE MIN PRICE BELOW");
                 String minPrice  = scan.nextLine();
                 System.out.println("ENTER THE MAX PRICE BELOW");
                 String maxPrice  = scan.nextLine();
                 System.out.println();
                 displayvehicles(this.dealership.getVehiclesByPrice(Double.parseDouble(minPrice),Double.parseDouble(maxPrice)));
                 System.out.println("This is the list");
                 System.out.println();
                 break;
             case "M":
                 System.out.println("PLEASE ENTER THE MAKE AND MODEL OF THE VEHICLE");
                 System.out.println("ENTER THE MAKE BELOW");
                 String make  = scan.nextLine();
                 System.out.println("ENTER THE MODEL BELOW");
                 String model  = scan.nextLine();
                 System.out.println();
                 displayvehicles(this.dealership.getVehiclesByMakeModel(make.toUpperCase(),model.toUpperCase()));
                 System.out.println("This is the list");
                 System.out.println();
                 break;
             case "Y":
                 System.out.println("PLEASE ENTER THE MINIMUM YEAR AND THE MAXIMUM YEAR TO SEARCH FOR YEAR RANGES");
                 System.out.println("ENTER THE MINIMUM YEAR BELOW");
                 String minYEAR  = scan.nextLine();
                 System.out.println("ENTER THE MAXIMUM YEAR BELOW");
                 String maxYEAR  = scan.nextLine();
                 System.out.println();
                 displayvehicles(this.dealership.getVehiclesByYear(Integer.parseInt(minYEAR),Integer.parseInt(maxYEAR)));
                 System.out.println("This is the list");
                 System.out.println();
                 break;
             case "C":
                 System.out.println("PLEASE ENTER THE COLOR OF THE VEHICLE");
                 String color = scan.nextLine();
                 System.out.println();
                 displayvehicles(this.dealership.getVehiclesByColor(color));
                 System.out.println("This is the list");
                 System.out.println();
                 break;
             case "R":
                 System.out.println("PLEASE ENTER THE MINIMUM MILEAGE AND THE MAXIMUM MILEAGE TO SEARCH FOR RANGES");
                 System.out.println("ENTER THE MINIMUM MILEAGE BELOW");
                 String minMileage  = scan.nextLine();
                 System.out.println("ENTER THE MAXIMUM MILEAGE BELOW");
                 String maxMileage  = scan.nextLine();
                 System.out.println();
                 displayvehicles(this.dealership.getVehiclesByMileage(Integer.parseInt(minMileage),Integer.parseInt(maxMileage)));
                 System.out.println("This is the list");
                 System.out.println();
                 break;
             case "V":
                 System.out.println("PLEASE ENTER THE TYPE OF THE VEHICLE");
                 String TYPE = scan.nextLine();
                 System.out.println();
                 displayvehicles(this.dealership.getVehiclesByType(TYPE));
                 System.out.println("This is the list");
                 System.out.println();
                 break;
             case"L":
                 processAllvehiclesrequest();
                 System.out.println("This is the list");
                 System.out.println();
                 break;
             case"A":
                 DealershipFileManager DEAL = new DealershipFileManager();
                 DEAL.saveDealership(this.dealership);
                 break;
             case"Q":
                 DealershipFileManager REMOVE = new DealershipFileManager();
                 REMOVE.removeitem(this.dealership);
                 break;
             case"S":
                 System.out.println("Please enter the date in the following contract YYYYMMDD");
                 String date = scan.nextLine();
                 System.out.println("Please enter the customer's name.");
                 String customName = scan.nextLine();
                 System.out.println("Please enter the email of the customer");
                 String email = scan.nextLine();
                 System.out.println("Please enter the Vehicle's Vin number");
                 String vinNumber = scan.nextLine();
                 Vehicle L = new Vehicle("Black");
                 for(Vehicle P : dealership.getAllVehicles()){
                    if(vinNumber.equalsIgnoreCase(String.valueOf(P.getVin()))){
                         L = P;
                    }
                 }
                 System.out.println("Type 1 to Lease or 2 for Sale");
                 int option = scan.nextInt();
                 if(option == 2){
                     SalesContract sell = new SalesContract(date,customName,email,L,true);
                     ContractFileManager Cont = new ContractFileManager();
                     Cont.save(sell);

                 }
                 else if(option == 1 ){
                     if(L.getYear() <= 2020) {
                         System.out.println("Any vehicle older than 3 years can't be leased.");
                     }
                     else {
                         LeaseContract Lease = new LeaseContract(date, customName, email, L);
                         ContractFileManager Cont = new ContractFileManager();
                         Cont.save(Lease);
                     }
                 }
                 break;
                 case "X":
                 set = false;
                 break;
         }



           /* if(L.getYear() <= 2020){
                System.out.println("Any vehicle older than 3 years can't be leased.");
                break;
            }

            */








       //display the menu
       // read the user's command
         // Create a switch statment that calls  the specific statment relating to the user input
     }
    }







}
