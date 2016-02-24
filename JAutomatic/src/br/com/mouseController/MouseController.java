package br.com.mouseController;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseController {
	
	public MouseController() {
	}
	
	//click(button, x, y)
	public static void click(String button, int x, int y) throws AWTException {
		Robot bot = new Robot();
		if(button.equals("left")) {
			bot.mouseMove(x, y);
			bot.mousePress(InputEvent.BUTTON1_MASK);
			bot.mouseRelease(InputEvent.BUTTON1_MASK);
		}else if(button.equals("right")) {
			bot.mouseMove(x, y);
			bot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
			bot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
			System.out.println("right click");
		}else {
			return;
		}
	}
	//click(x,y)
	public static void click(int x, int y) throws AWTException {
		Robot bot = new Robot();
		bot.mouseMove(x, y);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		System.out.println("click [" +x+","+y+"]");
	}
	//click()
	public static void click() throws AWTException {
		Robot bot = new Robot();
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		System.out.println("click");
	}
	//clickRight()
	public static void clickRight() throws AWTException {
		Robot bot = new Robot();
		bot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		bot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		System.out.println("right click");
	}
}
