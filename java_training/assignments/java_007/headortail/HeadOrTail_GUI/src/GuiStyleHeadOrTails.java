import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

//import lambdaheadortail.Flipper;
//import lambdaheadortail.HeadOrTails;

public class GuiStyleHeadOrTails implements ActionListener {
	JFrame htGame;
	JLabel results;
	JButton flipBtn;
	JButton resetBtn;
	
	// lambda expression in a block of code
	Flipper pickSide = () -> {
		int side = (int) (Math.random()*2) + 1;
		return side;
	};
	
	// lambda expression in a block of code
	HeadOrTails select = (p) -> {
		if(p == 1) {
			return "Head";
		} else {
			return "Tail";
		}
	};

	GuiStyleHeadOrTails() {
		// create a new JFrame container
		// as well as the title of the JFrame
		htGame = new JFrame("Heads Or Tails");
		htGame.setLayout(new FlowLayout());
		// sets the dimensions of JFrame window
		htGame.setSize(100, 150);
		// Terminates program on closing of window
		htGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// created a label for result of coin flip
		// that initially says waiting
		results = new JLabel("waiting...");
		
		// created a button to initiate the coin flip
		flipBtn = new JButton("Click to Flip");
		resetBtn = new JButton("reset");
		
		// allows the buttons to cause something to happen
		// based on what the actionPerformed method defines
		// for each button
		flipBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		
		// adding components to JFrame
		htGame.add(flipBtn);
		htGame.add(results);
		htGame.add(resetBtn);
		htGame.setVisible(true);
	}
		// Handle button events.
		public void actionPerformed(ActionEvent ae) {
			String action = ae.getActionCommand();
			switch(action) {
			case "reset":
				results.setText("waiting...");
				break;
			case "Click to Flip" : {
				
				results.setText("You flipped " + select.coinSide(pickSide.flipCoin()));
				break;
			}
			}
		}
	
	public static void main(String[] args){
		// spawns the JFrame on the event dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GuiStyleHeadOrTails();
			}
		});      
   }
}
