
package application;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.beans.Statement;
import java.sql.Connection;

public class Database {
	
/*private static String MYSQL_DRIVER= "com.mysql.jdbc.Driver";
private static String MYSQL_URL="jdbc:mysql://172.19.5.9:3306/ddt_movies?useSSl=false";
private static String user ="David";
private static String password="mond1234";
private static java.sql.Connection con;
=======
private String MYSQL_DRIVER= "com.mysql.jdbc.Driver";
private String MYSQL_URL="jdbc:mysql://localhost:3306/DDT_Movies?useSSl=true";
private String user ="root";
private String password="God0fmadnes$";
private java.sql.Connection con;
>>>>>>> branch 'master' of https://github.com/dmbibeau/Attemp3

<<<<<<< HEAD
public static void post() throws Exception{
	final String var1 = "John";
	final String var2 = "Miller";
	try{
			Connection con = MySqlConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO customer (name, surname) VALES ('"+var1+"'," +var2+"')");
			posted.executeUpdate();
	} catch(Exception e){System.out.println(e);}
	finally {
		System.out.println("Insert Completed");
	}
}
	
public static Connection MySqlConnection(){
=======
public Connection MySqlConnection(){
	Statement stm;
	//stm.
>>>>>>> branch 'master' of https://github.com/dmbibeau/Attemp3
	
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
}
