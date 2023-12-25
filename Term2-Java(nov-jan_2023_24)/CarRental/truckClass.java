package CarRental;

import java.util.ArrayList;
import java.util.Scanner;

public class truckClass {
    public static Scanner scan = new Scanner(System.in);//get users input
    public static ArrayList<Truck> listOfTrucks = new ArrayList<>();// store input
    static String make;
    static String model;
    static int year;
    static int capacity;
    static String type;

    public static void placeOrder() {
        String addCar = "yes";

        while(addCar.equals("yes")){
            make = Main.getStringInput("What is the MAKE of the Truck: ", scan);// get make of car
            // if value is not given, loops till vaule is provided                
            make = Main.ifEmpty(make);


            model = Main.getStringInput("What is the MODEL of the Truck: ", scan);// get model of car
            // if value is not given, loops till vaule is provided                
            model = Main.ifEmpty(model);


            type = Main.getStringInput("What type -> MANUAL or AUTOMATIC: ", scan);// get make of car
            // if value is not given, loops till vaule is provided                
            type = Main.ifEmpty(type);


            year = Main.getIntInput("What is the YEAR of creation: ", scan);// year car was made
            // the first car is presumed to have been made in 1886;, so year should be greater than 1800
            while (year < 1800) {
                year = Main.getIntInput("Enter a year greater than 1800: ", scan);
            }


            capacity = Main.getIntInput("What CAPACITY should the truck have: ", scan);// get make of car
            // the lowest capacity a truck can have is 18000
            while (capacity < 2000) {
                capacity = Main.getIntInput("Enter a capacity greater than 18000: ", scan);
            }

            scan.nextLine();//consume new line


            Truck truck = new Truck(make, model, year);

            truck.capacityInTons = capacity;
            truck.transmissonType = type;
            
            listOfTrucks.add(truck);

            System.out.println("Do you what to add another car? (yes/no): ");
            addCar = scan.nextLine().toLowerCase();
            if(addCar.equals("no")){
                Main.truck();
            }
        }  
    }
    
    //print out the list of vehicle
    public static void view(){
        if (listOfTrucks.isEmpty()) {
            System.out.println("\nNo vehicles to display.");
        } else {
            System.out.println("\nList of Vehicles:");
            int i = 0;
            
            for (Truck obj : listOfTrucks) {
                System.out.println("\n" + ++i + ".");
                System.out.println("Truck make: " + obj.getVehicleMake());
                System.out.println("Truck model: " + obj.getVehicleModel());
                System.out.println("Year: " + obj.getManufacturedYear());
                System.out.print("Should have " + obj.getCargoCapacity() + " cargo capacity ");
                System.out.print("and be " + obj.getTransmissionType() + ".\n");
            }
        }
        Main.truck();
    }

    //updating order
    public static void update() {
        if (listOfTrucks.isEmpty()) {
            System.out.println("\nNo vehicles to update.");
            Main.truck(); // Go back to the previous menu
        }
    
        System.out.println("\nEnter the truck model you want to update:");
        String modelUpdate = scan.nextLine();
    
        boolean truckFound = false;
    
        for (Truck truck : listOfTrucks) {
            if (truck.getVehicleModel().equalsIgnoreCase(modelUpdate)) {
                // motorcycle found, update its properties
                System.out.println("Truck found! Update the details:");
                
                capacity = Main.getIntInput("What CAPACITY should the truck have: ", scan);
                scan.nextLine(); // consume new line
    
                Truck updateTruck = new Truck(truck.getVehicleMake(), truck.getVehicleModel(), truck.getManufacturedYear());
                updateTruck.setCargoCapacity(capacity);

                type = Main.getStringInput("What type -> MANUAL or AUTOMATIC: ", scan);
                updateTruck.setTransmissionType(type);
    
                 // Update the car in the list
                listOfTrucks.remove(truck);
                listOfTrucks.add(updateTruck);

                System.out.println("\nTruck updated successfully!");
                truckFound = true;
                break; // No need to continue searching
            }
        }
    
        if (!truckFound) {
            System.out.println("Truck with model '" + modelUpdate + "' not found.");
        }
    
        Main.truck(); // Go back to the previous menu
    }
}
