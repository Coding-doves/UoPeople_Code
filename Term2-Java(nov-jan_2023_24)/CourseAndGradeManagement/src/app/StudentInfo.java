package app;

import java.util.ArrayList;

public class StudentInfo {
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
