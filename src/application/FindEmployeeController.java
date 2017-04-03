package application;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FindEmployeeController {

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
			pay.setCellValueFactory(new PropertyValueFactory<Employee, Double>("pay"));
			table.setItems(custout);
		}
		catch(Exception e){
			
			String id = ID.getText();
			ObservableList<Employee> custout = customernew.findInfoString(id);
			fName.setCellValueFactory(new PropertyValueFactory<Employee, String>("fName"));
			lName.setCellValueFactory(new PropertyValueFactory<Employee, String>("lName"));
			pin.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("pin"));
			address.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
			phone.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone"));
			position.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
			pay.setCellValueFactory(new PropertyValueFactory<Employee, Double>("pay"));
			table.setItems(custout);
			
		}
		

	}
    
    
    

}
