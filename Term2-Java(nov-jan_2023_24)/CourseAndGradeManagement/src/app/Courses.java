package app;

public class Courses {
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
