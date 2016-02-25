package br.com.mouseController;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
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
	//getPos()
	public static int[] getPos() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int[] pos = {(int)b.getX(), (int)b.getY()};
		System.out.println("mouse pos: [" + pos[0] + ", " + pos[1] +"]");
		return pos;
	}
	//move(int x, int y)
	public static void move(int x, int y) throws AWTException {
		Robot bot = new Robot();
		bot.mouseMove(x, y);
	}
	//move(int x, int y, int t)
	public static void move(int x, int y, int t) throws AWTException {
		//Mouse data
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		//Vm
		float vx = (int) (x - b.getX())/ t;
		float vy = (int) (y - b.getY())/ t;
		long posX = (int) b.getX();
		long posY = (int) b.getY();
		//x = x0+ vx * Time.deltaTime;
		//y = y0+ vy * Time.deltaTime;
		long start = System.currentTimeMillis();
		long last = System.nanoTime();
		long current = start;
		float seconds = 0;
		while(seconds < t) {
			current = System.nanoTime();
			long deltaTime = current - last;
			//Move
			posX = (long) (posX + vx * deltaTime);
			System.out.println(deltaTime);
			//posY = (int) (posY + vy * deltaTime);
			//MouseController.move(posX, posY);
			seconds = (float) ((System.currentTimeMillis()-start)/1000);
			//System.out.println(seconds);
			last = current;
		}
	}
}
