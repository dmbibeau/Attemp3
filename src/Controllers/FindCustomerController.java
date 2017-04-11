package Controllers;

import java.io.IOException;
//import java.sql.Connection;
//import java.util.*;
//import java.sql.PreparedStatement;

import application.CustomerDB;
import application.Database;
import application.Main;
import application.Person;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FindCustomerController { 
	
	ObservableList<String> selectionList = FXCollections.observableArrayList("Select", "Add Customer", "Find Customer", "Add Employee", "Find Employee", "Add Movie", "Find Movie");
	@FXML
	private ChoiceBox<String> selectionBox;

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
    private Button removeCust;
	
    @FXML
    void removeCust(ActionEvent event) throws Exception{
    	ObservableList<Person> customerSelected, allCustomers;
    	allCustomers = table.getItems();
    	customerSelected = table.getSelectionModel().getSelectedItems();
    	
    	Database.removeCust(customerSelected.get(0).getPin());    	
    	customerSelected.forEach(allCustomers::remove);
    }
	@FXML
    void submitEntry(ActionEvent event) throws Exception{
		CustomerDB customernew = new CustomerDB();
		int id = Integer.parseInt(ID.getText());
		
		ObservableList<Person> custout = customernew.findInfo(id);
		first.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		last.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		pin.setCellValueFactory(new PropertyValueFactory<Person, Integer>("pin"));
		address.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));
		phone.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNum"));
		table.setItems(custout);
	}
	
	@FXML
	private void initialize() {
		selectionBox.setItems(selectionList);
		
		//Listen for selection changes
		selectionBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
			try {
				selectNext(newValue);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} );
	}
	
	private void selectNext(Object selection) throws IOException {
			String selectionString = selection.toString();
			switch (selectionString) {
			case "Add Customer" 	: Main.showAddCustMenu(); break;
			case "Find Customer" 	: Main.showFindCustMenu(); break;
			case "Add Employee" 	: Main.showAddEmpMenu(); break;
			case "Find Employee" 	: Main.showFindEmpMenu(); break;
			case "Add Movie" 			: Main.showAddMovieMenu(); break;
			case "Find Movie" 		: Main.showFindMovieMenu(); break;
			default : System.out.println("Error! Unknown selection!");
			}
	}
}