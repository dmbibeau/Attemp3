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
import javafx.scene.control.Label;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddMovieController {

	ObservableList<String> selectionList = FXCollections.observableArrayList("Select", "Add Customer", "Find Customer",
			"Add Employee", "Find Employee", "Add Movie", "Find Movie");
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
	private Label barError;

	@FXML
	private Label directError;

	@FXML
	private Label genreError;
	@FXML
	private Label added;

	@FXML
	private Label actorError;

	@FXML
	private Label yearError;

	@FXML
	private Label fError;

	@FXML
	private Label langError;

	@FXML
	private Label titleError;

	@FXML
	private void initialize() {
		selectionBox.setItems(selectionList);

		// Listen for selection changes
		selectionBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			try {
				selectNext(newValue);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public void submitEntry(ActionEvent event) {
		boolean flag = true;

		if (Title.getText().isEmpty() || Director.getText().isEmpty() || Genre.getText().isEmpty()
				|| Actors.getText().isEmpty() || Year.getText().isEmpty() || Format.getText().isEmpty()
				|| Barcode.getText().isEmpty() || Language.getText().isEmpty()) {
			flag = false;
		}
		if(Title.getText().matches(".*\\d.*")){
			titleError.setText("invalid title");
			flag = false;
		}
		if(Actors.getText().matches(".*\\d.*")){
			actorError.setText("letters only");
			flag = false;
		}
		if(Director.getText().matches(".*\\d.*")){
			directError.setText("letters only");
			flag = false;
		}
		if(Genre.getText().matches(".*\\d.*")){
			genreError.setText("letters only");	
			flag = false;
		}
		if(Year.getText().length()!=4||!Year.getText().matches(".*\\d.*")){
			yearError.setText("4 numbers only");
			flag = false;
		}
		if(!Barcode.getText().matches(".*\\d.*")){
			barError.setText("numbers only");
			flag = false;
			}
		if(Language.getText().matches(".*\\d.*")){
			langError.setText("letters only");
			flag = false;
		}
		if(flag){
		
		   
		Movie.addMovie(Barcode, Title, Director, Genre, Actors, Year, Format, Language);
		added.setText("movie added");
		}
		}

	private void selectNext(Object selection) throws IOException {
		String selectionString = selection.toString();
		switch (selectionString) {
		case "Add Customer":
			Main.showAddCustMenu();
			break;
		case "Find Customer":
			Main.showFindCustMenu();
			break;
		case "Add Employee":
			Main.showAddEmpMenu();
			break;
		case "Find Employee":
			Main.showFindEmpMenu();
			break;
		case "Add Movie":
			Main.showAddMovieMenu();
			break;
		case "Find Movie":
			Main.showFindMovieMenu();
			break;
		default:
			System.out.println("Error! Unknown selection!");
		}
	}

}
