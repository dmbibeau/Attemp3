
package application; 
 
 
 import java.sql.DriverManager; 
 import java.sql.PreparedStatement; 
 import java.sql.ResultSet; 
 import java.sql.SQLException; 
 
 
 import javafx.collections.FXCollections;  import javafx.collections.ObservableList; 
 import javafx.scene.control.TableView; 
 import javafx.scene.control.TextField; 
 
 
 //import Controllers.User; 
 
 
 //import java.beans.Statement; 
 import java.sql.Connection; 
 
 
 public class Database { 
 
 
 	private static String MYSQL_DRIVER= "com.mysql.jdbc.Driver"; 
 	private static String MYSQL_URL="jdbc:mysql://localhost:3306/ddt_movies?autoReconnect=true&useSSL=false"; 
 	//private String user ="root"; 
 	//private String password="God0fmadnes$"; 
 	private static String user ="root"; 
 	//private static String password="Pass!@#$"; 
 	private static String password="Marie@21"; 
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
 
 
 
 
 		 
 	public static void createCustTable() throws Exception { 
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
 				posted = con.prepareStatement("INSERT INTO customer(name, surname, phone, email, address, credit_card, exp_date, dob) VALUES " 
 						+ "('Angus', 'MacGyver', 1231231547, 'angus@email.com', '4545 Celebration Blvd', '4564789712314564', '2022-09-00', '1980-10-02')"); 
 				posted.executeUpdate(); 
 				posted = con.prepareStatement("INSERT INTO customer(name, surname, phone, email, address, credit_card, exp_date, dob) VALUES " 
 						+ "('Thelma', 'Harper', 8439959912, 'thelma@email.com', '456 Second Loop', '9696545812541234', '2019-04-00', '1940-05-20')"); 
 				posted.executeUpdate(); 
 				posted = con.prepareStatement("INSERT INTO customer(name, surname, phone, email, address, credit_card, exp_date, dob) VALUES " 
 						+ "('Bubba', 'Higgins', 5184561234, 'bubba@email.com', '654 Palmetto Rd', '1475123569851458', '2021-11-00', '1994-10-05')"); 
 				posted.executeUpdate(); 
 				posted = con.prepareStatement("INSERT INTO customer(name, surname, phone, email, address, credit_card, exp_date, dob) VALUES " 
 						+ "('Iola', 'Boylen', 2124561234, 'iola@email.com', '567 Cashua Rd', '2215358945618845', '2018-10-00', '1976-05-30')"); 
 				posted.executeUpdate(); 
 				posted = con.prepareStatement("INSERT INTO customer(name, surname, phone, email, address, credit_card, exp_date, dob) VALUES " 
 						+ "('Fran', 'Crowley', 8592531254, 'fran@email.com', '1313 Alligator Ave', '5548669522141574', '2022-08-00', '1982-12-02')"); 
 				posted.executeUpdate(); 
 
 
 		} catch(Exception e){System.out.println(e);} 
 		finally { 
 			System.out.println("Insert Completed"); 
 		} 
	}	 
 	 
 /*	public static void createEmpTable() throws Exception{ 
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
 	}*/ 
 	 
 /*	public static void postEmp() throws Exception{ 
 		try{ 
 				Connection con = getConnection(); 
 				PreparedStatement posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob) VALUES " 
 						+ "('Benjamin', 'Pierce', 1234561525, '123 Main Street', '10.50', 'Employee', '1956-11-23')"); 
 				posted.executeUpdate(); 
 				posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob) VALUES " 
 						+ "('Margaret', 'Houlihan', 9991231212, '1414 McQueens St', '14.50', 'Employee', '1987-04-19')"); 
				posted.executeUpdate(); 
 				posted = con.prepareStatement("INSERT INTO employee(name, surname, phone, address, pay, position, dob) VALUES " 
 						+ "('Maxwell', 'Klinger', 1542547811, '427 Church St.', '7.50', 'Manager', '1996-03-14')"); 
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
 				+ "price double(10,2), " 
 				+ "quantity varchar(1), " 
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
 	  
 	//fillEmpTable is not working 
 	public static void fillEmpTable() throws SQLException { 
 		ObservableList<Employee> data = FXCollections.observableArrayList(); 
 		//TableView tableview = new TableView<Employee>(); 
 		data = FXCollections.observableArrayList(); 
 		 
 		String query = "select * from employee"; 
 		PreparedStatement pst = con.prepareStatement(query); 
 		ResultSet rs = pst.executeQuery(); 
 		TableView<Employee> table = new TableView<Employee>(); 
 		 
 		while(rs.next()) { 
 			data.add(new Employee( 
 					rs.getString("empid"), 
 					rs.getString("name"), 
 					rs.getString("surname"), 
 					rs.getString("phone"), 
 					rs.getString("address"), 
 					rs.getString("pay"), 
 					rs.getString("position"), 
 					rs.getString("dob") 
 			)); 
 			for (int i = 0; i < data.size(); i++) 
 				System.out.print(data.get(i).getFName()); 
 			System.out.println(); 
 			table.setItems(data); 
 		} 
 	} 
 	 
 	public static void removeCust(int pin) throws SQLException { 
 		PreparedStatement pst = con.prepareStatement("delete from customer where pin = " + pin +""); 
 		pst.executeUpdate(); 
 	} 
 	public static void removeEmp(int pin) throws SQLException { 
 		PreparedStatement pst = con.prepareStatement("delete from employee where empid = " + pin +""); 
 		pst.executeUpdate(); 
 	} 
 } 
 






