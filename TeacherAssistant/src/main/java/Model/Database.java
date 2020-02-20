package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database 
{
	private static Connection conn;
	
	// Helper functions start here
	
	public static void openDB() throws ClassNotFoundException, SQLException // Connect to DB
	{	
		String connectionURL = "jdbc:sqlserver://csc331.cqlujc9w3xkj.us-east-2.rds.amazonaws.com:1433;databaseName=TADB;user=admin;password=csc331ta";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		conn = DriverManager.getConnection(connectionURL);
	}
	
	public static boolean checkIfUsernameAvailable(String username) throws SQLException
	{
		String query = "select* from TEACHER where username = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, username);
		
		ResultSet results = statement.executeQuery();
		
		return !results.next();
	}
	
	public static boolean validateLogin(String username, String password) throws SQLException
	{
		String query = "select* from TEACHER where username = ? and userPass = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, username);
		statement.setString(2, password);
		
		ResultSet results = statement.executeQuery();
		
		return results.next();
	}
	
	// Helper functions end here
		
	public static void addTeacherUser(String lastName, String firstName, String username, String password) throws SQLException
	{	
		String query = "insert into TEACHER values (?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, lastName);
		statement.setString(2, firstName);
		statement.setString(3, username);
		statement.setString(4, password);
		
		statement.execute();
	}
	
	public static void removeTeacherUser(String username) throws SQLException
	{
		String query = "delete from TEACHER where username = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, username);
		
		statement.execute();
	}
}
