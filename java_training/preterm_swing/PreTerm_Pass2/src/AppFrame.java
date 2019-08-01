// A simple Swing Class
import javax.swing.*;

public class AppFrame {
	private JFrame jfrm;
	AppFrame(String title) {
		// Create a new JFrame container.
		jfrm = new JFrame(title);
	}
	public JFrame getFrame() {
		return jfrm;
	}

}
