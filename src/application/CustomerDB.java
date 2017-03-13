package application;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDB {
	Person a = new Person();
	
	
	Database db = new Database();	
//	Connection con = db.MySqlConnection();
	CustomerDB(Person a){
		this.a = a;
	}
	public void addInfo() throws Exception{
		
		String Querry= " Insert into Customer(pin, Last_Name, first_Name,credit_card,phone_num,b_day, address)"
				+ "values(?,?,?,?,?,?,?);";
		
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
	
}
