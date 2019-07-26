import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class DriverGui{

	JFrame frm;
	JButton alpha;
	JButton beta;
	JLabel label;
	JPanel flow;
	
	
	public DriverGui(){
		
		prepareGui();
		
	}
	
	private void prepareGui() {
		
		frm = new JFrame("Demo 3");
		frm.setSize(300, 100);
		frm.setLayout(new GridBagLayout());
		
		flow = new JPanel(new FlowLayout());
		alpha = new JButton("Alpha");
		beta = new JButton("Beta");
		label = new JLabel("Push a Button!");
		
		alpha.addActionListener((ae) -> {
			label.setText("Alpha was pressed.");
		});
		
		beta.addActionListener((ae) -> {
			label.setText("Beta was pressed");
		});
		
		flow.add(alpha);
		flow.add(beta);
		flow.add(label);
		
		frm.add(flow);
		frm.setVisible(true);
		
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
	}//end prepareGui
	
}//end DriverGui class