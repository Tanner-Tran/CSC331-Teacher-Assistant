package Main;

import java.sql.SQLException;

import Model.Database;

public class Driver 
{
	public static void main(String[] args) 
	{
		try 
		{
			Database.openDB();
			System.out.println(Database.validateLogin("ttran", "passwords"));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
