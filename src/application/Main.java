package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String MYSQL_DRIVER= "com.mysql.jdbc.Driver";
	private static String MYSQL_URL="jdbc:mysql://localhost:3306/ddt_movies?useSSL=false";
	private static String user ="root";
	private static String password="Mond1234";
	private static java.sql.Connection con;

	public static void post() throws Exception{
		try{
				Connection con = getConnection();
				PreparedStatement posted = con.prepareStatement("INSERT INTO customer(name, surname, phone, email, address, credit_card, exp_date, license, dob) VALUES "
																+ "('Dave', 'Romanski', 9991231212, 'dave@email.com', '123 Main Street', '1234432112344321', '2020-02-00', '123456789', '1956-11-23')");
				posted.executeUpdate();
		} catch(Exception e){System.out.println(e);}
		finally {
			System.out.println("Insert Completed");
		}
	}
	
	public static void createTable() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS customer("
					+ "pin int NOT NULL AUTO_INCREMENT, "
					+ "name varchar(10), "
					+ "surname varchar(20), "
					+ "phone bigint(20), "
					+ "email varchar(40), "
					+ "address varchar(40), "
					+ "credit_card varchar(16), "
					+ "exp_date date, "
					+ "license varchar(9), "
					+ "dob date, "
					+ "PRIMARY KEY(pin))");
			create.executeUpdate();
		} catch (Exception e){System.out.println(e);}
		finally{System.out.println("Function complete.");}
		
	}
		
	public static Connection getConnection(){
		
		try{
			Class.forName(MYSQL_DRIVER);
			
			con =  DriverManager.getConnection(MYSQL_URL,user,password);
			
			return con;
		} catch(ClassNotFoundException ex){
			System.out.println("ClassNotFoundException:\n"+ex.toString());
			ex.printStackTrace();
		}catch(SQLException ex){
			System.out.println("SQlESception:\n"+ex.toString());
			ex.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) throws Exception {
		//createTable();
		//post();
		launch(args);
	}
	
}
