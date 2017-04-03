package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeDB {
	
	EmployeeDB(){
		
	}
	
	Employee a = new Employee();

	
	Database db = new Database();	
//	Connection con = db.MySqlConnection();
	EmployeeDB(Employee a){
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
	ObservableList<Employee> findInfoInt(int ID){
	try{
		Connection con = Database.getConnection();
		java.sql.Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE empid = " + ID);
		Employee employee = new Employee();
		ArrayList<Employee> employees = new ArrayList<>();
		while (rs.next()){
			String fName = rs.getString("name");
			employee.setFName(fName);
			String lName = rs.getNString("surname");
			employee.setLName(lName);
			String address = rs.getString("address");
			employee.setAddress(address);
			String phone = rs.getString("phone");
			employee.setPhone(phone);
			int pin = rs.getInt("empid");
			employee.setPin(pin);
			String position = rs.getString("position");
			employee.setPin(pin);
			double pay = rs.getDouble("pay");
			employee.setPin(pin);
			employees.add(employee);
		}
		
		ObservableList<Employee> oListPerson = FXCollections.observableArrayList(employees);
		return oListPerson;
		//phone.setCellValueFactory(value);
		//System.out.println(ID.getText());
		
		//find.executeUpdate();
	}catch (Exception ex) {System.out.println(ex);}
	return null;
	}
	
	public ObservableList<Employee> findInfoString(String id) {
		try{
			Connection con = Database.getConnection();
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE surname = '" + id+"'");
			Employee employee = new Employee();
			ArrayList<Employee> employees = new ArrayList<>();
			while (rs.next()){
				String fName = rs.getString("name");
				employee.setFName(fName);
				String lName = rs.getNString("surname");
				employee.setLName(lName);
				String address = rs.getString("address");
				employee.setAddress(address);
				String phone = rs.getString("phone");
				employee.setPhone(phone);
				int pin = rs.getInt("empid");
				employee.setPin(pin);
				String position = rs.getString("position");
				employee.setPosition(position);
				double pay = rs.getDouble("pay");
				employee.setPay(pay);
				employees.add(employee);
			}
			
			ObservableList<Employee> oListPerson = FXCollections.observableArrayList(employees);
			return oListPerson;
			//phone.setCellValueFactory(value);
			//System.out.println(ID.getText());
			
			//find.executeUpdate();
		}catch (Exception ex) {System.out.println(ex);}
		return null;
	}

}
