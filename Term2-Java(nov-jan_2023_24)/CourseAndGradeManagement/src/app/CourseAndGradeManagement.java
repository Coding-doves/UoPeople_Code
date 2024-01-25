package app;

import java.util.Scanner;

public class CourseAndGradeManagement {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        	
        // get administrators option
        boolean exit = false;

        while(!exit){
            System.out.println("\nHello Admin! Enter A Command\n");
            System.out.println("1 - To add a new course");
            System.out.println("2 - To enroll students");
            System.out.println("3 - To assign grades");
            System.out.println("4 - To calculate overall course grades");
            System.out.println("0 - To exit");

            int option = scan.nextInt();
            
            switch (option) {
                case 1:
                    add_course();
                    break;
            
                case 2:
                    enroll_course();
                    break;

                case 3:
                    
                    break;

                case 4:
                    
                    break;

                case 0:
                    exit=true;
                    scan.close();
                    break;

                default:
                    System.out.println("\nEnter a valid option");
                    break;
            }
        }
    }

    //add course
    private static void add_course() {
        System.out.println("\nEnter course code: ");
        while(!scan.hasNext()){
            System.out.print("\nProvide value please: ");
            scan.next();
        }
        String courseCode = scan.next();

        System.out.print("\nEnter course Title: ");
        while(!scan.hasNext()){
            System.out.print("\nProvide value please: ");
            scan.next();
        }
        String courseName = scan.next();
        scan.nextLine();

        System.out.print("\nEnter course maximum capacity: ");
        while(!scan.hasNextInt()){
            System.out.print("\nEnter digit please: ");
            scan.next();
        }
        int courseMaxCapacity = scan.nextInt();

        scan.nextLine();

        CourseManagement.addCourses(courseCode, courseName, courseMaxCapacity);
        System.out.println(courseName + " course added successfully!!!");
    
    }
    
    //enroll student
    private static void enroll_course() {

        System.out.print("\nEnter the name of the student you what to enroll: ");
        while(!scan.hasNext()){//ensures input is provide
            System.out.print("\nProvide value please: ");
            scan.next();
        }
        String student_name = scan.nextLine();

        System.out.print("\nEnter the id of the student you what to enroll: ");
        while(!scan.hasNext()){//ensures input is provide
            System.out.print("\nProvide value please: ");
            scan.next();
        }
        String studentId = scan.nextLine();
        scan.nextLine();

        System.out.print("\nEnter course Title: ");
        while(!scan.hasNext()){
            System.out.print("\nProvide value please: ");
            scan.next();
        }
        String courseName = scan.next();
        Courses exist = check(courseName);

        scan.nextLine();

        StudentInfo info = new StudentInfo(student_name, studentId);
        
        if(exist != null){
            CourseManagement.enrollStudent(info, exist);

            System.out.println(exist + " course added successfully!!!");
        }else{
            System.out.println(exist + " does not exist.");
        }
    }

    // check if id exist
    private static Courses check(String course){
        for (Courses c : CourseManagement.getListOfCourses()) {
            if (c.name() == course){
                return c;
            }
        }
        return null;
    }

}
