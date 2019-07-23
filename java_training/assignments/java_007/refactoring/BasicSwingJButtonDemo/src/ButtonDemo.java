import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;

public class ButtonDemo  {
	JLabel jlab;
	String first;
	String second;
	String firstMsg;
	String secondMsg;
	
	public SetButtonsInterface setBtns = (frm, f, s, fMsg, sMsg) -> {
		first = f;
		second = s;
		firstMsg = fMsg;
		secondMsg = sMsg;
		
		JButton jbtnUp = new JButton(first);
		JButton jbtnDown = new JButton(second);
		// Add action listeners.
		// lambda implementation of actionListener
		// implicitly implements the ActionListener interface
		jbtnUp.addActionListener(e -> {
			jlab.setText(firstMsg);
		});
		// lambda implementation of actionListener
		// implicitly implements the ActionListener interface
		jbtnDown.addActionListener(e -> {
			jlab.setText(secondMsg);
		});
		// Add the buttons to the content pane.
		frm.add(jbtnUp);
		frm.add(jbtnDown);
		// Create a label.
		jlab = new JLabel("Press a button.");
		// Add the label to the frame.
		frm.add(jlab);
	};
}
