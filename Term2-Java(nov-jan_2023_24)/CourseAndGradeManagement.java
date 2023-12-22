//unfinshed
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Administrator Interface: to interact with the Course Enrollment and Grade Management System
 */
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

// .....
class CourseGrade{
    private Courses _course;
    private float _grade;

    public CourseGrade(Courses course, float grade){
        this._course = course;
        this._grade =  grade;
    }

    //getters
    public float grad(){return _grade;}
    public Courses cour(){return _course;}
   
}

/*
 *Student Class:
 */
class StudentInfo{
    private String studentName;
    private String studentId;
    private ArrayList<Courses> enrolledCourses;

    //initialing the variables
    public StudentInfo(String _studentName, String _studentId){
        this.studentName = _studentName;
        this.studentId = _studentId;
        this.enrolledCourses = new ArrayList<>();
    }
    
    // getters
    public String studName(){ return this.studentName; }
    public String studId(){ return this.studentId; }
    public ArrayList<Courses> studCourses(){ return this.enrolledCourses; }

    //setters
    public void setName(String name){ this.studentName = name; }
    public void setId(String id){ this.studentId = id; }
    public void setCourses(ArrayList<Courses> courses){ this.enrolledCourses = courses; }

    //enroll student
    public void enrollStudents(Courses course){ enrolledCourses.add(course); }
    
    //assign grades to students
    public CourseGrade assignGrades(Courses course, float grade){
        for(Courses c : enrolledCourses){
            if(c.equals(course)){
                CourseGrade addGrade = new CourseGrade(course, grade);
                return addGrade;
            }
        }
        return null;
    };

}


/*
 * Course Class:
 */
class Courses{
    private String courseCode;
    private String courseName;
    private int courseMaxCapacity;
    private static int totalNumOfEnrolledStudent;

    //initializing instances
    public Courses(String _courseCode, String _courseName, int _courseMaxCapacity){
        this.courseCode = _courseCode;
        this.courseName = _courseName;
        this.courseMaxCapacity = _courseMaxCapacity;
    }

    // getters
    public String code(){ return this.courseCode; };
    public String name(){ return this.courseName; };
    public int maxCap(){ return this.courseMaxCapacity; }

    //enroll student in specific course
    public void enroll(StudentInfo student, Courses course){
        if(totalNumOfEnrolledStudent < courseMaxCapacity){
            totalNumOfEnrolledStudent++;
            student.enrollStudents(course);
        }else{
            System.out.println(this.courseName + " is full");
        } 
    }

    //returns total number of enrolled students across all instances  of the course class
    public static int totalEnrolled(){ return totalNumOfEnrolledStudent; }

}

/*
 * CourseManagement Class:
 */
class CourseManagement {
    private static ArrayList<Courses> listOfCourses=new ArrayList<>();
    private static ArrayList<CourseGrade> listOfStudents=new ArrayList<>();

    //return course list
    public static ArrayList<Courses> getListOfCourses() {
        return listOfCourses;
    }

    //add new courses
    public static void addCourses(String courseCode, String courseName, int courseMaxCapacity){
        Courses course = new Courses(courseCode, courseName, courseMaxCapacity);
        listOfCourses.add(course);
    }
    
    //enroll students
    public static void enrollStudent(StudentInfo student, Courses course){
        Courses register = new Courses(null, null, 0);
        register.enroll(student, course);
    }

    //assign grade to students
    public static void assignGrade(StudentInfo student, Courses course, float grade){
        CourseGrade gradeOfStudents = student.assignGrades(course, grade);

        if(gradeOfStudents!=null){
            listOfStudents.add(gradeOfStudents);
        }
    }

    //calculateOverallGrade 
    public void calculateOverallGrade(StudentInfo student){
        float sum = 0;

        for(CourseGrade c : listOfStudents){
            sum += c.grad();
        }
    } 
}

/*
 * This assignment will assess your skills and knowledge to implement class methods and instance methods to define behavior and manipulate object state, and to apply access modifiers to control access to class members.

Context: You have been assigned to develop a Course Enrollment and Grade Management System in Java for a university. The system should provide functionality to enroll students in courses, assign grades to students, and calculate overall course grades for each student. The project should demonstrate the effective utilization of static methods and variables to keep track of enrollment and grade-related information across multiple instances of the Student and Course classes. It should also showcase your ability to manipulate object state and define behavior through instance methods.

Requirements:
Student Class:

The Student class should have private instance variables to store student information such as name, ID, and enrolled courses.
Implement appropriate access modifiers and provide public getter and setter methods for accessing and updating student information.
Design a method to enroll students in courses. It should accept a Course object as a parameter and add the course to the student's enrolled courses.
Implement a method to assign grades to students. It should accept a Course object and a grade for the student and update the student's grade for that course. 
Course Class:

The Course class should have private instance variables to store course information such as course code, name, and maximum capacity.
Use appropriate access modifiers and provide public getter methods for accessing course information.
Implement a static variable to keep track of the total number of enrolled students across all instances of the Course class.
Design a static method to retrieve the total number of enrolled students.
CourseManagement Class:

The CourseManagement class should have private static variables to store a list of courses and the overall course grades for each student.
Use appropriate access modifiers to control access to the variables.
Implement static methods to add new courses, enroll students, assign grades, and calculate overall course grades for each student.
The addCourse method should accept parameters for course information and create a new Course object. It should add the course to the list of courses.
The enrollStudent method should accept a Student object and a Course object. It should enroll the student in the course by calling the appropriate method in the Student class.
The assignGrade method should accept a Student object, a Course object, and a grade. It should assign the grade to the student for that course by calling the appropriate method in the Student class.
The calculateOverallGrade method should accept a Student object and calculate the overall course grade for that student based on the grades assigned to them.
Administrator Interface:

Develop an interactive command-line interface for administrators to interact with the Course Enrollment and Grade Management System.
Display a menu with options to add a new course, enroll students, assign grades, and calculate overall course grades.
Prompt the administrator for necessary inputs and call the appropriate methods in the CourseManagement and Student classes to perform the requested operations.
Implement error handling to handle cases where invalid inputs are provided or when enrolling students in courses that have reached their maximum capacity.
Documentation:

Provide comprehensive documentation for the project, explaining the purpose and usage of each class, method, and variable.
Describe how static methods and variables are utilized to track enrollment and grade-related information across multiple instances of the Student and Course classes.
Include instructions for running the program and interacting with the administrator interface.
 */
