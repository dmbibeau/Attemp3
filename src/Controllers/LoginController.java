package Controllers;

import application.Database;
import application.Main;
import application.UserClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	private Label error;
	
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    @FXML
    private Button submit;
    
    @FXML
    void submit(ActionEvent event) throws Exception {
		UserClass currentUser = new UserClass();
		UserClass.dropCurrTable();
    	Database.createUserTable();
    	if (username.getText().equals("dbibeau") && password.getText().equals("password")) {
    		Database.updateUser("man");
    		currentUser.manager = true;
    		Main.showMainMenu();
    	}
    	
    	if (username.getText().equals("tbellon") && password.getText().equals("password")) {
    		Database.updateUser("emp");
    		currentUser.manager = false;
    		Main.showMainMenu();;
    	}
    	error.setText("Incorrect Username/Password");
    }
}