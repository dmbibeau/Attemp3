package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.util.Date;

import javafx.scene.control.TextField;

public class Movie {
	
	Movie(){}
	private int barcode;
	
	private String title;
	
	private String director;
	
	private int year;
	
	private String genre;
	
	private String actors;
	
	public Integer getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	private String format;
	
	private String language;

	public static void addMovie(TextField barcode2, TextField title2, TextField director2, TextField genre2,
			TextField actors2, TextField year2, TextField format2, TextField language2) {
		try {
			Connection con = Database.getConnection();		
			PreparedStatement posted = con.prepareStatement("INSERT INTO movie(barcode, title, director, genre, actors, year, format, language) VALUES "
					+ "('" + barcode2.getText()
					+"', '"+ title2.getText()      
					+"', '"+ director2.getText()
					+"', '"+ genre2.getText()
					+"', '"+ actors2.getText()
					+"', '"+ year2.getText()
					+"', '"+ format2.getText()
					+"', '"+ language2.getText()
					+"')");
			posted.executeUpdate();
		}catch (Exception ex) {System.out.println(ex);}
		
	}

}
