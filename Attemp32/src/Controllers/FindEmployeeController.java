package Controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Database;
import application.Employee;
import application.EmployeeDB;
import application.Main;
import application.UserClass;
//import application.Person;
//import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FindEmployeeController {

	ObservableList<String> selectionList = FXCollections.observableArrayList("Select", "Add Customer", "Find Customer", "Add Employee", "Find Employee", "Add Movie", "Find Movie");
	@FXML
	private ChoiceBox<String> selectionBox;

	@FXML
    private Button findCust;

    @FXML
    private TextField ID;

    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, String> fName;

    @FXML
    private TableColumn<Employee, String> lName;

    @FXML
    private TableColumn<Employee, Integer> pin;

    @FXML
    private TableColumn<Employee, String> address;

    @FXML
    private TableColumn<Employee, String> phone;
    
    @FXML
    private TableColumn<Employee, String> position;
    
    @FXML
    private TableColumn<Employee, Double> pay;
    
    @FXML
    private Button removeEmp;
    
    @FXML
    private Button scheduleButton;
    
    @FXML
    private Label accessLabel;
    
    @FXML
    void removeEmp(ActionEvent event) throws Exception{
    	ObservableList<Employee> employeeSelected, allEmployees;
    	allEmployees = table.getItems();
    	employeeSelected = table.getSelectionModel().getSelectedItems();
    	
    	Database.removeEmp(employeeSelected.get(0).getPin());    	
    	employeeSelected.forEach(allEmployees::remove);
    }
    
    @FXML
    void scheduleButton(ActionEvent event) throws SQLException {
		ResultSet rs2 = UserClass.getPosition();
		rs2.next();
		String currPosition = rs2.getString("position");
		System.out.println("Schedule!" + currPosition);
		if (currPosition.compareTo("Manager")==0) {
			accessLabel.setText("ACCESS GRANTED");
			System.out.println("Manager");
		}
		if (currPosition.compareTo("Employee")==0) {
			accessLabel.setText("ACCESS DENIED");
			System.out.println("Employee");
		}
//		System.out.println(rs2.getString("position"));
//		currUser.setText(rs2.getString("position"));

    }
    
    @FXML
    void submitEntry(ActionEvent event) throws Exception{
		EmployeeDB customernew = new EmployeeDB();
		try{
			int id = Integer.parseInt(ID.getText());
			ObservableList<Employee> custout = customernew.findInfoInt(id);
			fName.setCellValueFactory(new PropertyValueFactory<Employee, String>("fName"));
			lName.setCellValueFactory(new PropertyValueFactory<Employee, String>("lName"));
			pin.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("pin"));
			address.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
			phone.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone"));
			position.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
			System.out.println(position.getText());
			pay.setCellValueFactory(new PropertyValueFactory<Employee, Double>("pay"));
			table.setItems(custout);
			System.out.println(custout.get(0).getPosition());
		}
		catch(Exception e){	
			//tried to fill tableview with table if the field is blank... not working
			System.out.println("Error!");
			Database.fillEmpTable();
			//table.setItems(Database.fillEmpTable());
/*			String id = ID.getText();
			ObservableList<Employee> custout = customernew.findInfoString(id);
			fName.setCellValueFactory(new PropertyValueFactory<Employee, String>("fName"));
			lName.setCellValueFactory(new PropertyValueFactory<Employee, String>("lName"));
			pin.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("pin"));
			address.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
			phone.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone"));
			position.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
			pay.setCellValueFactory(new PropertyValueFactory<Employee, Double>("pay"));
			table.setItems(custout);
			*/
		}
	}
	@FXML
	private void initialize() {
		selectionBox.setItems(selectionList);
		//selectionBox.setValue(oldValue);
		 
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
