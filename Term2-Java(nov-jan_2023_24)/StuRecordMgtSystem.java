
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class StuRecordMgtSystem {
    // Administrator Interface
    private static Scanner scan = new Scanner(System.in);// to get users input
    // Array to store students
    private static ArrayList<Student> studentsList = new ArrayList<>();
    public static void main(String[] args){
        boolean exit = false;
        //creating an infinte loop
        while (!exit) {
            System.out.println("\nChoose from the Menu: new, update, view or exit:");
            System.out.println("new - To add new student.");
            System.out.println("update - To update student.");
            System.out.println("view - To student details.");
            System.out.println("exit - To exit.\n");

            String option = scan.nextLine();
            switch (option) {
                case "new":
                    newStudent();
                    break;
                case "update":
                    updateStudentInfo();
                    break;
                // case "view":
                //     viewStudentDetails();
                //     break;
                case "exit":
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


    // adding new student
    private static void newStudent(){
        System.out.println("\nADDING NEW STUDENT");

        try{
            //enter student id
            System.out.println("Student ID: ");
            int ID = scan.nextInt();
            scan.nextLine();

            // confirm if student id already existing
            Student exist = checkID(ID);

        
            if (exist != null) {
                // alert administrator
                System.out.println("Student with ID " + ID + " already exist.");
                System.out.println("If you intend to update then choose the update option.");
            } else {
                // get the name
                System.out.println("Student name: ");
                String name = scan.nextLine();

                // get the age
                System.out.println("Student age: ");
                int age = scan.nextInt();
                scan.nextLine();

                // get the grade
                System.out.println("Student grade: ");
                float grade = scan.nextFloat();
                scan.nextLine();

                // create new instance of student
                Student new_stu = new Student(name, ID, age, grade);
                studentsList.add(new_stu);
                System.out.println("New student details has been added");
            }
        } catch(InputMismatchException e){
                System.out.println("Error:Wrong input ");
                System.out.println("for age and ID, enter a positive digit. For grade use decimal point e.g. 4.0");
        } catch(Exception e){
            // if (e) handle input mismact exept,
            //     System.out.println("Enter positive value.");
                System.out.println("Error:Something broke " + e);
                scan.nextLine();
        }
    }


    // update student information
    private static void updateStudentInfo(){
        System.out.println("\nUPDATING STUDENTS' INFORMATION");
            
        //enter student id
        System.out.println("ID of the student you want to update: ");
        int ID = scan.nextInt();
        scan.nextLine();

        // confirm if student (id) exists in the list
        Student exist = checkID(ID);

        try {
            if (exist != null) {
                // find what is to be updated
                System.out.println("\nEnter 1 - to update ID");
                System.out.println("\nEnter 2 - to update name");
                System.out.println("\nEnter 3 - to update age");
                System.out.println("\nEnter 4 - to update grade");
                System.out.println("\nEnter 0 - to exit");
                int option = scan.nextInt();
                scan.nextLine();
                
                while(option!=0){
                    switch(option){
                        case 1:
                            // update the id
                            System.out.println("Update student ID: ");
                            int up_id = scan.nextInt();
                            updateID(exist, up_id);
                            break;
                        case 2:
                            // update the name
                            System.out.println("Update student name: ");
                            String up_name = scan.nextLine();
                            exist.setName(up_name);
                            break;
                        case 3:
                            // set the age
                            System.out.println("Student age: ");
                            int up_age = scan.nextInt();
                            updateAge(exist, up_age);
                            break;
                        case 4:
                            // set the grade
                            System.out.println("Student grade: ");
                            float up_grade = scan.nextFloat();
                            updateGrade(exist, up_grade);
                            break;
                        default:
                            System.out.println("NOT AN OPTION");
                            break;
                    }
                }
                
                System.out.println("Students' details successfully updated");
            }
        } catch (Exception e) {// handle input mismach exception
            // TODO: handle exception
            if (ID != (int) ID){ // if id is not type interger
                System.out.println("ID " + ID + " should be digits.");
            }else if (exist == null){
                System.out.println("Student ID " + ID + " does not exist.");
                System.out.println("If you intend to add new student please  select 'new'");
            }else{
                System.out.println("Error: Something went wrong " + e);
            }
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


// student class with private instance variables for storing student information such as name, ID, age, and grade.
class Student{
    private String name;
    private int ID;
    private int age;
    private float grade;

    // initializing the variables
    public Student(String _name, int _ID, int _age, float _grade) {
        this.name = _name;
        this.ID = _ID;
        this.age = _age;
        this.grade = _grade;
    }

    // update new Id
    public void setId(int id){
        this.ID = id;
    }

    // update new name
    public void setName(String name){
        this.name = name;
    }

    // update new age
    public void setAge(int age){
        this.age = age;
    }

    // update new grade
    public void setGrade(float grade){
        this.grade = grade;
    }

    // return id demanded
    public int returnId(){
        return this.ID;
    }
}

class StudentManagement {
    private static String[] listOfStudent;
    private static int numberOfStudents;
}

