
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

public static void post() throws Exception{
	final String var1 = "John";
	final String var2 = "Miller";
	try{
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO customer (name, surname) VALES ('"+var1+"'," +var2+"')");
			posted.executeUpdate();
	} catch(Exception e){System.out.println(e);}
	finally {
		System.out.println("Insert Completed");
	}
}
	
//public static Connection MySqlConnection(){
/*public Connection MySqlConnection(){
	//con.Statement stm;
	//stm.
	
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
	return con;
}*/

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
}
