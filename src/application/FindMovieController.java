package application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class FindMovieController {
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
    
}
