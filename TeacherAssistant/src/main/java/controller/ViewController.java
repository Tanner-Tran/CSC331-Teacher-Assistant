package controller;

import view.GUI;

public class ViewController 
{
	public static void startApplication()
	{
		DBController.openDB();
		GUI UI = new GUI();
	}
}
