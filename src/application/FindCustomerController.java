package application;

import java.sql.Connection;
import java.util.*;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FindCustomerController { 
	@FXML
    private TextField ID;

    @FXML
    private Button findCust;
    
    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, String> first;

    @FXML
    private TableColumn<Person, String> last;

    @FXML
    private TableColumn<Person, Integer> pin;

    @FXML
    private TableColumn<Person, String> address;

    @FXML
    private TableColumn<Person, String> phone;
	
	@FXML
    void submitEntry(ActionEvent event) throws Exception{
		CustomerDB customernew = new CustomerDB();
		int id = Integer.parseInt(ID.getText());
		
		ObservableList<Person> custout = customernew.findInfo(id);
	System.out.println(custout.get(0).toString());
		first.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		last.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		pin.setCellValueFactory(new PropertyValueFactory<Person, Integer>("Pin"));
		address.setCellValueFactory(new PropertyValueFactory<Person, String>("Address"));
		phone.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNum"));
		table.setItems(custout);
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