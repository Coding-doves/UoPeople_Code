package StuRecordMgtSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * StudentManagement: add, upload and view
 */
class StudentManagement {
    private static Scanner scan = new Scanner(System.in);// to get users input

    // Array to store students
    private static ArrayList<Student> studentsList = new ArrayList<>();
    private static int numberOfStudents = 0;

    // adding new student
    public static void newStudent(){
        System.out.println("\nADDING NEW STUDENT\n");

        try{
            //enter student id
            System.out.print("Student ID: ");
            int ID = scan.nextInt();
            if(ID < 1){
                throw new NonNegativeNumber("ID should be positive digit.");
            }
            scan.nextLine();

            // confirm if student id already existing
            Student exist = checkID(ID);

        
            if (exist != null) {
                // alert administrator
                System.out.println("Student with ID " + ID + " already exist.");
                System.out.println("If you intend to update then choose the update option.");
            } else {
                numberOfStudents++;

                // get the name
                System.out.print("Student name: ");
                String name = scan.nextLine();

                // get the age
                System.out.print("Student age: ");
                int age = scan.nextInt();
                if(age < 1){
                    throw new NonNegativeNumber("Age should be a positive digit.");
                }
                scan.nextLine();

                // get the grade
                System.out.print("Student grade: ");
                float grade = scan.nextFloat();
                if(grade < 0.0){
                    throw new NonNegativeNumber("Grade should be positive. E.g 4.0");
                }
                scan.nextLine();

                // create new instance of student
                Student new_stu = new Student(name, ID, age, grade);
                studentsList.add(new_stu);
                System.out.println(numberOfStudents + " New student details has been added");
            }
        } catch(NonNegativeNumber e){
            System.out.println(e.getMessage());
            scan.nextLine();
        } catch(InputMismatchException e){
            System.out.println("Error:Wrong input:\n" + e);
            scan.nextLine();
        } catch(Exception e){
                System.out.println("Error:Something broke " + e);
                scan.nextLine();
        }
    }


    // update student information
    public static void updateStudentInfo(){
        System.out.println("\nUPDATING STUDENTS' INFORMATION");
            
        //enter student id
        System.out.print("ID of the student you want to update: ");
        int ID = scan.nextInt();
        scan.nextLine();

        // confirm if student (id) exists in the list
        Student exist = checkID(ID);

        if (exist != null) {
            boolean exit = false;
            try {
                
                while(!exit){
                    // find what is to be updated
                    System.out.println("\nEnter 1 - to update ID");
                    System.out.println("Enter 2 - to update name");
                    System.out.println("Enter 3 - to update age");
                    System.out.println("Enter 4 - to update grade");
                    System.out.println("Enter 0 - Back to menu");
                    int option = scan.nextInt();
                    scan.nextLine();

                    switch(option){
                        case 1:
                            // update the id
                            System.out.print("\nUpdate student ID: ");
                            int up_id = scan.nextInt();
                            updateID(exist, up_id);
                            break;
                        case 2:
                            // update the name
                            System.out.print("\nUpdate student name: ");
                            String name = scan.nextLine();
                            exist.setName(name);
                            break;
                        case 3:
                            // set the age
                            System.out.print("\nStudent age: ");
                            int up_age = scan.nextInt();
                            updateAge(exist, up_age);
                            break;
                        case 4:
                            // set the grade
                            System.out.print("\nStudent grade: ");
                            float up_grade = scan.nextFloat();
                            updateGrade(exist, up_grade);
                            break;
                        case 0:
                            exit = true;
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("NOT AN OPTION");
                            break;
                    }
                    System.out.println("\nStudents' details successfully updated");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error:Wrong input type");
                scan.nextLine();
            } catch (Exception e) {
            // TODO: handle exception
            if (ID != (int) ID){ // if id is not type integer
                System.out.println("ID " + ID + " should be digits.");
            }else if (exist == null){
                System.out.println("Student ID " + ID + " does not exist.");
                System.out.println("If you intend to add new student please  select 'new'");
            }else{
                System.out.println("Error: Something went wrong " + e);
            }
            }
        }else{
            System.out.println(ID + " does not exist\nExiting...");
        }
    }

    //update id - called in the update method
    private static void updateID(Student student, int id){
        if (id < 1){// if id is not positive
            System.out.println("Must be positive digits");
        }else if(checkID(id) != null){// if id already exist i.e belongs to another student
            System.out.println(id + "already exist. Enter a unique Id");
        }else{
            student.setId(id);
        }
    }

    //update age - called in the update method
    private static void updateAge(Student student, int age){
        if (age < 1 && age != (int) age){// if age is not positive
            System.out.println(age + "Must be positive digits");
        }else{
            student.setAge(age);
        }
    }

    //update grade - called in the update method
    private static void updateGrade(Student student, float grade){
        if (grade <= 0.0 && grade != (float) grade){// if grade is not positive
            System.out.println(grade + "Must be positive digits");
        }else{
            student.setGrade(grade);
        }
    }


    // view the student table
    public static void viewStudentDetails(){
        boolean ext = false;

        System.out.println("\nVIEW STUDENTS' INFORMATION");
            
        while(!ext){
            // find what is to be updated
            System.out.println("\nEnter 1 - to view a student record");
            System.out.println("Enter all - to view the entire list");
            System.out.println("Enter 0 - exit from VIEW\n");
            String option = scan.nextLine();

            switch(option){
                case "1":
                    // view by id
                    System.out.print("Student ID: ");
                    int ID = scan.nextInt();
                    scan.nextLine();

                    // confirm if student (id) exists in the list
                    Student exist = checkID(ID);

                    if (exist != null) {
                        //list header
                        System.out.printf("%-15s%-15s%-15s%-15s\n","ID", "Name", "Age", "Grade");
                        System.out.println("--------------------------------------------");

                        // list body
                        System.out.printf("%-15d%-15s%-15d%-15.2f\n", exist.returnId(), exist.returnName(), exist.returnAge(), exist.returnGrade()); 
                    }else{
                        System.out.println("Student with ID " + ID + " does not exist\n");
                    }                     
                    break;
                case "all":
                    // view all
                    //list header
                    System.out.println("\nTotal Number of Students: " + StudentManagement.numberOfStudents);
                    System.out.printf("%-15s%-15s%-15s%-15s\n","ID", "Name", "Age", "Grade");
                    System.out.println("---------------");            

                    // list body
                    for (Student s : studentsList) {
                        System.out.printf("%-15d%-15s%-15d%-15.2f\n", s.returnId(), s.returnName(), s.returnAge(), s.returnGrade()); 
                    }
                    break;
                case "0":
                    ext = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("NOT AN OPTION");
                    break;
            }
        }
    }

    // check if id already exist
    private static Student checkID(int id){
        for (Student stu_id : studentsList) {
            if (stu_id.returnId() == id){
                return stu_id;
            }
        }
        return null;
    }

}
