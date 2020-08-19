package view;

import view.account.Login;

public class GUI 
{
	private static String userCookie;
	
	public GUI()
	{
		Login window = new Login();
		window.open();
	}
	
	public static void setCookie(String username)
	{
		userCookie = username;
	}
	
	public static String getCookie()
	{
		return userCookie;
	}
}
