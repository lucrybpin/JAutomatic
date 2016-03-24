package br.com.teste;

import java.awt.AWTException;

import br.com.KeyboardController.KeyboardController;
import br.com.mouseController.MouseController;

public class Test {

	public static void main(String[] args) throws AWTException {
		KeyboardController.getInstance().type("teste");
		MouseController.getInstance().getPos();
		MouseController.getInstance().click(1191,11);
	}
}
