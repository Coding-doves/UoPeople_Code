package CarRental;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CarRental:Entry point
 */
public class Main {
    public static Scanner scan = new Scanner(System.in);//get users input
    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("Enter related digit for vehicle you would like to rent.");
        System.out.println("1 -> Car");
        System.out.println("2 -> Motorcycle");
        System.out.println("3 -> Truck");
        System.out.println("0 -> exit");

        int opt = scan.nextInt();
        scan.nextLine();

        while (!exit) {
            switch (opt) {
                case 1:
                    car();
                    break;

                case 2:
                    motorcycle();
                    break;

                case 3:
                    truck();
                    break;

                case 0:
                    exit=true;
                    scan.close();
                    break;

                default:
                    System.out.println("Not a valid input.");
                    break;
            }
        }
        
        Motorcycle motorcycle = new Motorcycle("Harley", "Davidson", 2021);
        Truck truck = new Truck("Ford", "F-150", 2023);

        motorcycle.numbersOfWheels = 2;
        motorcycle.type = "sport";

        truck.capacityInTons = 1200;
        truck.transmissonType = "automatic";

        System.out.println(motorcycle.make);
        System.out.println(truck.capacityInTons);
    }

    private static void motorcycle() {
    }

    private static void truck() {
    }

    // method to implement car blueprint
    private static void car() {
        ArrayList<Car> listOfCars = new ArrayList<>();// store input
        String make;
        String model;
        int year;
        int doors;
        String fuel;

        make = getStringInput("What is the MAKE of the car: ", scan);// get make of car
        // if value is not given, loops till vaule is provided                
        make = ifEmpty(make);


        model = getStringInput("What is the MODEL of the car: ", scan);// get model of car
        // if value is not given, loops till vaule is provided                
        model = ifEmpty(model);


        fuel = getStringInput("FUEL type: ", scan);// get make of car
        // if value is not given, loops till vaule is provided                
        fuel = ifEmpty(fuel);


        year = getIntInput("What is the YEAR of the car: ", scan);// year car was made
        // if value is not given, loops till vaule is provided
        year = ifEmpty(year);
        // the first car is presumed to have been made in 1886;, so year should be greater than 1800
        while (year <= 1800) {
            year = getIntInput("Enter a year greater than 1800: ", scan);
        }


        doors = getIntInput("How many DOORS should the car have: ", scan);// get make of car
        // if value is not given, loops till vaule is provided                
        doors = ifEmpty(doors);

        scan.nextLine();//consume new line


        Car car = new Car(make, model, year);

        car.numberOfDoors = doors;
        car.fuelType = fuel;
        
        listOfCars.add(car);
        for (Car obj : listOfCars) {
            System.out.println("Car make: " + obj.getVehicleMake());
            System.out.println("Car model: " + obj.getVehicleModel());
            System.out.print("Has " + obj.getDoors() + " doors and ");
            System.out.print("runs on " + obj.getFuelType() + ".\n\n");
        }
    }

    // handle exception and get String input
    private static String getStringInput(String prompt, Scanner scan){
        String value;

        while (true) {
            System.out.print(prompt);
            try {
                value = scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("An error occurred: " + e);
                scan.nextLine(); // Consume the invalid input
            }
        }
        return value;
    }

    // handle exception and get integer input
    private static int getIntInput(String prompt, Scanner scan){
        int value = 0;

        while (true) {
            System.out.print(prompt);
            try {
                value = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for the year: " + e);
                scan.nextLine(); // Consume the invalid input
            }
        }
        return value;
    }

    // loops till value is provided; String
    private static String ifEmpty(String value){
        // if value is not given, loops till vaule is provided                
        while (value.isEmpty()) {
            value = getStringInput("Enter a value: ", scan);
        }
        return value;
    }

    // loops till value is provided; int
    private static int ifEmpty(int value){
        // if value is not given, loops till vaule is provided                
        while (value == 0) {
            value = getIntInput("Enter a value: ", scan);
        }
        return value;
    }
    
}
