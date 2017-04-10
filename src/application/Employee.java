package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;



public class Employee {
	public String getFName() {
		return fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getLName() {
		return lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getBDay() {
		return BDay;
	}

	public void setBDay(Date bDay) {
		BDay = bDay;
	}




	String fName;

	String lName;

	int pin;

	String phone;

	String address;

	double pay;

	String position;

	Date BDay;
	
	Employee(){
	}
	
	public Employee(String string, String string2, String string3, String string4, String string5, String string6,
			String string7, String string8) {
		// TODO Auto-generated constructor stub
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
