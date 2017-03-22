package application;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FindCustomerController { 
	@FXML
    private TextField ID;

    @FXML
    private Button findCust;
	
	@FXML
    void submitEntry(ActionEvent event) throws Exception{
		System.out.println(event.getSource());
		try{
			Connection con = Database.getConnection();
			Statement stmt = con.createStatement();
			//PreparedStatement find = con.prepareStatement("SELECT surname FROM customer WHERE pin = 5;");
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE pin = " + ID.getText() +";");
			System.out.println(ID.getText());
			System.out.println(rs.next());
			//find.executeUpdate();
		}catch (Exception ex) {System.out.println(ex);}

    }
    
 //   @FXML
 //   void searchDB(ActionEvent event) {
 //   	String query = ID.getText();


//    @FXML
 //   private Button Searchy;

//    @FXML
//    void searchDB(ActionEvent event) {
    	
//    	String query = ID.getText();
    	
    	

 //   }
    @FXML	
	public void getName(ActionEvent event) {

	
		}
	}