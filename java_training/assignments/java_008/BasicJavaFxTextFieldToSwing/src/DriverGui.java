import java.awt.Dimension;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class DriverGui {

	JFrame frm;
	JPanel panel;
	JLabel topLabel;
	JTextField textField;
	JButton button;
	JPanel bottomPanel;
	JLabel search;
	JLabel output;
	
	public DriverGui() {
		
		frm = new JFrame("TextField Demo");
		frm.setSize(350, 180);
		frm.setLayout(new GridBagLayout());
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//panel.setSize(new Dimension(1000, 1000));
		
		bottomPanel = new JPanel(new FlowLayout());
		
		topLabel = new JLabel("TextField Demo");
		topLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		textField = new JTextField();
		textField.setMaximumSize(new Dimension(100, 25));
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		button = new JButton("Get Search String");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		search = new JLabel("Search String: ");
		output = new JLabel(" ");
		output.setMaximumSize(new Dimension(50, 25));
		
		textField.addActionListener((ae) -> {

			output.setText(textField.getText());
			
		});
		
		button.addActionListener((ae) -> {
			//search.setText("Search String: " + textField.getText());
			output.setText(textField.getText());
		});
				
		bottomPanel.add(search);
		bottomPanel.add(output);
		bottomPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.add(topLabel);
		panel.add(textField);
		panel.add(button);
		panel.add(bottomPanel);
		
		frm.add(panel, new GridBagConstraints());
		frm.setVisible(true);
		
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
	}//end DriverGui
	
	
}//end DriverGui class