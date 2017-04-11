package Controllers;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import application.Main;
import application.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCustomerController {

	ObservableList<String> selectionList = FXCollections.observableArrayList("Select", "Add Customer", "Find Customer", "Add Employee", "Find Employee", "Add Movie", "Find Movie");
	@FXML
	private ChoiceBox<String> selectionBox;

	@FXML
	private Label pinn;
	
	@FXML
	private Label alert;
	
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
    private TextField bDay;

/*	@FXML
	public void generatePin(ActionEvent event) throws SQLException {
		ResultSet rs = Person.getLastPin();
		rs.next();
		
		String strPin = rs.getString("pin");
		int Pin = Integer.valueOf(strPin);
		++Pin;
		pinn.setText("" + Pin);
	}*/
	
	public void submitEntry(ActionEvent event) {
		// We can add validation here
		//Person.addCust(firstName, lastName, phone, email, address, creditCard, exp_date, bDay);
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
					if(!creditCard.getText().contains("abcdefghijkllmnopqrstuvwxyz")){
						if(email.getText().endsWith("@g.fmarion.edu")||email.getText().endsWith("@gmail.com")){
							if(phone.getText().length()==10){
								if(!phone.getText().contains("abcdefghijklmnopqrstuvwxyz")){
									Person.addCust(firstName, lastName, phone, email, address, creditCard, exp_date, bDay);
									alert.setText("New Customer Added.");
									clearForm();
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
	    exp_date.clear();
	    lastName.clear();
	}
	
	@FXML
	private void initialize() throws SQLException {
		selectionBox.setItems(selectionList);
		
		//TESTING!!!
		ResultSet rs = Person.getLastPin();
		rs.next();
		
		String strPin = rs.getString("pin");
		int Pin = Integer.valueOf(strPin);
		++Pin;
		pinn.setText("" + Pin);
		//END TESTING!!!
		
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