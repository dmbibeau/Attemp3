package Controllers;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import application.Employee;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddEmployeeController {

	ObservableList<String> selectionList = FXCollections.observableArrayList("Select", "Add Customer", "Find Customer", "Add Employee", "Find Employee", "Add DVD", "Find DVD");
	@FXML
	private ChoiceBox<String> selectionBox;

	// DEFINE FORM
	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;
	
    @FXML
    private TextField phone;

    @FXML
    private TextField address;

    @FXML
    private TextField payRate;

    @FXML
    private TextField position;

    @FXML
    private TextField dob;

    @FXML
    private Label empID;

/*	@FXML
	public void generatePin(ActionEvent event) throws SQLException {	
		ResultSet rs = Employee.getLastEmpID();
		rs.next();
		String strID = rs.getString("empid");
		int id = Integer.valueOf(strID);
		++id;
		empID.setText("" + id);
	}*/
	
	public void submitEntry(ActionEvent event) throws Exception {
		// We can add validation here
		Employee.addEmp(firstName, lastName, phone, address, payRate, position, dob);
	}
	
	public void clearForm(){
	    firstName.clear();
	    lastName.clear();
	    phone.clear();
	    address.clear();
	    payRate.clear();
	    position.clear();
	    dob.clear();
	}
	
	@FXML
	private void initialize() throws SQLException {
		selectionBox.setItems(selectionList);

		//TESTING!!!
		ResultSet rs = Employee.getLastEmpID();
		rs.next();
		String strID = rs.getString("empid");
		int id = Integer.valueOf(strID);
		++id;
		empID.setText("" + id);
		//END TESTING!!!

		//Listen for selection changes
		selectionBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
			try {
				selectNext(newValue);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	private void selectNext(Object selection) throws IOException {
			String selectionString = selection.toString();
			switch (selectionString) {
			case "Add Customer" 	: Main.showAddCustMenu(); break;
			case "Find Customer" 	: Main.showFindCustMenu(); break;
			case "Add Employee" 	: Main.showAddEmpMenu(); break;
			case "Find Employee" 	: Main.showFindEmpMenu(); break;
			case "Add DVD" 			: Main.showAddMovieMenu(); break;
			case "Find DVD" 		: Main.showFindMovieMenu(); break;
			default : System.out.println("Error! Unknown selection!");
			}
	}
}