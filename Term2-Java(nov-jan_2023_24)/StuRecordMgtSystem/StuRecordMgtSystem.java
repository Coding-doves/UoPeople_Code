package StuRecordMgtSystem;


import java.util.Scanner;

/**
 * StuRecordMgtSystem - Entry point 
 */
public class StuRecordMgtSystem {
    // Administrator Interface
    private static Scanner scan = new Scanner(System.in);// to get users input

    public static void main(String[] args){
        boolean exit = false;
        //creating an infinite loop
        while (!exit) {

            System.out.println("\nWELCOME!!! Administrator, what option?");
            System.out.println("new - To add new student.");
            System.out.println("upd - To update student.");
            System.out.println("view - To student details.");
            System.out.println("ext - To exit.");

            String option = scan.nextLine();
            switch (option) {
                case "new":
                    StudentManagement.newStudent();
                    break;
                case "upd":
                    StudentManagement.updateStudentInfo();
                    break;
                case "view":
                    StudentManagement.viewStudentDetails();
                    break;
                case "ext":
                    exit = true;
                    scan.close();
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nEnter a valid option");
                    break;
            }
        } 
    }
}
