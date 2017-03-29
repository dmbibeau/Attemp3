package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddEmployeeController {

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

	@FXML
	public void generatePin(ActionEvent event) throws SQLException {	
		ResultSet rs = Employee.getLastEmpID();
		rs.next();
		String strID = rs.getString("empid");
		int id = Integer.valueOf(strID);
		++id;
		empID.setText("" + id);
	}
	
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
}