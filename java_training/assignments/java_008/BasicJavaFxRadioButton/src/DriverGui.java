import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class DriverGui implements ActionListener{

	JFrame frm;
	JPanel panel;
	JLabel top;
	JRadioButton b1;
	JRadioButton b2;
	JRadioButton b3;
	JRadioButton b4;
	ButtonGroup g;
	JLabel showButton;
	
	public DriverGui() {
		
		frm = new JFrame("Radio Buttons Demo");
		frm.setSize(300, 200);
		frm.setLayout(new GridBagLayout());
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		top = new JLabel("Radio Buttons");
		
		b1 = new JRadioButton("Train");
		b1.addActionListener(this);
		b2 = new JRadioButton("Car");
		b2.addActionListener(this);
		b3 = new JRadioButton("Plane");
		b3.addActionListener(this);
		b4 = new JRadioButton("Boat");
		b4.addActionListener(this);
		
		g = new ButtonGroup();
		
		showButton = new JLabel(" ");
		
		
		g.add(b1);
		g.add(b2);
		g.add(b3);
		g.add(b4);
		
		panel.add(top);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(showButton);
		
		frm.add(panel, new GridBagConstraints());
		frm.setVisible(true);
		
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
	}//end DriverGui constructor

	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(b1.isSelected()) {
			showButton.setText("Train");
		}else if(b2.isSelected()) {
			showButton.setText("Car");
		}else if(b3.isSelected()) {
			showButton.setText("Plane");
		}else if(b4.isSelected()) {
			showButton.setText("Boat");
		}
		
		
	}
	
	
}//end DriverGui class