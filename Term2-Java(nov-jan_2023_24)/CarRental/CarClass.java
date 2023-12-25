package CarRental;

import java.util.ArrayList;
import java.util.Scanner;

public class CarClass {
    public static Scanner scan = new Scanner(System.in);//get users input
    public static ArrayList<Car> listOfVehicles = new ArrayList<>();// store input
    static int doors;
    static String fuel;
    static String make;
    static String model;
    static int year;

    //place a car order
    public static void placeOrder(){
        String addCar = "yes";

        while(addCar.equals("yes")){
            make = Main.getStringInput("\nWhat is the MAKE of the car: ", scan);// get make of car
            // if value is not given, loops till vaule is provided                
            make = Main.ifEmpty(make);


            model = Main.getStringInput("What is the MODEL of the car: ", scan);// get model of car
            // if value is not given, loops till vaule is provided                
            model = Main.ifEmpty(model);


            fuel = Main.getStringInput("FUEL type: ", scan);// get make of car
            // if value is not given, loops till vaule is provided                
            fuel = Main.ifEmpty(fuel);


            year = Main.getIntInput("What is the YEAR of creation: ", scan);// year car was made
            // the first car is presumed to have been made in 1886;, so year should be greater than 1800
            while (year < 1800) {
                year = Main.getIntInput("Enter a year greater than 1800: ", scan);
            }


            doors = Main.getIntInput("How many DOORS should the car have: ", scan);// get make of car

            scan.nextLine();//consume new line


            Car car = new Car(make, model, year);

            car.numberOfDoors = doors;
            car.fuelType = fuel;
            
            listOfVehicles.add(car);

            System.out.println("\nDo you what to add another car? (yes/no): ");
            addCar = scan.nextLine().toLowerCase();
            if(addCar.equals("no")){
                Main.car();
            }
        }
    }

    //print out the list of vehicle
    public static void view(){
        if (listOfVehicles.isEmpty()) {
            System.out.println("\nNo vehicles to display.");
        } else {
            System.out.println("\nList of Vehicles:");
            int i = 0;
            for (Car obj : listOfVehicles) {
                System.out.println("\n" + ++i + ".");
                System.out.println("Car make: " + obj.getVehicleMake());
                System.out.println("Car model: " + obj.getVehicleModel());
                System.out.println("Year: " + obj.getManufacturedYear());
                System.out.print("Should have " + obj.getDoors() + " doors and ");
                System.out.print("run on " + obj.getFuelType() + ".\n");
            }
        }
        Main.car();
    }

    //updating order
    public static void update() {
        if (listOfVehicles.isEmpty()) {
            System.out.println("\nNo vehicles to update.");
            Main.car(); // Go back to the previous menu
        }
    
        System.out.println("\nEnter the car model you want to update:");
        String modelUpdate = scan.nextLine();
    
        boolean carFound = false;
    
        for (Car car : listOfVehicles) {
            if (car.getVehicleModel().equalsIgnoreCase(modelUpdate)) {
                // Car found, update its properties
                System.out.println("Car found! Update the details:");
                
                doors = Main.getIntInput("How many DOORS should the car have: ", scan);
                scan.nextLine(); // consume new line
    
                Car updatedCar = new Car(car.getVehicleMake(), car.getVehicleModel(), car.getManufacturedYear());
                updatedCar.setDoors(doors);

                fuel = Main.getStringInput("FUEL type: ", scan);
                updatedCar.setFuelType(fuel);
    
                 // Update the car in the list
                listOfVehicles.remove(car);
                listOfVehicles.add(updatedCar);

                System.out.println("\nCar updated successfully!");
                carFound = true;
                break; // No need to continue searching
            }
        }
    
        if (!carFound) {
            System.out.println("Car with model '" + modelUpdate + "' not found.");
        }
    
        Main.car(); // Go back to the previous menu
    }
    
}
