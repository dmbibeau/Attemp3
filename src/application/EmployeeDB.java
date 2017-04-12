package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class EmployeeDB {
	
	public EmployeeDB(){
		
	}
	
	Employee a = new Employee();

	
	Database db = new Database();	
//	Connection con = db.MySqlConnection();
	EmployeeDB(Employee a){
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
	
	public static void createEmpTable() throws Exception{
		try{
			Connection con = Database.getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS employee("
				+ "empid int NOT NULL AUTO_INCREMENT, "
				+ "name varchar(10), "
				+ "surname varchar(20), "
				+ "phone bigint(20), "
				+ "address varchar(40), "
				+ "pay decimal(10.2), "
				+ "position varchar(30), "
				+ "dob date, "
				+ "username varchar(20), "
				+ "password varchar(20), "
				+ "PRIMARY KEY(empid))");
			create.executeUpdate();
		} catch (Exception e){System.out.println(e);}
		finally{System.out.println("Function complete.");}		
	}
	
	public static void postEmp() throws Exception{
		try{
				Connection con = Database.getConnection();
				PreparedStatement posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob, username, password) VALUES "
						+ "('Benjamin', 'Pierce', 1234561525, '123 Main Street', '10.50', 'Employee', '1956-11-23', 'bpierce', 'password')");
				posted.executeUpdate();
				posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob, username, password) VALUES "
						+ "('Margaret', 'Houlihan', 9991231212, '1414 McQueens St', '14.50', 'Employee', '1987-04-19', 'mhoulihan', 'password')");
				posted.executeUpdate();
				posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob, username, password) VALUES "
						+ "('Maxwell', 'Klinger', 1542547811, '427 Church St.', '7.50', 'Employee', '1996-03-14', 'mklinger', 'password')");
				posted.executeUpdate();
				posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob, username, password) VALUES "
						+ "('Dianna', 'Bibeau', 1542547811, '427 Church St.', '7.50', 'Manager', '1974-03-10', 'dbibeau', 'password')");
				posted.executeUpdate();
				posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob, username, password) VALUES "
						+ "('Thomas', 'Bellon', 1542547811, '427 Church St.', '7.50', 'Manager', '1996-03-14', 'tbellon', 'password')");
				posted.executeUpdate();
				posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob, username, password) VALUES "
						+ "('David', 'Romanski', 1542547811, '427 Church St.', '7.50', 'Employee', '1996-12-14', 'dromanski', 'password')");
				posted.executeUpdate();

		} catch(Exception e){System.out.println(e);}
		finally {
			System.out.println("Insert Completed");
		}
	}
	
	public ObservableList<Employee> findInfoInt(int ID){
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
	
	public static String getPassword(TextField username) throws SQLException {
		Connection con = Database.getConnection();
		java.sql.Statement stmt = con.createStatement();
		System.out.println("Username: " + username.getText());
		ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE username = '" + username.getText() + "'");
		while (rs.next()) {
		System.out.println(rs.getString("password"));
		return rs.getString("password");
		}
//		PreparedStatement pst = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE USERNAME = " + username + "");
//		ResultSet passrs = pst.executeQuery();
//		String password = passrs.toString();
//		System.out.println("before return: " + passrs.getString(password).toString());
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
