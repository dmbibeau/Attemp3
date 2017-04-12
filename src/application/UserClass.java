package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserClass {
	
	public boolean manager; 

	public UserClass(){}
	
	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public UserClass(boolean manager) {
		this.manager = manager;
	}
	
	public static void dropCurrTable() throws SQLException{
		Connection con = Database.getConnection();		
		java.sql.PreparedStatement pst = con.prepareStatement("DROP TABLE IF EXISTS curruser");
		pst.executeUpdate();
	}
	public static ResultSet getPosition(){
		try{
			Connection con = Database.getConnection();		
			String query = "SELECT position FROM curruser";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			return rs;
		} catch (Exception e){System.out.println(e);}
		return null;
	}
}
