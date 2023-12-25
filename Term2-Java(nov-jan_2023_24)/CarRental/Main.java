package CarRental;

import java.util.Scanner;

/**
 * CarRental:Entry point
 */
public class Main {
    public static Scanner scan = new Scanner(System.in);//get users input
    static String make;
    static String model;
    static int year;


    public static void main(String[] args) {
        try{
            boolean exit = false;
            System.out.println("Enter related digit for vehicle you would like to rent.");
            System.out.println("1 -> Car");
            System.out.println("2 -> Motorcycle");
            System.out.println("3 -> Truck");
            System.out.println("0 -> exit");


            while (!exit) {
                int opt = scan.nextInt();
                scan.nextLine();

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
                        System.out.println("\nExiting...");
                        break;

                    default:
                        System.out.println("Not a valid input.");
                        break;
                }
            }
            scan.close();
        } catch (Exception e){
            System.out.println("Error: " + e);
        }

    }

    
    // method to implement motorcycle blueprint
    public static void motorcycle() {
        try {
            System.out.println("\nMOTORCYCLE ORDER MENU");
            System.out.println("1 -> Place order");
            System.out.println("2 -> View order");
            System.out.println("3 -> Update/edit order");
            System.out.println("0 -> exit order");

            boolean ext = false;
            
            while (!ext) {
                int opt = scan.nextInt();
                scan.nextLine();

                switch (opt) {
                    case 1:
                        motorcycleClass.placeOrder();
                        break;

                    case 2:
                        motorcycleClass.view();
                        break;

                    case 3:
                        motorcycleClass.update();
                        break;

                    case 0:
                        ext = true;
                        System.out.println("\nExiting car menu...");
                        main(null);
                        break;

                    default:
                        System.out.println("Not a valid input.");
                        break;
                } 
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }  
    }


    // method to implement truck blueprint
    public static void truck() {
        try{
            System.out.println("\nTRUCK ORDER MENU");
            System.out.println("1 -> Place order");
            System.out.println("2 -> View order");
            System.out.println("3 -> Update/edit order");
            System.out.println("0 -> exit order");

            boolean ext = false;
            
            while (!ext) {
                int opt = scan.nextInt();
                scan.nextLine();

                switch (opt) {
                    case 1:
                        truckClass.placeOrder();
                        break;

                    case 2:
                        truckClass.view();
                        break;

                    case 3:
                        truckClass.update();
                        break;

                    case 0:
                        ext = true;
                        System.out.println("\nExiting truck menu...");
                        main(null);
                        break;

                    default:
                        System.out.println("Not a valid input.");
                        break;
                } 
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }


    // method to implement car blueprint
    public static void car() {
        try{
            System.out.println("\nCAR ORDER MENU");
            System.out.println("1 -> Place order");
            System.out.println("2 -> View order");
            System.out.println("3 -> Update/edit order");
            System.out.println("0 -> exit order");

            boolean ext = false;
            
            while (!ext) {
                int opt = scan.nextInt();
                scan.nextLine();

                switch (opt) {
                    case 1:
                        CarClass.placeOrder();
                        break;

                    case 2:
                        CarClass.view();
                        break;

                    case 3:
                        CarClass.update();
                        break;

                    case 0:
                        ext = true;
                        System.out.println("\nExiting car menu...");
                        main(null);
                        break;

                    default:
                        System.out.println("Not a valid input.");
                        break;
                } 
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }    
    }

    
    // handle exception and get String input
    public static String getStringInput(String prompt, Scanner scan){
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
    public static int getIntInput(String prompt, Scanner scan){
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
    public static String ifEmpty(String value){
        // if value is not given, loops till vaule is provided                
        while (value.isEmpty()) {
            value = getStringInput("Enter a value: ", scan);
        }
        return value;
    }
}
