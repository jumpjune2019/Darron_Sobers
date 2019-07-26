import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class DriverGui {

	JFrame frm;
	JPanel panel;
	JLabel pushAButton;
	JLabel showLabel;
	JButton reset;
	ButtonImage fungi;
	ButtonImage dairy;
	
	
	public DriverGui() {
	
		frm = new JFrame("Using Images with buttons");
		frm.setSize(250, 350);
		frm.setLayout(new GridBagLayout());
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		pushAButton = new JLabel("Push a Button");
		pushAButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		showLabel = new JLabel(" ");
		showLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		fungi = new ButtonImage("C:/java_training/JavaFXtoSwing/BasicJavaFxButtonImageToSwing/src/fungi.png", "Fungi", showLabel);
		fungi.setMaximumSize(new Dimension(100, 50));
		dairy = new ButtonImage("C:/java_training/JavaFXtoSwing/BasicJavaFxButtonImageToSwing/src/dairy.png", "Dairy", showLabel);
		dairy.setMaximumSize(new Dimension(100, 50));

		reset = new JButton("Reset");
		reset.setMaximumSize(new Dimension(80, 30));
		reset.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		reset.addActionListener((ae) -> {
			showLabel.setText(" ");
		});
		
		panel.add(pushAButton);
		panel.add(fungi);
		panel.add(showLabel);
		panel.add(dairy);
		panel.add(reset);
		
		frm.add(panel, new GridBagConstraints());
		frm.setVisible(true);
		
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
	}//end DriverGui
	
}//end DriverGui class