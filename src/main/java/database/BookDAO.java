package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Book;




public class BookDAO {
	
	Book oneBook = null;
	Connection conn = null;
    Statement stmt = null;
//	String user = "sharmaak";
//    String password = "Yinkstre5";
    // Note none default port used, 6306 not 3306
//    String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/" + user;
    String user = "rootAdmin";
    String password ="Aksharadmin12";
    String url = "jdbc:mysql://book-web-app-database.ckparayv7txz.eu-west-2.rds.amazonaws.com:3306/bookWeb";
	public BookDAO() {}

	
	private Statement openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			conn = DriverManager.getConnection(url, user, password);
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }
		return stmt;
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Book getNextBook(ResultSet rs){
    	Book thisBook=null;
		try {
			
			thisBook = new Book(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("author"),
					rs.getString("date"),
					rs.getString("genres"),
					rs.getString("characters"),
					rs.getString("synopsis"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return thisBook;		
	}
	
	
	
   public ArrayList<Book> getAllBooks(){
	   
		ArrayList<Book> allBooks = new ArrayList<Book>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from books";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneBook = getNextBook(rs1);
		    	allBooks.add(oneBook);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allBooks;
   }

   public Book getBookByID(int id){
	   
		openConnection();
		oneBook=null;
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from books where id="+id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneBook = getNextBook(rs1);
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return oneBook;
   }
   
   public boolean insertBook(Book book) throws SQLException {

	   boolean b = false;
		try {
			String sql = "insert into books (Title, Author, Date, Genres, Characters, Synopsis) values ('" + book.getTitle() + "','" + book.getAuthor() + "','" + book.getDate() + "','" + book.getGenres() + "','" + book.getCharacters()+ "','" + book.getSynopsis() +  "');";
			System.out.println(sql);
			b = openConnection().execute(sql);
			closeConnection();
			b=true;
		} catch (SQLException s) {
			throw new SQLException("Book Not Added");
		}
		return b;
		
	}
   
   public boolean updateBook(Book book) throws SQLException {
		boolean b = false;
//		// YOUR CODE HERE
	try {
		//String sql = "update contacts set name = c.getName(),email = c.getEmail() where name = c.getName();";
		System.out.println("id" + book.getId());
		String sql = "update books set title = '" +  book.getTitle() + "', author = '" +  book.getAuthor()+ "', date = '" +  book.getDate()+ "', characters = '" +  book.getCharacters()+ "', synopsis = '" +  book.getSynopsis() + "' where id = " +  book.getId() + ";";
		System.out.println(sql);
		b = openConnection().execute(sql);
		closeConnection();
		b = true;
	} catch (SQLException s) {
		throw new SQLException("Books Not Updated");
	}
		return b;
	}
   
   public boolean deleteBook(Book book) throws SQLException {
		boolean b = false;
		
//		// YOUR CODE HERE
	try {
		String sql = "delete from books where id =" + book.getId() + ";";
		System.out.println(sql);
		
		b = openConnection().execute(sql);
		closeConnection();
		b = true;
	} catch (SQLException s) {
		throw new SQLException("Books Not Deleted");
	}
		return b;
	}
   
}
