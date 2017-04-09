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

public class AddCustomerController {

	@FXML
	private Label pinn;
	
	@FXML
	private Label addpinn;
	
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phone;

    @FXML
    private Label alert;
    
    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    private TextField creditCard;
    
    @FXML
    private TextField exp_date;
	    
    @FXML
    private TextField bDay;

	@FXML
	public void generatePin(ActionEvent event) throws SQLException {
		ResultSet rs = Person.getLastPin();
		rs.next();
		
		String strPin = rs.getString("pin");
		int Pin = Integer.valueOf(strPin);
		++Pin;
		pinn.setText("" + Pin);
	}
	
	public void submitEntry(ActionEvent event) {
		// We can add validation here
		if(pinn.getText().isEmpty()||
				bDay.getText().isEmpty()||
				exp_date.getText().isEmpty()||
				creditCard.getText().isEmpty()||
				address.getText().isEmpty()||
				email.getText().isEmpty()||
				phone.getText().isEmpty()||
				lastName.getText().isEmpty()||
				firstName.getText().isEmpty()){/*Null validation for all feilds*/ 
			alert.setText("One or more feilds are empty and make sure PIN is filled.");
				
		} 
		else{
			if(creditCard.getText().length()==16){/*Credit card must be equal to 16 charaters long*/ 
					if(creditCard.getText().contains("abcdefghijkllmnopqrstuvwxyz")){
						if(email.getText().endsWith("@g.fmarion.edu")||email.getText().endsWith("@gmail.com")){
							if(phone.getText().length()==10){
								if(phone.getText().contains("abcdefghijklmnopqrstuvwxyz")){
									Person.addCust(firstName, lastName, phone, email, address, creditCard, exp_date, bDay);
								}
							}
						}
						
					}
				} 
		}
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