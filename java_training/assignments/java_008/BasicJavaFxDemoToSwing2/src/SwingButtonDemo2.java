import javax.swing.*;
import java.awt.*;

public class SwingButtonDemo2 {
	public static CenterAndSizeInterface c = ( frm, width, height) -> {
		// set the size of the frame to half in width and height
		frm.setSize(width/2, height/2);
		// here's the part where the JFrame gets actually centered
		frm.setLocationRelativeTo(null);
	};

	public static SetFrameStuffInterface s = (frm, onExit, width, height) -> {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		c.centerAndSizeJFrameOnScreen(frm, width, height);
		frm.setDefaultCloseOperation(onExit);
		
		JPanel panel1 = new JPanel();
		
		panel1.setLayout(new GridLayout(3,1));
		
		ButtonDemo bd = new ButtonDemo();
		bd.setBtns.setButtons(panel1, "say 'Hello'", "Reset", "hello!", "");
		
		frm.add(panel1);
		return frm;
	};
	
	public JButton createBtns(String btnLabel) {
		JButton jb = new JButton(btnLabel);
		return jb;
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			SwingJFrame demo;
			JFrame frm;
			
			public void run() {
				demo = new SwingJFrame("Playing with JButton using a FlowLayout");
				frm = demo.getFrame();
				frm = s.setFrameStuff(frm, JFrame.EXIT_ON_CLOSE, 400, 380);
				frm.setVisible(true);
			}
		});
	}

}
