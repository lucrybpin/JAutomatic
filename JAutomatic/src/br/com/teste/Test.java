package br.com.teste;

import java.awt.AWTException;
import java.io.IOException;

import br.com.osController.OsController;

public class Test {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		/*Runtime rt = Runtime.getRuntime();
		rt.exec("notepad");*/
		
		
		/*MouseController.getInstance().getPos();
		MouseController.getInstance().click(1191,11);*/
		
		try
        {            
			//System.out.println(OsController.getInstance().execute("gedit"));
			Process proc = OsController.getInstance().execute("gedit");
            //KeyboardController.getInstance().typeSmooth("Digitando smoothly uma grande frase teste teste teste lorem impsum");
            int exitVal = proc.waitFor();
            System.out.println("notepad exit value: " + exitVal);
        } catch (Throwable t)
          {
            t.printStackTrace();
          }
	
	}
}
