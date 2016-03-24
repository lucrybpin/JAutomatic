package br.com.KeyboardController;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyboardController {
	
	//Singleton
	public static KeyboardController  keyboardController = new KeyboardController();
	static Robot robot;
	
	//Constructor
	private KeyboardController() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			System.out.println("Problem instantiating robot from KeyboardController");
			e.printStackTrace();
		}
	}
	//getInstance
	public static KeyboardController getInstance() {
		return keyboardController;
	}
	//Type a string
	public void type(String input) throws AWTException {
		int size = input.length();
		for(int i=0; i< size; i++) {
			int x = KeyEvent.getExtendedKeyCodeForChar(input.charAt(i));
			robot.keyPress(x);
			robot.keyRelease(x);
		}
	}
}
