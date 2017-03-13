package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import javafx.beans.property.Property;
//import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.stage.Stage;

//import javafx.scene.control.TableView;
//import javafx.scene.control.TableColumn;


public class AddCustomerController {
	@FXML
	private Label pinn;
	@FXML
	private Label addpinn;
//	int pin = 0;
	
	//DEFINE FORM
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phone;

    @FXML
    private TextField bDay;

    @FXML
    private TextField license;
    
    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    private TextField creditCard;
    
    @FXML
    private TextField exp_date;

	//@FXML
	//private Button addPin;
	
//	HashSet<Integer> store = new HashSet<Integer>();
	@FXML
/*	public void generatePin(ActionEvent event) throws Exception {
	public void checkNums(ActionEvent event){
		String num=creditCard.getText();	
		String ph= phone.getText();
		if(num.length()>=16){
			creditCard.setText("");
			
		}
	
		else if (ph.length()>=10){
			phone.setText("");
		}
		else {
			create();
		}
			
	}*/
	public void create(){
		@SuppressWarnings("unused")
		int i =0;
		String o=bDay.getText();
		DateFormat format= new SimpleDateFormat("yyyyMMdd");
		Person customer = new Person();
		Date date ;
		
		try {
			date = format.parse(o);
//		    customer = new Person(Integer.parseInt(pinn.getText()), lastName.getText(), firstName.getText(), creditCard.getText(), phoneNum.getText(), date, address.getText());
		    CustomerDB customerDB = new CustomerDB(customer);
			try {
				customerDB.addInfo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		//System.out.println(customer.getAddress() +customer.getAddress() +);
	}
	
	@FXML
	public void generatePin(ActionEvent event) {
		
		System.out.println(event.getSource());
				try {
					createPin1();	
			// also need to do check if pin = 10000 if so set back to 0
		//	HashSet<Integer> store = new HashSet<Integer>();
//			if (event.getSource() == addPin) {
				//createPin1(pin, store);
				
					//createPin1(pin, store);
//				createPin1();

		} catch (Exception ex) {
			System.out.println("blah");
		}

	}
	public void submitEntry(ActionEvent event) throws Exception {
		//System.out.println(event.getSource());
		try{
			Connection con = getConnection();
			System.out.println(firstName.getText());
			PreparedStatement posted = con.prepareStatement("INSERT INTO customer(name, surname, phone, email, address, credit_card, exp_date, license, dob) VALUES "
					+ "('" + firstName.getText()
					+"', '"+ lastName.getText()      
					+"', '"+ phone.getText()         
					+"', '"+ email.getText()
					+"', '"+ address.getText()
					+"', '"+ creditCard.getText()
					+"', '"+ exp_date.getText() //"2020-02-00"
					+"', '"+ license.getText()
					+"', '"+ bDay.getText()
					+"')");
			posted.executeUpdate();
		}catch (Exception ex) {
			System.out.println(ex);
		}
	

//	@SuppressWarnings("rawtypes")
//	public void createPin1(int pin) {
		
		/* 
		 * 
		 */
//		if (!store.contains(pin)) {
//			if (10000 > pin) {
//				pin++;

//				pinn.setText("" +String.valueOf(pin) );
//			}
//			store.add(pin);

//		finally{System.out.println("Entry added.");}
	}
	
	private static String MYSQL_DRIVER= "com.mysql.jdbc.Driver";
	private static String MYSQL_URL="jdbc:mysql://localhost:3306/ddt_movies?useSSl=false";
	private static String user ="root";
	private static String password="Mond1234";
	private static java.sql.Connection con;
	
	public static Connection getConnection(){
		
		try{
			Class.forName(MYSQL_DRIVER);
			
			con=  DriverManager.getConnection(MYSQL_URL,user,password);
			
			return con;
		} catch(ClassNotFoundException ex){
			System.out.println("ClassNotFoundException:\n"+ex.toString());
			ex.printStackTrace();
		}catch(SQLException ex){
			System.out.println("SQlESception:\n"+ex.toString());
			ex.printStackTrace();
		}
		return null;
	}	
	
	//public void createPin1(int pin,HashSet Store) throws Exception{
	public void createPin1() throws Exception{
		try{
			Connection con = getConnection();		
			String query = "SELECT max(pin) as pin FROM customer";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
						
			String strPin = rs.getString("pin");
			int Pin = Integer.valueOf(strPin);
			++Pin;
			pinn.setText("" + Pin);
		} catch (Exception e){System.out.println(e);}
//		finally{System.out.println("Function complete.");}

		
//		if (!store.contains(pin)) {
//			if (10000 > pin) {
//				pin++;
				
				//pinn.setText("" +String.valueOf(pin)+1 );
//			}
//			store.add(pin);

//		}
//	else 
//createPin1(pin++, store);}
//		Property<String> valueProperty;
//		valueProperty.;
//		Label myLabel = new Label("Start");
//		myLabel.textProperty().bind(valueProperty);
	}
	
//	public void onAddItem(ActionEvent event){
//		Table entry = new Table(firstName, phoneNum,bDay, email, address, creditCard lastName);
//	}
	
	public void clearForm(){
	    firstName.clear();
	    phone.clear();
	    bDay.clear();
	    email.clear();
	    address.clear();
	    creditCard.clear();
	    lastName.clear();
	}
}