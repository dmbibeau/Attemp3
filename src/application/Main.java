package application;
	
import java.io.IOException;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

	public class Main extends Application {
		private static Stage primaryStage;
		private static AnchorPane mainLayout;

	@Override
	public void start(Stage primaryStage) throws IOException {
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("Main Menu");
		showMainMenu();
	}

	public static void showMainMenu() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../GUIs/MainMenuGUI.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void showAddCustMenu() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../GUIs/AddCustomerGUI.fxml"));
		AnchorPane mainItems = loader.load();
		Scene scene = new Scene(mainItems);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Add Customer Menu");
		primaryStage.show();
	}

	public static void showFindCustMenu() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../GUIs/FindCustomerGUI.fxml"));
		AnchorPane mainItems = loader.load();
		Scene scene = new Scene(mainItems);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Find Customer Menu");
		primaryStage.show();
	}
	
	public static void showAddEmpMenu() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../GUIs/AddEmployeeGUI.fxml"));
		AnchorPane mainItems = loader.load();
		Scene scene = new Scene(mainItems);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Add Employee Menu");
		primaryStage.show();
	}
	
	public static void showFindEmpMenu() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../GUIs/FindEmployeeGUI.fxml"));
		AnchorPane mainItems = loader.load();
		Scene scene = new Scene(mainItems);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Find Employee Menu");
		primaryStage.show();
	}
	
	public static void showAddMovieMenu() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../GUIs/AddMovieGUI.fxml"));
		AnchorPane mainItems = loader.load();
		Scene scene = new Scene(mainItems);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Add Movie Menu");
		primaryStage.show();
	}
	
	public static void showFindMovieMenu() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../GUIs/FindMovieGUI.fxml")); 
		AnchorPane mainItems = loader.load();
		Scene scene = new Scene(mainItems);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Find Movie Menu");
		primaryStage.show();
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
		//Database.postEmp();
		//The following line of code will add the movie table. 
		Database.createMovieTable();
		/*The following line will create a table called transaction
		 * if the table isn't already created. But you NEED a 
		 * database called ddt_movies*/
		Database.createTransactionTable();
		/*The following line will create a table called schedule
		 * if the table isn't already created. But you NEED a 
		 * database called ddt_movies*/
		Database.createScheduleTable();

		launch(args);
	}
	
}
