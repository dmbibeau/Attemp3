package application;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class AddMovieController {



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

	    
	    
	    public void submitEntry(ActionEvent event) {
			// We can add validation here
	    	Movie.addMovie(Barcode, Title, Director, Genre, Actors, Year, Format, Language);
		}
	

	
}
