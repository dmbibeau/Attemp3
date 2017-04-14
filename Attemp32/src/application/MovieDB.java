package application; 

import java.sql.Connection; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList; 
 
public class MovieDB { 
	public MovieDB(){ 
} 

	Movie a = new Movie(); 
 	Database db = new Database();	 
//	Connection con = db.MySqlConnection(); 
	MovieDB(Movie a){ 
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
	public ObservableList<Movie> findInfoInt(int ID){ 
	try{ 
		Connection con = Database.getConnection(); 
		java.sql.Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery("SELECT * FROM movie WHERE barcode = " + ID); 
		Movie movie = new Movie(); 
		ArrayList<Movie> movies = new ArrayList<>(); 
		while (rs.next()){ 
			String title = rs.getString("title"); 
			movie.setTitle(title); 
			String director = rs.getString("director"); 
			movie.setDirector(director); 
			String genre = rs.getString("genre"); 
			movie.setGenre(genre); 
			String actor = rs.getString("actors"); 
			movie.setActors(actor); 
			int barcode = rs.getInt("barcode"); 
			movie.setBarcode(barcode); 
			String language = rs.getString("language"); 
			movie.setLanguage(language); 
			int year = rs.getInt("year"); 
			movie.setYear(year); 
			movies.add(movie); 
		} 
		 
		ObservableList<Movie> oListPerson = FXCollections.observableArrayList(movies); 
		return oListPerson; 
		//phone.setCellValueFactory(value); 
		//System.out.println(ID.getText()); 
		 
		//find.executeUpdate(); 
	}catch (Exception ex) {System.out.println(ex);} 
	return null; 
	} 

public ObservableList<Movie> findInfoString(String id) { 
		try{ 
			Connection con = Database.getConnection(); 
			java.sql.Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT * FROM movie WHERE title = " + id); 
			Movie movie = new Movie(); 
			ArrayList<Movie> movies = new ArrayList<>(); 
			while (rs.next()){ 
				String title = rs.getString("title"); 
				movie.setTitle(title); 
				String director = rs.getString("director"); 
				movie.setDirector(director); 
				String genre = rs.getString("genre"); 
				movie.setGenre(genre); 
				String actor = rs.getString("actor"); 
				movie.setActors(actor); 
				int barcode = rs.getInt("barcode"); 
				movie.setBarcode(barcode); 
				String language = rs.getString("language"); 
				movie.setLanguage(language); 
				int year = rs.getInt("year"); 
				movie.setYear(year); 
				movies.add(movie); 
			} 
			ObservableList<Movie> oListMovie = FXCollections.observableArrayList(movies); 
			return oListMovie; 
			//phone.setCellValueFactory(value); 
			//System.out.println(ID.getText()); 
			 
			//find.executeUpdate(); 
 	}catch (Exception ex) {System.out.println(ex);} 
		return null; 
		} 
} 