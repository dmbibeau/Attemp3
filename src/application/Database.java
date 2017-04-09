package application;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.beans.Statement;
import java.sql.Connection;

public class Database {

	private static String MYSQL_DRIVER= "com.mysql.jdbc.Driver";
	private static String MYSQL_URL="jdbc:mysql://localhost:3306/ddt_movies?autoReconnect=true&useSSL=false";
	private static String user ="root";
	private static String password="god0fmadnes$";
	//private static String user ="root";
	//private static String password="Mond1234";
	//private static String password="Marie@21";
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
	
	/*public static void postCust() throws Exception{
		try{
				Connection con = getConnection();
				PreparedStatement posted = con.prepareStatement("INSERT INTO customer(name, surname, phone, email, address, credit_card, exp_date, dob) VALUES "
																+ "('Dave', 'Romanski', 9991231212, 'dave@email.com', '123 Main Street', '1234432112344321', '2020-02-00', '1956-11-23')");
				posted.executeUpdate();
		} catch(Exception e){System.out.println(e);}
		finally {
			System.out.println("Insert Completed");
		}
	}*/	
	
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
	
	/*public static void postEmp() throws Exception{
		try{
				Connection con = getConnection();
				PreparedStatement posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob) VALUES "
																+ "('Dave', 'Romanski', 9991231212, '123 Main Street', '10.50', 'Employee', '1956-11-23')");
				posted.executeUpdate();
		} catch(Exception e){System.out.println(e);}
		finally {
			System.out.println("Insert Completed");
		}
	}*/	
	public static void createMovieTable() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS movie("
				+ "year int (14), "
				+ "title varchar(255), "
				+ "director varchar(100), "
				+ "barcode bigint(12), "
				+ "actors varchar(255), "
				+ "language varchar(255), "
				+ "format varchar(50), "
				+ "genre varchar(50), "
				+ "rating varchar(1), "
				+ "price double(10), "
				+ "quantity varchar (1), "
				+ "PRIMARY KEY(barcode))");
			create.executeUpdate();
		} catch (Exception e){System.out.println(e);}
		finally{System.out.println("Function complete.");}		
	}
	public static void createTransactionTable() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS transaction("
				+ "code int (255) NOT NULL AUTO_INCREMENT, "
				+ "pin int(4), "
				+ "barcode int (12), "
				+ "rent_date date, "
				+ "return_date date, "
				+ "PRIMARY KEY(code))");
			create.executeUpdate();
		} catch (Exception e){System.out.println(e);}
		finally{System.out.println("Function complete.");}		
	}
	public static void createScheduleTable() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS schedule("
				+ "work_day date, "
				+ "empin int(4), "
				+ "start time, "
				+ "end time, "
				+ "holiday boolean, "
				+ "PRIMARY KEY(work_day))");
			create.executeUpdate();
		} catch (Exception e){System.out.println(e);}
		finally{System.out.println("Function complete.");}		
	}
}
