package CarRental;

import java.util.ArrayList;
import java.util.Scanner;

public class motorcycleClass {
    public static Scanner scan = new Scanner(System.in);//get users input
    public static ArrayList<Motorcycle> listOfBikes = new ArrayList<>();// store input
    static String type;
    static int numbersOfWheels;
    static String make;
    static String model;
    static int year;

    public static void placeOrder() {
        String addCar = "yes";

        while(addCar.equals("yes")){
            make = Main.getStringInput("\nWhat is the MAKE of the Motorcycle: ", scan);// get make of car
            // if value is not given, loops till vaule is provided                
            make = Main.ifEmpty(make);


            model = Main.getStringInput("What is the MODEL of the Motorcycle: ", scan);// get model of car
            // if value is not given, loops till vaule is provided                
            model = Main.ifEmpty(model);


            type = Main.getStringInput("What type -> sport, cruiser, or off-road: ", scan);// get make of car
            // if value is not given, loops till vaule is provided                
            type = Main.ifEmpty(type);


            year = Main.getIntInput("What is the YEAR of creation: ", scan);// year car was made
            // the first car is presumed to have been made in 1886;, so year should be greater than 1800
            while (year < 1800) {
                year = Main.getIntInput("Enter a year greater than 1800: ", scan);
            }


            numbersOfWheels = Main.getIntInput("How many wheels should the bike have: ", scan);// get make of car
            // the lowest number of wheels a bike can have is 2
            while (numbersOfWheels < 1) {
                numbersOfWheels = Main.getIntInput("Enter a number greater than 2: ", scan);
            }

            scan.nextLine();//consume new line


            Motorcycle bike = new Motorcycle(make, model, year);

            bike.numbersOfWheels = numbersOfWheels;
            bike.type = type;
            
            listOfBikes.add(bike);
            

            System.out.println("Do you what to add another car? (yes/no): ");
            addCar = scan.nextLine().toLowerCase();
            if(addCar.equals("no")){
                Main.motorcycle();
            }
        }
    }


    //print out the list of vehicle
    public static void view(){
        if (listOfBikes.isEmpty()) {
            System.out.println("\nNo vehicles to display.");
        } else {
            System.out.println("\nList of Vehicles:");
            int i = 0;

            for (Motorcycle obj : listOfBikes) {
                System.out.println("\n" + ++i + ".");
                System.out.println("Motorcycle make: " + obj.getVehicleMake());
                System.out.println("Motorcycle model: " + obj.getVehicleModel());
                System.out.println("Year: " + obj.getManufacturedYear());
                System.out.print("It should have " + obj.getNumbersOfWheels() + " wheels and ");
                System.out.print("be a " + obj.getMotorcycleType() + " type bike.\n");
            }
        }
        Main.motorcycle();
    }

    //updating order
    public static void update() {
        if (listOfBikes.isEmpty()) {
            System.out.println("\nNo vehicles to update.");
            Main.motorcycle(); // Go back to the previous menu
        }
    
        System.out.println("\nEnter the motorcycle model you want to update:");
        String modelUpdate = scan.nextLine();
    
        boolean bikeFound = false;
    
        for (Motorcycle motorcycle : listOfBikes) {
            if (motorcycle.getVehicleModel().equalsIgnoreCase(modelUpdate)) {
                // motorcycle found, update its properties
                System.out.println("Motorcycle found! Update the details:");
                
                numbersOfWheels = Main.getIntInput("How many WHEELS should the motorcycle have: ", scan);
                scan.nextLine(); // consume new line
    
                Motorcycle updatedBike = new Motorcycle(motorcycle.getVehicleMake(), motorcycle.getVehicleModel(), motorcycle.getManufacturedYear());
                updatedBike.setNumbersOfWheels(numbersOfWheels);

                type = Main.getStringInput("What type -> sport, cruiser, or off-road: ", scan);
                updatedBike.setMotorcycleType(type);
    
                 // Update the car in the list
                listOfBikes.remove(motorcycle);
                listOfBikes.add(updatedBike);

                System.out.println("\nMotorcycle updated successfully!");
                bikeFound = true;
                break; // No need to continue searching
            }
        }
    
        if (!bikeFound) {
            System.out.println("Bike with model '" + modelUpdate + "' not found.");
        }
    
        Main.motorcycle(); // Go back to the previous menu
    }  
}
