package application;
	
import java.awt.event.ActionEvent;
import java.util.InputMismatchException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {
	public static Label welcome;// Label in the right pane to display text
	private StackPane stackPane;
	private BorderPane root;
	private MenuBar menuBar;
	private VBox inputBox;
	private TextField idField;
    private TextField nameField;
    private TextField ageField;
    private TextField gradeField;
    
	@Override
	public void start(Stage primaryStage) {
		// Create a menu bar
        menuBar = new MenuBar();

        // Create a menu
        Menu studentMenu = new Menu("Add new Student");

        // Create a menu item for adding a student
        MenuItem addStudentItem = new MenuItem("Add Student");
        addStudentItem.setOnAction(event -> addStudentForm(primaryStage));
        
        studentMenu.getItems().add(addStudentItem);
        menuBar.getMenus().add(studentMenu);
       
     // Create the second menu
        Menu courseStudentMenu = new Menu("Add Course Student");

        // Create a menu item for adding a course student
        MenuItem addCourseStudentItem = new MenuItem("Add Course Student");
        // Add an action event for adding course students
        addCourseStudentItem.setOnAction(event -> addCourseStudentForm(primaryStage));

        courseStudentMenu.getItems().add(addCourseStudentItem);
        menuBar.getMenus().add(courseStudentMenu);

		
		stackPane = new StackPane();
		stackPane.getChildren().add(menuBar);
		
		welcome = new Label("WELCOME!!! Administrator");
		
		
        stackPane.setPrefSize(400, 400);
		
        // Use a BorderPane to organize your layout
        root = new BorderPane();
        root.setTop(menuBar); // Menu bar at the top
        root.setCenter(welcome); // Display welcome label initially

		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setTitle("Admin Dashboard");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	private Object addCourseStudentForm(Stage primaryStage) {
		// TODO Auto-generated method stub
		return null;
	}

	private void addStudentForm(Stage primaryStage) {
		Label formLabel = new Label("ADDING NEW STUDENT");
		
        // Create input fields
        idField = new TextField();
        nameField = new TextField();
        ageField = new TextField();
        gradeField = new TextField();

        // Create a VBox to hold input fields
        inputBox = new VBox(10); // 10 is the spacing between fields
        inputBox.getChildren().addAll(
        		menuBar,    // Add the MenuBar
        		formLabel, // Add the form label      
                new Label("Student ID: "), idField,
                new Label("Student Name: "), nameField,
                new Label("Student Age: "), ageField,
                new Label("Student Grade: "), gradeField
        );

        // Set the button to add the student
        Button addButton = new Button("Add Student");
        addButton.setOnAction(event -> addStudent(primaryStage));

     // Create a "Back to Main Menu" button
        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(event -> {
            stackPane.getChildren().setAll(menuBar);
            welcome.setText(""); // Clear the existing label content
        });
        
        inputBox.getChildren().addAll(
                addButton,
                backButton  //Add the back button
        );
        
        // Update the scene's root with input fields
        primaryStage.getScene().setRoot(inputBox);

        
        // Clear the existing label content
        welcome.setText("");
    }

	private void addStudent(Stage primaryStage) {

		Label successLabel;
		
        try {
            int ID = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            float grade = Float.parseFloat(gradeField.getText());

            // Call the newStudent method with user details
            StudentManagement.newStudent(ID, name, age, grade);
            
         // Display success message at the bottom of input fields
            successLabel = new Label(/*StudentManagement.numberOfStudents + */" Student added successfully!");
            inputBox.getChildren().add(successLabel);

            // Clear the input fields
            idField.clear();
            nameField.clear();
            ageField.clear();
            gradeField.clear();

        } catch (NumberFormatException e) {
            // Handle invalid input
        	 successLabel = new Label("Error: Invalid input. Please enter valid numbers.");
        	 inputBox.getChildren().add(successLabel);
        }
    }


	
	public static void main(String[] args) {
		launch(args);
	}
}
