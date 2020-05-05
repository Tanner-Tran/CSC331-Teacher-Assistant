package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Date;

import org.junit.jupiter.api.Test;

import Model.Database;
import View.Attendance.TakeAttendance;
import View.Attendance.ViewAttendance;

class TestDB {
	@SuppressWarnings("static-access")
	@Test
	public void test() throws Exception {
		Database dummy = new Database();
		
		try
		{
			dummy.openDB();
			System.out.println("Connection found.");
		}
		catch (Exception test)
		{
			System.out.println("Connection error.");
			System.exit(0);
		}
		dummy.removeTeacherUser("H Whit");
		DatabaseModifyTest(dummy);
		DatabaseLogin(dummy);
	}
	
	@SuppressWarnings("static-access")
	public void DatabaseModifyTest(Database demo) throws SQLException
	{
		demo.addTeacherUser("Whitston", "Howard", "H Whit", "password");
		
		if (!demo.checkIfUsernameAvailable("H Whit"))
		{
			System.out.println("Username exists.");
		}
		
		demo.removeTeacherUser("H Whit");
	}
	
	@SuppressWarnings("static-access")
	public void DatabaseLogin(Database test) throws SQLException
	{
		if (test.validateLogin("L. Larry", "dataStructure"))
		{
			System.out.println("Correct password login was successful.");
		}
		
		if (!test.validateLogin("L. Larry", "data"))
		{
			System.out.println("Correct password login failed.");
		}
	}
	
	public void AttendanceTest() throws Exception
	{
		java.sql.Date test = new java.sql.Date(System.currentTimeMillis());
		TakeAttendance dummy = new TakeAttendance("Gym", test);
		
		ViewAttendance dummy2 = new ViewAttendance("Gym", test);
		
		
	}

}