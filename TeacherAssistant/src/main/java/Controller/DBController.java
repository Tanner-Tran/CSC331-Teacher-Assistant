package Controller;

import java.sql.SQLException;

import Model.Database;

public class DBController // This class should contain all of the methods of the Database class.
{	
	// Helper functions start here
	
	public static void openDB()
	{
		try 
		{
			Database.openDB();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean checkIfUsernameAvailable(String username)
	{
		try 
		{
			return Database.checkIfUsernameAvailable(username);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Something went wrong.");
		return false;
	}
	
	public static boolean checkIfCourseCodeAvailable(String code, String teacher)
	{
		try 
		{
			return Database.checkIfCourseCodeAvailable(code, teacher);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Something went wrong.");
		return false;
	}
	
	public static boolean checkIfStudentAlreadyAdded(String code, String studentID, String teacher)
	{
		try 
		{
			return Database.checkIfStudentAlreadyAdded(code, studentID, teacher);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Something went wrong.");
		return false;
	}
	
	public static boolean checkIfCourseHasStudents(String code, String teacher)
	{
		try 
		{
			return Database.checkIfCourseHasStudents(code, teacher);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Something went wrong.");
		return false;
	}
	
	public static boolean validateLogin(String username, String password)
	{
		try 
		{
			return Database.validateLogin(username, password);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Something went wrong.");
		return false;
	}
	
	public static boolean checkIfAttendanceDateAlreadyAdded(String classCode, String teacher, java.sql.Date Date)
	{
		try 
		{
			return Database.checkIfAttendanceDateAlreadyAdded(classCode, teacher, Date);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Something went wrong.");
		return false;
	}
	
	public static boolean checkIfStudentWasAbsent(String classCode, String teacher, java.sql.Date attDate, String studentID)
	{
		try 
		{
			return Database.checkIfStudentWasAbsent(classCode, teacher, attDate, studentID);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Something went wrong.");
		return false;
	}
	
	// Helper functions end here
	
	public static void addTeacherUser(String lastName, String firstName, String username, String password)
	{
		try 
		{
			Database.addTeacherUser(lastName, firstName, username, password);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeTeacherUser(String username)
	{
		try 
		{
			Database.removeTeacherUser(username);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addCourse(String title, String code, String teacher)
	{
		try 
		{
			Database.addCourse(title, code, teacher);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeCourse(String code, String teacher)
	{
		try 
		{
			Database.removeCourse(code, teacher);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static String[] getCourses(String teacher)
	{
		try 
		{
			return Database.getCourses(teacher);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Something went wrong.");
		return null;
	}
	
	public static void addStudent(String lastName, String firstName, String studentID, String classCode, String teacher)
	{
		try 
		{
			Database.addStudent(lastName, firstName, studentID, classCode, teacher);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeStudent(String studentID, String classCode, String teacher)
	{
		try 
		{
			Database.removeStudent(studentID, classCode, teacher);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeAllStudentsFromACourse(String classCode, String teacher)
	{
		try 
		{
			Database.removeAllStudentsFromACourse(classCode, teacher);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String[] getStudents(String classCode, String teacher)
	{
		try 
		{
			return Database.getStudents(classCode, teacher);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Something went wrong.");
		return null;
	}
	
	public static void addAttendanceDate(String classCode, String teacher, java.sql.Date Date)
	{
		try 
		{
			Database.addAttendanceDate(classCode, teacher, Date);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeAttendanceDate(String classCode, String teacher, java.sql.Date Date)
	{
		try 
		{
			Database.removeAttendanceDate(classCode, teacher, Date);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addAbsent(String classCode, String teacher, java.sql.Date Date, String studentID)
	{
		try 
		{
			Database.addAbsent(classCode, teacher, Date, studentID);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeAbsent(String classCode, String teacher, java.sql.Date Date, String studentID)
	{
		try 
		{
			Database.removeAbsent(classCode, teacher, Date, studentID);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addGradeType(String classCode, String teacher, String typeName, double typeWeight)
	{
		try 
		{
			Database.addGradeType(classCode, teacher, typeName, typeWeight);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeGradeType(String classCode, String teacher, String typeName)
	{
		try 
		{
			Database.removeGradeType(classCode, teacher, typeName);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addAssignment(String classCode, String teacher, String assignName, String assignType)
	{
		try 
		{
			
			Database.addAssignment(classCode, teacher, assignName, assignType);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeAssignment(String classCode, String teacher, String assignName)
	{
		try 
		{
			Database.removeAssignment(classCode, teacher, assignName);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addGrade(String classCode, String teacher, String assignName, String studentID, int grade)
	{
		try 
		{
			Database.addGrade(classCode, teacher, assignName, studentID, grade);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeGrade(String classCode, String teacher, String assignName, String studentID)
	{
		try 
		{
			Database.removeGrade(classCode, teacher, assignName, studentID);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} // Class end
