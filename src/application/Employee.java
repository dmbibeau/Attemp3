package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.control.TextField;

public class Employee {
	Employee(){
	}
	
	public static void addEmp(TextField firstName, TextField lastName, TextField phone, 
			TextField address, TextField payRate, TextField position, TextField dob){
		try {
			Connection con = Database.getConnection();		
			PreparedStatement posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob) VALUES "
					+ "('" + firstName.getText()
					+"', '"+ lastName.getText()      
					+"', '"+ phone.getText()         
					+"', '"+ address.getText()
					+"', '"+ payRate.getText()
					+"', '"+ position.getText()
					+"', '"+ dob.getText()
					+"')");
			posted.executeUpdate();
		}catch (Exception ex) {System.out.println(ex);}
	}
	
	public static ResultSet getLastEmpID(){
		try{
			Connection con = Database.getConnection();		
			String query = "SELECT max(empid) as empid FROM employee";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			return rs;
		} catch (Exception e){System.out.println(e);}
		return null;
	}
}
