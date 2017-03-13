package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCustomerController {
	// private java.sql.Connection con;

	@FXML
	private Label pinn;
	@FXML
	private Label addpinn;
	
	// DEFINE FORM
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    private TextField creditCard;
    
    @FXML
    private TextField exp_date;
	
    @FXML
    private TextField license;
    
    @FXML
    private TextField bDay;

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
			PreparedStatement posted = con.prepareStatement("INSERT INTO customer(name, surname, phone, email, address, credit_card, exp_date, license, dob) VALUES "
					+ "('" + firstName.getText()
					+"', '"+ lastName.getText()      
					+"', '"+ phone.getText()         
					+"', '"+ email.getText()
					+"', '"+ address.getText()
					+"', '"+ creditCard.getText()
					+"', '"+ exp_date.getText()
					+"', '"+ license.getText()
					+"', '"+ bDay.getText()
					+"')");
			posted.executeUpdate();
		}catch (Exception ex) {System.out.println(ex);}
	}
	
	public void createPin1() throws Exception{
		try{
			Connection con = Database.getConnection();		
			String query = "SELECT max(pin) as pin FROM customer";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
						
			String strPin = rs.getString("pin");
			int Pin = Integer.valueOf(strPin);
			++Pin;
			pinn.setText("" + Pin);
		} catch (Exception e){System.out.println(e);}		
	}
	
	public void clearForm(){
	    firstName.clear();
	    phone.clear();
	    bDay.clear();
	    email.clear();
	    address.clear();
	    creditCard.clear();
	    lastName.clear();
	}
}