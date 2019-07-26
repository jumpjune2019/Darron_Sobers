import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
	JFrame frm;
	JLabel head;
	JLabel tail;
	JComboBox jCB;
	JPanel headerPanel, comboPanel, selectedPanel, allInOne;
	
	Main() {
		frm = new JFrame("Swing comboPanelbox Demo");
		frm.setLocationRelativeTo(null);
		frm.setLayout(new GridBagLayout());
		frm.setSize(new Dimension(300, 250));
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] trans = {"Train", "Car", "Airplane"};
		tail = new JLabel(" ");
		headerPanel = new JPanel();
		comboPanel = new JPanel();
		selectedPanel = new JPanel();
		allInOne = new JPanel();
		allInOne.setLayout(new BoxLayout(allInOne, BoxLayout.Y_AXIS));
		
		head = new JLabel("Select Transport Type");
		jCB = new JComboBox(trans);
		jCB.setPreferredSize(new Dimension(200, 20));
		jCB.addActionListener(e -> {
			// cast each element of JcomboPanelBox to a String
			String str = (String) jCB.getSelectedItem();
			tail.setText("Selected Panel: " + str);
		});
		
		headerPanel.add(head);
		comboPanel.add(jCB);
		selectedPanel.add(tail);
		allInOne.add(headerPanel);
		allInOne.add(comboPanel);
		allInOne.add(selectedPanel);
		
		frm.add(allInOne);
		frm.setVisible(true);
	}
	
	public static void main(String args[]) {
		// Create the frame on the event dispatching thread.
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new Main();
				}
			});
}
}
