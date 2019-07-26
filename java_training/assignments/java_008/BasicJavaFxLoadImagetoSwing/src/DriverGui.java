
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class DriverGui {

	JFrame frm;
	JLabel label;
	ImageIcon image;
	
	public DriverGui() {
		
		prepareGui();
		
	}
	
	
	private void prepareGui() {
		
		frm = new JFrame("Fungi is Hilarious!");
		frm.setSize(540, 540);
		
		image = new ImageIcon("C:/java_training/JavaFXtoSwing/BasicJavaFxLoadImagetoSwing/src/fungi.png");
		label = new JLabel(image);
		
		frm.add(label);
		frm.setVisible(true);
		
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
	}//end prepareGui
	
	
}//end DriverGui