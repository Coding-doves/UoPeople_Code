package application;
	
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	//private BorderPane root;
	
	@Override
	public void start(Stage primaryStage) {
		Button btn = new Button("Add new student");
		Button btn2 = new Button("Update new student");
		Button btn3 = new Button("View student details");
		Button btn4 = new Button("Return Home");
		
		// Create a VBox to hold the buttons
        VBox buttonBox = new VBox(10); // 10 is the spacing between buttons
        buttonBox.getChildren().addAll(btn, btn2, btn3, btn4);

		//create two panes
		StackPane leftPane = new StackPane();
		leftPane.getChildren().addAll(buttonBox, new Label("Left Pane"));
		
		StackPane rightPane = new StackPane();
		leftPane.getChildren().add(new Label("right Pane"));
		
		// Create a SplitPane and set the orientation to VERTICAL
		SplitPane splitPane = new SplitPane();
		splitPane.setOrientation(javafx.geometry.Orientation.HORIZONTAL);
		splitPane.getItems().addAll(leftPane, rightPane);
		
		// Set the preferred size for each pane
        leftPane.setPrefSize(50, 400);
        rightPane.setPrefSize(350, 400);
		
	        
		Scene scene = new Scene(splitPane, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setTitle("Admin Dashboard");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//load();
			
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**public void load() throws FileNotFoundException{
		
		
		btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				try {
                    StudentManagement.newStudent();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
			}

		});
		
		btn2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("WELCOME!!! Administrator, option?");
			}

		});

		btn3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("WELCOME!!! Administrator, what ?");
			}

		});


		root.getChildren().add(btn);
		root.getChildren().add(btn2);
		root.getChildren().add(btn3);
		root.getChildren().add(btn4);
	}*/
}
