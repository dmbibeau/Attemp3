package application;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class Database {
private String MYSQL_DRIVER= " come.mysql.jdb.Driver";
private String MYSQL_URL="jdbc:mysql://localhost:3306/DDT Movie DB?useSSl=false";
private String user ="root";
private String password="Marie@21";
private java.sql.Connection con;

public Connection MySqlConnection(){
	
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
}
}