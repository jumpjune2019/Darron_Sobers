import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class DriverGui {

	JFrame frm;
	JPanel panel;
	JLabel top;
	JToggleButton button;
	JLabel bottom;
	
	
	public DriverGui() {
		
		frm = new JFrame("Toggle Button Demo");
		frm.setSize(300, 220);
		frm.setLayout(new GridBagLayout());
	
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		top = new JLabel("Push a Button");
		button = new JToggleButton("On/Off");
		bottom = new JLabel(" ");
		
		ItemListener itemListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				int state = e.getStateChange();
				
				if(state == ItemEvent.SELECTED) {
					bottom.setText("Button is On");
				}else {
					bottom.setText("Button is Off");
				}
					
			}//end itemStateChanged
			
		};//end ItemListener
		
		
		button.addItemListener(itemListener);
		panel.add(top);
		panel.add(button);
		panel.add(bottom);
		
		frm.add(panel, new GridBagConstraints());
		
		frm.setVisible(true);
		
		
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		
	}
	
	
	
}