package br.com.osController;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

public class OsController {
	
	//Singleton
	public static OsController osController = new OsController();
	public static Robot robot;
	
	//Constructor
	private OsController() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			System.out.println("Problem instantiating robot from MouseController");
			e.printStackTrace();
		}
	}
	//getInstance
	public static OsController getInstance() {
		return osController;
	}
	//getOs
	public String getOs() {
		return System.getProperty("os.name");
	}
	//execute
	public Process execute(String command) {
		try {
			Process process =Runtime.getRuntime().exec(command);
			return process;
		} catch (IOException e) {
			return null;
		}
	}
}
