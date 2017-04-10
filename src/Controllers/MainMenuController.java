package Controllers;

import java.io.IOException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class MainMenuController {
	ObservableList<String> selectionList = FXCollections.observableArrayList("Select", "Add Customer", "Find Customer", "Add Employee", "Find Employee", "Add DVD", "Find DVD");
	
	@FXML
	private ChoiceBox selectionBox;
	
/*	@FXML
	public void gotoCustMenu(ActionEvent ae) throws IOException{
			Main.showCustMenu();
	}*/
	
/*	@FXML	
	public void gotoDVDMenu(ActionEvent event) {
		try {
			Parent root= FXMLLoader.load(getClass().getResource("../GUIs/FindCustomerGUI.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("DVD menu");
			stage.setScene(scene);
			stage.show();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML	
	public void gotoEmpMenu(ActionEvent event) throws IOException {
		Main.showEmpMenu();
	}*/
	
	@FXML
	private void initialize() {
		selectionBox.setItems(selectionList);
		selectionBox.setValue("Select");
		
		//Listen for selection changes
		selectionBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
			try {
				selectNext(newValue);
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
			case "Add DVD" 			: Main.showAddMovieMenu(); break;
			case "Find DVD" 		: Main.showFindMovieMenu(); break;
			default : System.out.println("Error! Unknown selection!");
			}
	}
}
