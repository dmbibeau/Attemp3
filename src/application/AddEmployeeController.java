package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
//    @FXML
//    private TextField exp_date;
	    
//    @FXML
//    private TextField bDay;

	@FXML
	public void generatePin(ActionEvent event) {	
		//System.out.println(event.getSource());
		try {
		createPin1();	
		} catch (Exception ex) { System.out.println("blah");}
	}
	
	public void submitEntry(ActionEvent event) throws Exception {
		System.out.println(event.getSource());
		try {
			Connection con = Database.getConnection();		
			PreparedStatement posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob) VALUES "
					+ "('" + firstName.getText()
					+"', '"+ lastName.getText()      
					+"', '"+ phone.getText()         
					+"', '"+ address.getText()
					+"', '"+ payRate.getText()
					+"', '"+ position.getText()
					+"', '"+ dob.getText()
					+"')");
			posted.executeUpdate();
		}catch (Exception ex) {System.out.println(ex);}
	}
	
	public void createPin1() throws Exception{
		try{
			Connection con = Database.getConnection();		
			String query = "SELECT max(empid) as empid FROM employee";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
						
			String strID = rs.getString("empid");
			int id = Integer.valueOf(strID);
			++id;
			empID.setText("" + id);
		} catch (Exception e){System.out.println(e);}		
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