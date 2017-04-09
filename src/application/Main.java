package application;
	
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainGUI.fxml"));
			Scene scene = new Scene(root,400,400);
			primaryStage.setTitle("Main Menu");
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) { e.printStackTrace(); }
	}

	public static void main(String[] args) throws Exception {
		/* The following line will create a table called customer 
		 * if the table isn't already created. But you NEED a 
		 * database called ddt_movies*/
		Database.createCustTable();
		/* The following line will add a line to the table customer. */
		Database.postCust();
		/* The following line will create a table called employee
		 * if the table isn't already created. But you NEED a 
		 * database called ddt_movies*/
		Database.createEmpTable();
		/* The following line will add a line to the table customer. */
		Database.postEmp();
		//The following line of code will add the movie table.
		Database.createMovieTable();
		
		launch(args);
	}
	
}
