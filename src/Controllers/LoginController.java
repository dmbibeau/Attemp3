package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;

import application.Database;
import application.Employee;
import application.EmployeeDB;
import application.Main;
import application.Person;
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
    	UserClass.createUserTable();
    	
		String passrs = EmployeeDB.getPassword(username);
		
		if (password.getText().equals(passrs)) {			
			Connection con = Database.getConnection();
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE username = '" + username.getText() + "'");
			while (rs.next()) {
				System.out.println(rs.getString("position"));
				UserClass.updateUser(rs.getString("position"));
			}
    		Main.showMainMenu();
		}
		//String strPin = rs.getString("pin");
		//int Pin = Integer.valueOf(strPin);
		//++Pin;
		//pinn.setText("" + Pin);
		
		//select password from employee where username = username.getText();
    	//if (passrs == password.getText()) {
    	//	Database.updateUser(select position from employee where username = username.getText();
    	
//    	if (username.getText().equals("dbibeau") && password.getText().equals("password")) {
//    		Database.updateUser("man");
//    		currentUser.manager = true;
//    		Main.showMainMenu();
//    	}
    	
//    	if (username.getText().equals("tbellon") && password.getText().equals("password")) {
//    		Database.updateUser("emp");
//   		currentUser.manager = false;
//    		Main.showMainMenu();;
//    	}
    	error.setText("Incorrect Username/Password");
    }
}