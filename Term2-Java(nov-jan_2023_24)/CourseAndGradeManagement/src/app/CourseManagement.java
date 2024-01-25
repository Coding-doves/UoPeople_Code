package app;

import java.util.ArrayList;

public class CourseManagement {
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
