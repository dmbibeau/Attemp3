package Controllers; 
 
 
 import java.io.IOException; 
 //import java.sql.Connection; 
 //import java.sql.PreparedStatement; 
 import java.sql.ResultSet; 
 import java.sql.SQLException; 
 //import java.sql.Statement; 
 
 
 import application.Employee; 
 import application.Main; 
 import application.UserClass; 
 import javafx.collections.FXCollections; 
 import javafx.collections.ObservableList; 
 import javafx.event.ActionEvent; 
 import javafx.fxml.FXML; 
 import javafx.scene.control.ChoiceBox; 
 import javafx.scene.control.Label; 
 import javafx.scene.control.TextField; 
 
 
 public class AddEmployeeController { 
 
 
 	ObservableList<String> selectionList = FXCollections.observableArrayList("Select", "Add Customer", "Find Customer", "Add Employee", "Find Employee", "Add Movie", "Find Movie"); 
 	@FXML 
 	private ChoiceBox<String> selectionBox; 
 
 
 	// DEFINE FORM 
 	@FXML 
	private TextField firstName; 
 
  	@FXML 
 	private TextField lastName; 
 	 
     @FXML 
     private TextField phone; 
 
 
     @FXML 
     private TextField address; 
 
 
     @FXML 
     private TextField payRate; 
 
 
     @FXML 
     private TextField position; 
 
 
     @FXML 
     private TextField dob; 
 
 
     @FXML 
     private Label empID; 
      
     @FXML 
     private Label currUser; 
     
     @FXML
 	private Label DOBerror;

 	@FXML
 	private Label phError;

 	@FXML
 	private Label payError;

 	@FXML
 	private Label posError;

 	@FXML
 	private Label fnError;

 	@FXML
 	private Label lnError;

 	@FXML
 	private Label added;

 
 /*	@FXML 
 	public void generatePin(ActionEvent event) throws SQLException {	 
 		ResultSet rs = Employee.getLastEmpID(); 
 		rs.next(); 
 		String strID = rs.getString("empid"); 
 		int id = Integer.valueOf(strID); 
 		++id; 
 		empID.setText("" + id); 
 	}*/ 
 	 
 	public void submitEntry(ActionEvent event) throws Exception {
		// We can add validation hereif (pinn.getText().isEmpty() ||
		// bDay.getText().isEmpty() || exp_date.getText().isEmpty()
		boolean flag = true;

		if (address.getText().isEmpty() || phone.getText().isEmpty() || lastName.getText().isEmpty()
				|| firstName.getText().isEmpty()||payRate.getText().isEmpty()|| position.getText().isEmpty()
				||dob.getText().isEmpty()) {
			added.setText("empty feilds");
			// Null validation for all fields
			// Maybe change this to tell which field is empty/in error
			flag = false;
		}
		if (firstName.getText().matches(".*\\d.*")) {
			fnError.setText("invalid name");
			flag = false;
		}
		if (lastName.getText().matches(".*\\d.*")) {
			lnError.setText("invalid name");
			flag = false;
		}
		if (phone.getText().length() != 10 || !phone.getText().matches(".*\\d.*")) {// for
																					// a
																					// number
			phError.setText("10 digits");
			flag = false;
		}
		if (position.getText().matches(".*\\d.*")) {
			posError.setText("chars only");
			flag = false;
		}

		if (!dob.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
			DOBerror.setText("YYYY-MM-DD");
			flag = false;
		}

		if (!payRate.getText().matches((".*\\d.*"))) {
			payError.setText("must be number");
			flag = false;
		}
		if (flag) {
			Employee.addEmp(firstName, lastName, phone, address, payRate, position, dob);
			added.setText("Employee added");
		}
	} 
 	 
 	public void clearForm(){ 
 	    firstName.clear(); 
 	    lastName.clear(); 
 	    phone.clear(); 
 	    address.clear(); 
	    payRate.clear(); 
 	    position.clear(); 
 	    dob.clear(); 
 	} 
 	 
 	@FXML 
 	private void initialize() throws SQLException { 
 		selectionBox.setItems(selectionList); 
 		 
 		ResultSet rs2 = UserClass.getPosition(); 
 		rs2.next(); 
 		System.out.println(rs2.getString("position")); 
 		currUser.setText(rs2.getString("position")); 
 
 
 		//TESTING!!! 
 		ResultSet rs = Employee.getLastEmpID(); 
 		rs.next(); 
 		String strID = rs.getString("empid"); 
 		int id = Integer.valueOf(strID); 
 		++id; 
 		empID.setText("" + id); 
 		//END TESTING!!! 
 
 
 		//Listen for selection changes 
 		selectionBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> { 
 			try { 
 				selectNext(newValue); 
 			} catch (IOException e) { 
 				// TODO Auto-generated catch block 
 				e.printStackTrace(); 
 			} 
 		}); 
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
			default : System.out.println("Error! Unknown selection!");  			} 
 	} 
} 

