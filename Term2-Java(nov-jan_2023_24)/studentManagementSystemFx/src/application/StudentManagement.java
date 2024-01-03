package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * StudentManagement: add, upload and view
 */
class StudentManagement {
    private static Scanner scan = new Scanner(System.in);// to get users input

    // Array to store students
    private static ArrayList<Student> studentsList = new ArrayList<>();
    public static int numberOfStudents = 0;
    
   
    // adding new student
    public static void newStudent(int ID, String name, int age, float grade){
        System.out.println("\nADDING NEW STUDENT\n");
       
        try{
            // confirm if student id already existing
            Student exist = checkID(ID);

        
            if (exist != null) {
                // alert administrator
                System.out.println("Student with ID " + ID + " already exist.");
                System.out.println("If you intend to update then choose the update option.");
            } else {
                numberOfStudents++;

                // get the grade                
                if(grade < 0.0){
                    throw new Exception("Grade should be positive. E.g 4.0");
                }

                // create new instance of student
                Student new_stu = new Student(name, ID, age, grade);
                studentsList.add(new_stu);
                System.out.println(numberOfStudents + " New student details has been added");
            }
        
        } catch(Exception e){
                System.out.println("Error:Something broke " + e);
                scan.nextLine();
        }
    }


    // update student information
    public static String updateStudentInfo(int ID, String name, Integer age, Float grade){
        System.out.println("\nUPDATING STUDENTS' INFORMATION");
            
        // confirm if student (id) exists in the list
        Student exist = checkID(ID);

        if (exist != null) {
        	// find what is to be updated
            try {
            	         	
            	// updating name
            	if(name != null && !name.isEmpty()) {
            		System.out.print("\nUpdate student name: ");
                    exist.setName(name);
            	}
            	
            	// updating age
            	if(age != null) {
            		if (age > 3) {
	            		System.out.print("\nStudent age: ");
	                    updateAge(exist, (int)age);
            		} else {
            			return "Student must be 4 and above";
            		}
            	}
            	
            	// updating grade
            	if(grade != null) {
            		if (grade >= 0) {
	            		System.out.print("\nStudent grade: ");
	                    updateGrade(exist, (float)grade);
	            	}else {
	            		return "Grade should be positive";
	            	}
            	}
            	System.out.print("\nStudent grade: ");
                 return "\nStudents' details successfully updated";
                    
            } catch (Exception e) {
	            if (ID != (int) ID){ // if id is not type integer
	                return ("ID " + ID + " should be digits.");
	            }else{
		             return ("Error: Something went wrong " + e);
	            }
            }
        }
        return (ID + " does not exist\n");
       
    }


    //update age - called in the update method
    private static void updateAge(Student student,int age){
        
        student.setAge(age);
    }

    //update grade - called in the update method
    private static void updateGrade(Student student, float grade){
      
        student.setGrade(grade);
    }

    // view the student table
    public static List<Student> viewStudentDetails(){
       
        System.out.println("\nVIEW STUDENTS' INFORMATION");
            
        List<Student> allStudents = new ArrayList<>();

        // Display details for all students
        for (Student s : studentsList) {
            // Add each student to the list
            allStudents.add(s);
        }

        return allStudents;

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
