package application;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.beans.Statement;
import java.sql.Connection;

public class Database {

	private static String MYSQL_DRIVER= "com.mysql.jdbc.Driver";
	private static String MYSQL_URL="jdbc:mysql://localhost:3306/ddt_movies?autoReconnect=true&useSSL=false";
	//private String user ="root";
	//private String password="God0fmadnes$";
	private static String user ="root";
	private static String password="Mond1234";
	private static java.sql.Connection con;

	public static Connection getConnection(){
		try{
			Class.forName(MYSQL_DRIVER);
			con =  DriverManager.getConnection(MYSQL_URL,user,password);
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

	public static void createCustTable() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS customer("
				+ "pin int NOT NULL AUTO_INCREMENT, "
				+ "name varchar(10), "
				+ "surname varchar(20), "
				+ "phone bigint(20), "
				+ "email varchar(40), "
				+ "address varchar(40), "
				+ "credit_card varchar(16), "
				+ "exp_date date, "
				+ "dob date, "
				+ "PRIMARY KEY(pin))");
			create.executeUpdate();
		} catch (Exception e){System.out.println(e);}
		finally{System.out.println("Function complete.");}		
	}
	
	public static void postCust() throws Exception{
		try{
				Connection con = getConnection();
				PreparedStatement posted = con.prepareStatement("INSERT INTO customer(name, surname, phone, email, address, credit_card, exp_date, dob) VALUES "
																+ "('Dave', 'Romanski', 9991231212, 'dave@email.com', '123 Main Street', '1234432112344321', '2020-02-00', '1956-11-23')");
				posted.executeUpdate();
		} catch(Exception e){System.out.println(e);}
		finally {
			System.out.println("Insert Completed");
		}
	}	
	
	public static void createEmpTable() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS employee("
				+ "empid int NOT NULL AUTO_INCREMENT, "
				+ "name varchar(10), "
				+ "surname varchar(20), "
				+ "phone bigint(20), "
				+ "address varchar(40), "
				+ "pay decimal(10.2), "
				+ "position varchar(30), "
				+ "dob date, "
				+ "PRIMARY KEY(empid))");
			create.executeUpdate();
		} catch (Exception e){System.out.println(e);}
		finally{System.out.println("Function complete.");}		
	}
	
	public static void postEmp() throws Exception{
		try{
				Connection con = getConnection();
				PreparedStatement posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob) VALUES "
																+ "('Dave', 'Romanski', 9991231212, '123 Main Street', '10.50', 'Employee', '1956-11-23')");
				posted.executeUpdate();
		} catch(Exception e){System.out.println(e);}
		finally {
			System.out.println("Insert Completed");
		}
	}	
}
