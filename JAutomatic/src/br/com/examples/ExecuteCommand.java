package br.com.examples;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.osController.OsController;

public class ExecuteCommand extends JFrame {
	JLabel container;

	public void start() {
		container = new JLabel();
		//form
		final JTextField txt = new JTextField("",20);
		JButton but = new JButton();
		but.setText("Submit");
		//add
		add(container);
		add(txt);
		add(but);
		//listener
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = txt.getText();
				OsController.getInstance().execute(command); //jAutomatic execute
			}
		});
		//configuration
		setLayout(new FlowLayout());
		setSize(370, 34);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]) {
		new ExecuteCommand().start();
	}
}
