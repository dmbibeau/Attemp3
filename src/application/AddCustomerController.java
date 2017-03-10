package application;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCustomerController {
	@FXML
	private Button addPin;
	@FXML
	private Label pinn;
	@FXML
	private Label addpinn;
	int pin = 0;
	
	   @FXML
	    private TextField firstName;

	    @FXML
	    private TextField phoneNum;

	    @FXML
	    private TextField bDay;

	    @FXML
	    private TextField email;

	    @FXML
	    private TextField address;

	    @FXML
	    private TextField creditCard;

	    @FXML
	    private TextField lastName;

	
	HashSet<Integer> store = new HashSet<Integer>();
	@FXML
	public void checkNums(ActionEvent event){
		String num=creditCard.getText();	
		String ph= phoneNum.getText();
		if(num.length()>=16){
			creditCard.setText("");
			
		}
	
		else if (ph.length()>=10){
			phoneNum.setText("");
		}
		else {
			create();
		}
			
	}
	public void create(){
		@SuppressWarnings("unused")
		int i =0;
		String o=bDay.getText();
		DateFormat format= new SimpleDateFormat("yyyyMMdd");
		Person customer = new Person();
		Date date ;
		
		try {
			date = format.parse(o);
		    customer = new Person(Integer.parseInt(pinn.getText()), lastName.getText(), firstName.getText(), creditCard.getText(), phoneNum.getText(), date, address.getText());
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
			// also need to do check if pinn = 10000 if so set back to 0
		//	HashSet<Integer> store = new HashSet<Integer>();
			if (event.getSource() == addPin) {
				//createPin1(pin, store);
			

				
					createPin1(pin, store);

		}} catch (Exception ex) {
			System.out.println("blah");
		}

	}
	

	@SuppressWarnings("rawtypes")
	public void createPin1(int pin,HashSet Store) {
		if (!store.contains(pin)) {
			if (10000 > pin) {
				pin++;

				pinn.setText("" +String.valueOf(pin) );
			}
			store.add(pin);

		}
	else 

createPin1(pin++, store);}
	
	
}
