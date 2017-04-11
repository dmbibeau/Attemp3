package Controllers;


import java.io.IOException;

import application.Main;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

import application.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class AddMovieController {

	ObservableList<String> selectionList = FXCollections.observableArrayList("Select", "Add Customer", "Find Customer", "Add Employee", "Find Employee", "Add Movie", "Find Movie");
	@FXML
	private ChoiceBox<String> selectionBox;


	    @FXML
	    private TextField Title;

	    @FXML
	    private TextField Director;

	    @FXML
	    private TextField Genre;

	    @FXML
	    private TextField Actors;

	    @FXML
	    private TextField Year;

	    @FXML
	    private TextField Format;

	    @FXML
	    private TextField Language;

	    @FXML
	    private TextField Barcode;

	    @FXML
	    private Button Submit;

		@FXML
		private void initialize() {
			selectionBox.setItems(selectionList);
			
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
	    
	    public void submitEntry(ActionEvent event) {
			// We can add validation here
	    	Movie.addMovie(Barcode, Title, Director, Genre, Actors, Year, Format, Language);
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
