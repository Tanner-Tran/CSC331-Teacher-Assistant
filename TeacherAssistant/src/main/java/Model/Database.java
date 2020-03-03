package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public static boolean checkIfCourseCodeAvailable(String code, String teacher) throws SQLException
	{
		String query = "select* from COURSE where code = ? and teacher = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, code);
		statement.setString(2, teacher);
		
		ResultSet results = statement.executeQuery();
		
		return !results.next();
	}
	
	public static boolean checkIfStudentAlreadyAdded(String code, String studentID, String teacher) throws SQLException
	{
		String query = "select* from STUDENT where classCode = ? and teacher = ? and studentID = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, code);
		statement.setString(2, teacher);
		statement.setString(3, studentID);
		
		ResultSet results = statement.executeQuery();
		
		return results.next();
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
	
	public static void addCourse(String title, String code, String teacher) throws SQLException
	{
		String query = "insert into COURSE values (?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, title);
		statement.setString(2, code);
		statement.setString(3, teacher);
		
		statement.execute();
	}
	
	public static void removeCourse(String code, String teacher) throws SQLException
	{
		String query = "delete from COURSE where code = ? and teacher = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, code);
		statement.setString(2, teacher);
		
		statement.execute();
	}
	
	public static String[] getCourses(String teacher) throws SQLException
	{
		ArrayList<String> list = new ArrayList<>();
		
		String query = "SELECT code from COURSE where teacher = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, teacher);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next())
		{
			list.add(rs.getString("code"));
		}
		
		String[] array = list.toArray(new String[list.size()]);
		
		return array;
	}
	
	public static void addStudent(String lastName, String firstName, String studentID, String classCode, String teacher) throws SQLException
	{
		String query = "insert into STUDENT values (?, ?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, lastName);
		statement.setString(2, firstName);
		statement.setString(3, studentID);
		statement.setString(4, classCode);
		statement.setString(5, teacher);
		
		statement.execute();
	}
	
	public static void removeStudent(String studentID, String classCode, String teacher) throws SQLException
	{
		String query = "delete from STUDENT where studentID = ? and classCode = ? and teacher = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, studentID);
		statement.setString(2, classCode);
		statement.setString(3, teacher);
		
		statement.execute();
	}
	
	public static String[] getStudents(String classCode, String teacher) throws SQLException
	{
		ArrayList<String> list = new ArrayList<>();
		
		String query = "SELECT lastName, FirstName, StudentID from STUDENT where teacher = ? and classCode = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, teacher);
		statement.setString(2, classCode);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next())
		{
			String result = "";
			result += rs.getString("firstName");
			result += " ";
			result += rs.getString("lastName");
			result += " (";
			result += rs.getString("studentID");
			result += ")";
			
			list.add(result);
		}
		
		String[] array = list.toArray(new String[list.size()]);
		
		return array;
	}
	
	
}
