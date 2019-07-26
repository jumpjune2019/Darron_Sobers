import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Main {

	
	public static void main(String[] args) {
		
		prepareGui();
		
		
	}//end main
	
	
	public static void prepareGui() {
		
		JFrame frm = new JFrame("Hello World!");
		frm.setSize(300, 250);
		frm.setLayout(new GridBagLayout());
				
		JButton button = new JButton("Say 'Hello World!'");
		button.setSize(40, 40);
		
		button.addActionListener((ae) -> {
			
			System.out.println("Hello World!");
			
		});
		
		frm.add(button, new GridBagConstraints());
		frm.setVisible(true);
		
		
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
	}//end prepareGui
	
}