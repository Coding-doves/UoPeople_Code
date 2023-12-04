# Term 2 year 1
# Quiz
# Library system
# Student record management system
### Student Record Management System Documentation

#### Overview:

This Java program implements a Student Record Management System for a university. It allows administrators to add new students, update student information, and view student details.

#### Classes:

1. **Student Class:**
    - `Student`: Represents a student with private instance variables for name, ID, age, and grade. Includes a constructor and getters/setters.

2. **Student Management Class:**
    - `StudentManagement`: Manages the list of students and provides methods for adding, updating, and viewing student information.

#### How to Run:

1. **Compile the Program:**
    - Save the provided code in a file named `Main.java`.
    - Open a terminal and navigate to the directory containing the file.
    - Compile the program using the command: `javac Main.java`

2. **Run the Program:**
    - Run the compiled program with the command: `java Main`

#### Administrator Interface:

Upon running the program, the administrator is presented with a menu:

```
1. Add a new student
2. Update student information
3. View student details
4. Exit
```

#### Interacting with the Interface:

1. **Add a New Student:**
    - Choose option 1.
    - Enter the student's name, ID, age, and grade when prompted.

2. **Update Student Information:**
    - Choose option 2.
    - Enter the student ID for updating.
    - Provide the new age and grade.

3. **View Student Details:**
    - Choose option 3.
    - Enter the student ID to view details.

4. **Exit:**
    - Choose option 4 to exit the program.

#### Error Handling:

- The program handles cases where the provided student ID is not found.
- Invalid inputs (non-numeric values, etc.) are not handled in this basic implementation and may cause exceptions.

#### Example Interaction:

```
1. Add a new student
2. Update student information
3. View student details
4. Exit

Enter your choice: 1
Enter student name: John Doe
Enter student ID: 123
Enter student age: 20
Enter student grade: 85.5
Student added successfully.

1. Add a new student
2. Update student information
3. View student details
4. Exit

Enter your choice: 3
Enter student ID: 123
Student Details:
Name: John Doe
ID: 123
Age: 20
Grade: 85.5

1. Add a new student
2. Update student information
3. View student details
4. Exit

Enter your choice: 2
Enter student ID for update: 123
Enter new age: 21
Enter new grade: 90.0
Student information updated successfully.
```

Feel free to enhance the program based on specific requirements and additional error-handling scenarios.
