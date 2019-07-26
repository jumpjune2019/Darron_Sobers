import javax.swing.*;

public class SwingJFrame {
	private JFrame jfrm;
	SwingJFrame(String title) {
		// Create a new JFrame container.
		jfrm = new JFrame(title);
		jfrm.setLayout(new BoxLayout(jfrm.getContentPane(), BoxLayout.Y_AXIS));
	}
	public JFrame getFrame() {
		return jfrm;
	}
}
