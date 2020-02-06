package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database 
{
	public static void openDB() throws ClassNotFoundException, SQLException
	{	
		String connectionURL = "jdbc:sqlserver://csc331.cqlujc9w3xkj.us-east-2.rds.amazonaws.com:1433;databaseName=TADB;user=admin;password=csc331ta";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		Connection conn = DriverManager.getConnection(connectionURL);
		
	}
}
