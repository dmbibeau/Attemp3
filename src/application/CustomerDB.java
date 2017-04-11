package application;

//import java.beans.Statement;
import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
//import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerDB {
	Person a = new Person();
	
	
	Database db = new Database();	
//	Connection con = db.MySqlConnection();
	CustomerDB(Person a){
		this.a = a;
	}
	public void addInfo() throws Exception{
		
//		String Querry= " Insert into Customer(pin, Last_Name, first_Name,credit_card,phone_num,b_day, address)"
//				+ "values(?,?,?,?,?,?,?);";
		
/*		PreparedStatement statement = con.prepareStatement(Querry);
		
		statement.setInt(1, a.getPin());
		statement.setString(2, a.getLastName());
		statement.setString(3, a.getFirstName());	
		statement.setString(4, a.getCreditCard());	
		statement.setString(5, a.getPhoneNum());
		statement.setDate(6, new java.sql.Date(a.getbDay().getTime()));
		statement.setString(7, a.getAddress());
		statement.execute();*/
	}
	public CustomerDB(){
		
	}
	
	public ObservableList<Person> findInfo(int ID){
	try{
		Connection con = Database.getConnection();
		java.sql.Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE pin = " + ID);
		Person person = new Person();
		ArrayList<Person> people = new ArrayList<>();
		while (rs.next()){
			String fName = rs.getString("name");
			person.setFirstName(fName);
			String lName = rs.getNString("surname");
			person.setLastName(lName);
			String address = rs.getString("address");
			person.setAddress(address);
			String phone = rs.getString("phone");
			person.setPhoneNum(phone);
			int pin = rs.getInt("pin");
			person.setPin(pin);
			people.add(person);
		}
		
		ObservableList<Person> oListPerson = FXCollections.observableArrayList(people);
		return oListPerson;
		//phone.setCellValueFactory(value);
		//System.out.println(ID.getText());
		
		//find.executeUpdate();
	}catch (Exception ex) {System.out.println(ex);}
	return null;
	}
}
