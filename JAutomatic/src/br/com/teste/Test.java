package br.com.teste;

import java.awt.AWTException;
import java.io.IOException;

import br.com.keyboardController.KeyboardController;
import br.com.mouseController.MouseController;

public class Test {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		/*Runtime rt = Runtime.getRuntime();
		rt.exec("notepad");*/
		
		
		/*MouseController.getInstance().getPos();
		MouseController.getInstance().click(1191,11);*/
		
		try
        {            
			System.out.println("OS: " + System.getProperty("os.name") + "\n");
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("notepad");
            Thread.sleep(1000);
            KeyboardController.getInstance().typeSmooth("Digitando smoothly uma grande frase teste teste teste lorem impsum");
            Thread.sleep(1000);
            MouseController.getInstance().click(843,122);
            Thread.sleep(500);
            MouseController.getInstance().click(681,392);
            int exitVal = proc.waitFor();
            MouseController.getInstance().getPos();
            System.out.println("notepad exit value: " + exitVal);
        } catch (Throwable t)
          {
            t.printStackTrace();
          }
	
	}
}
