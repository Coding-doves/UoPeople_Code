package application;
	
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

import application.StudentManagement;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {
	public static Label welcome;// Label in the right pane to display text
	private Label successLabel;
    private Label formLabel;
    private Label info;
	private StackPane stackPane;
	private BorderPane root;
	private MenuBar menuBar;
	private VBox inputBox;
	// Create input fields
	private TextField idField = new TextField();
    private TextField nameField = new TextField();
    private TextField ageField = new TextField();
    private TextField gradeField = new TextField();
    
    
    
    public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// Create a menu bar
        menuBar = new MenuBar();

        // Create a menu
        Menu studentMenu = new Menu("Student");
        

        // Create a menu item for adding a student
        MenuItem addStudentItem = new MenuItem("Add Student");
        addStudentItem.setOnAction(event -> addStudentForm(primaryStage));
        
        // Create a menu item for updating a student
        MenuItem updateStudentItem = new MenuItem("Update Student");
        updateStudentItem.setOnAction(event -> updateStudentForm(primaryStage));

        // Create a menu item for listing a student
        MenuItem viewStudentItem = new MenuItem("View Student Details");
        viewStudentItem.setOnAction(event -> viewStudentDetailsForm(primaryStage));

        studentMenu.getItems().addAll(addStudentItem, updateStudentItem, viewStudentItem);
        
        
        // Create the second menu
        Menu courseStudentMenu = new Menu("Course");

        // Create a menu item for adding a course student
        MenuItem addCourseStudentItem = new MenuItem("Add Course Student");
        // Add an action event for adding course students
        addCourseStudentItem.setOnAction(event -> addCourseStudentForm(primaryStage));

        courseStudentMenu.getItems().add(addCourseStudentItem);
        
        //menu bar list
        menuBar.getMenus().addAll(studentMenu, courseStudentMenu);

		
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
		
		return null;
	}
	
	//Starts -> Add, update, view students
	

	private void viewStudentDetailsForm(Stage primaryStage) {
	    formLabel = new Label("VIEW STUDENT DETAILS");
	
	    // Create a table to display student details
	    TableView<Student> studentTable = new TableView<>();
	    TableColumn<Student, Integer> idColumn = new TableColumn<>("ID");
	    TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
	    TableColumn<Student, Integer> ageColumn = new TableColumn<>("Age");
	    TableColumn<Student, Float> gradeColumn = new TableColumn<>("Grade");
	
	    // Set cell value factories for each column
	    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
	    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
	    ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
	    gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
	
	    // Add columns to the table
	    studentTable.getColumns().addAll(idColumn, nameColumn, ageColumn, gradeColumn);
	
	    // Populate the table with student data (replace this with your actual data)
	    List<Student> students = StudentManagement.viewStudentDetails(); // Assuming you have a method to get all students
	    studentTable.getItems().addAll(students);

	    // Set up the layout
	    VBox layout = new VBox(10);
	    layout.getChildren().addAll(
	            menuBar,    // Add the MenuBar
	            formLabel,  // Add the form label
	            studentTable
	    );
	
	    // Update the scene's root with the table
	    primaryStage.getScene().setRoot(layout);
	
	    // Clear the existing label content
	    welcome.setText("");
}


	private void updateStudentForm(Stage primaryStage) {
		formLabel = new Label("UPDATING STUDENT'S INFORMATION");
		//info = new Label("Input Field is Optional -> You Can Leave it BLANK");
		
       
        // Create a VBox to hold input fields
        inputBox = new VBox(10); // 10 is the spacing between fields
        inputBox.getChildren().addAll(
        		formLabel, // Add the form label
        		info,
                new Label("Student ID you want to updated: "), idField,
                new Label("Student's New Name: "), nameField,
                new Label("Student's New Age: "), ageField,
                new Label("Student's New Grade: "), gradeField
        );

        // Set the button to add the student
        Button addButton = new Button("Update Student");
        addButton.setOnAction(event -> updateStudent(primaryStage));


        inputBox.getChildren().addAll(addButton);
        
        root.setTop(menuBar); // Menu bar at the top
        root.setCenter(inputBox); // Form or input fields in the center
        // Add padding to the BorderPane
        root.setPadding(new Insets(20));

        // Wrap the content in a ScrollPane
        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // Update the scene's root with the ScrollPane
        primaryStage.getScene().setRoot(scrollPane);

        // Clear the existing label content
        welcome.setText("");
	}


	private void addStudentForm(Stage primaryStage) {
		formLabel = new Label("ADDING NEW STUDENT");
		
        
        // Create a VBox to hold input fields
        inputBox = new VBox(10); // 10 is the spacing between fields
        inputBox.getChildren().addAll(
        		formLabel, // Add the form label      
                new Label("Student ID: "), idField,
                new Label("Student Name: "), nameField,
                new Label("Student Age: "), ageField,
                new Label("Student Grade: "), gradeField
        );

        // Set the button to add the student
        Button addButton = new Button("Add Student");
        addButton.setOnAction(event -> addStudent(primaryStage));

        inputBox.getChildren().addAll(addButton);
        
        root.setTop(menuBar); // Menu bar at the top
        root.setCenter(inputBox); // Form or input fields in the center
        // Add padding to the BorderPane
        root.setPadding(new Insets(20));

        // Wrap the content in a ScrollPane
        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // Update the scene's root with the ScrollPane
        primaryStage.getScene().setRoot(scrollPane);

        
        // Clear the existing label content
        welcome.setText("");
    }

	
	private void addStudent(Stage primaryStage) {
		
        try {
        	int ID = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            float grade = Float.parseFloat(gradeField.getText());

            // Call the newStudent method with user details
            StudentManagement.newStudent(ID, name, age, grade);
            
            // Display success message at the bottom of input fields
            successLabel = new Label("Student added successfully!");
            inputBox.getChildren().add(successLabel);


        } catch (NumberFormatException e) {
            // Handle invalid input
        	 successLabel = new Label("Error: Invalid input. Please enter valid numbers.");
        	 inputBox.getChildren().add(successLabel);
        }
        
        // Clear the input fields
        idField.clear();
        nameField.clear();
        ageField.clear();
        gradeField.clear();
    }


	private void updateStudent(Stage primaryStage) {
		
        try {
        	int ID = Integer.parseInt(idField.getText());
        	String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            float grade = Float.parseFloat(gradeField.getText());

            // Call the newStudent method with user details
            String msg = StudentManagement.updateStudentInfo(ID, name, age, grade);
            
            // Display success message at the bottom of input fields
            successLabel = new Label(msg);
            inputBox.getChildren().add(successLabel);

            
        } catch (NumberFormatException e) {
            // Handle invalid input
        	 successLabel = new Label("Error: " + e);
        	 inputBox.getChildren().add(successLabel);
        }
        
        // Clear the input fields
        idField.clear();
        nameField.clear();
        ageField.clear();
        gradeField.clear();

    }

	//Ends -> Add, update, view students
}
