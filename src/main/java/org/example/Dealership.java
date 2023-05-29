package org.example;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    ArrayList <Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        this.inventory = new ArrayList<>();

    }

    //this method returns the list of vehicles within the given price range
    public  ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> motors = getAllVehicles();
        ArrayList<Vehicle> returnList = new ArrayList<>();

        for (Vehicle car : motors) {
            if (car.getPrice() >= min && car.getPrice() <= max) {
                returnList.add(car);
            }
        }
        return returnList;
    }

    //this method returns the list of vehicles with the exact make and model
    public  ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> motors = getAllVehicles();
        ArrayList<Vehicle> returnList = new ArrayList<>();

        for (Vehicle car : motors) {
            if (car.getModel().equalsIgnoreCase(model) && car.getMake().equalsIgnoreCase(make)) {
                returnList.add(car);
            }
        }
        return returnList;
    }

    //this method returns the list of vehicles within the given year range
    public  ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> motors = getAllVehicles();
        ArrayList<Vehicle> returnList = new ArrayList<>();

        for (Vehicle car : motors) {
            if (car.getYear() >= min && car.getYear() <= max) {
                returnList.add(car);
            }
        }
        return returnList;
    }

    //this method returns the list of vehicles within the given color
    public  ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> motors = getAllVehicles();
        ArrayList<Vehicle> returnList = new ArrayList<>();

        for (Vehicle car : motors) {
            if (color.equalsIgnoreCase(car.getColor())) {
                returnList.add(car);
            }
        }
        return returnList;
    }


    //this method returns the list of vehicles within the given Mileage range
    public  ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        ArrayList<Vehicle> motors = getAllVehicles();
        ArrayList<Vehicle> returnList = new ArrayList<>();

        for (Vehicle car : motors) {
            if (car.getOdometer() >= min && car.getOdometer() <= max) {
                returnList.add(car);
            }
        }
        return returnList;
    }

    //this method returns the list of vehicles that has the specific type
    public  ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> motors = getAllVehicles();
        ArrayList<Vehicle> returnList = new ArrayList<>();

        for (Vehicle car : motors) {
            if (car.getVehicleType().equalsIgnoreCase(vehicleType)) {
                returnList.add(car);
            }
        }
        return returnList;
    }

    //this method returns the list of all vehicles.
    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    //this method adds a vehicle to the list
    public void addVehicle(Vehicle vehicle){
        ArrayList<Vehicle> motors = getAllVehicles();
        motors.add(vehicle);
    }

    //this method removes a vehicle from the list
    public void removeVehicle(int vinNum){
        ArrayList <Vehicle> old = getAllVehicles();
        ArrayList <Vehicle> new1 = getAllVehicles();

        old.removeIf(V -> V.getVin() == vinNum);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void setCarlist(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }
}
