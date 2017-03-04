package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloController {
	@FXML
	void handleButton(ActionEvent ae){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("AddCustomerGUI.fxml"));
			Scene scene = new Scene(root,800,800);
			Stage stage = new Stage();
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML	
	public void startFindUI(ActionEvent event) {
		try {
		
			Parent root= FXMLLoader.load(getClass().getResource("FindCustomerGUI.fxml"));
			Scene scene = new Scene(root, 400,400);
			//scene.getStylesheets().add(getClass().getResource("CustomersInfo.fxml").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
