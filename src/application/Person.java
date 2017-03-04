package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Person {
	@FXML
	private Button addPin;
	@FXML
	private Label pinn;
	@FXML
	private Label addpinn;
	
	@FXML
	private TextField firstName;

	@FXML
	private TextField phoneNum;

	@FXML
	private TextField bDay;

	@FXML
	private TextField email;

	@FXML
	private TextField address;

	@FXML
	private TextField creditCard;

	@FXML
	private TextField lastName;
	
	
	Person(String pinn,String lastName, String firstName ){
		pinn = this.pinn.getText();
	}
}
