package Controllers;

import java.io.IOException;

import application.Main;
import application.Movie;
import application.MovieDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class FindMovieController {
	
	ObservableList<String> selectionList = FXCollections.observableArrayList("Select", "Add Customer", "Find Customer", "Add Employee", "Find Employee", "Add Movie", "Find Movie");
	@FXML
	private ChoiceBox<String> selectionBox;

    @FXML
    private Button findCust;

    @FXML
    private TextField ID;

    @FXML
    private TableView<Movie> table;

    @FXML
    private TableColumn<Movie, Integer> Bar;

    @FXML
    private TableColumn<Movie, String> title;

    @FXML
    private TableColumn<Movie, String> genre;

    @FXML
    private TableColumn<Movie, String> actor;

    @FXML
    private TableColumn<Movie, Integer> year;

    @FXML
    private TableColumn<Movie, String> director;

    @FXML
    private TableColumn<Movie, String> language;
    
    @FXML
    void submitEntry(ActionEvent event) throws Exception{
		MovieDB customernew = new MovieDB();
		try{
			int id = Integer.parseInt(ID.getText());
			ObservableList<Movie> custout = customernew.findInfoInt(id);
			Bar.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("barcode"));
			title.setCellValueFactory(new PropertyValueFactory<Movie, String>("title"));
			director.setCellValueFactory(new PropertyValueFactory<Movie, String>("director"));
			actor.setCellValueFactory(new PropertyValueFactory<Movie, String>("actors"));
			year.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("year"));
			genre.setCellValueFactory(new PropertyValueFactory<Movie, String>("genre"));
			language.setCellValueFactory(new PropertyValueFactory<Movie, String>("language"));
			table.setItems(custout);
		}
		catch(Exception e){
			
			String id = ID.getText();
			ObservableList<Movie> custout = customernew.findInfoString(id);
			Bar.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("barcode"));
			title.setCellValueFactory(new PropertyValueFactory<Movie, String>("title"));
			director.setCellValueFactory(new PropertyValueFactory<Movie, String>("director"));
			actor.setCellValueFactory(new PropertyValueFactory<Movie, String>("actors"));
			year.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("year"));
			genre.setCellValueFactory(new PropertyValueFactory<Movie, String>("genre"));
			language.setCellValueFactory(new PropertyValueFactory<Movie, String>("language"));
			table.setItems(custout);
			
		}
		

	}
    
	@FXML
	private void initialize() {
		selectionBox.setItems(selectionList);
		
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