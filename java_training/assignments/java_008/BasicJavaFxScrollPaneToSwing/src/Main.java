import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
	JFrame frm;
	JButton jBtn;
	JLabel jLab;
	JLabel text;
	JPanel panel;
	JScrollPane sPane;
	JTextArea jTex;
	String msg;
	JTextArea textArea;
	
	Main() {
		frm = new JFrame("JavaFX to Swing ScrollPane");
		frm.setLayout(new FlowLayout());
		jLab = new JLabel("ScrollPane Demo");
		jBtn = new JButton("Reset Scroll Pane to Top/Left");
		frm.setSize(new Dimension(260, 300));
		frm.setLocationRelativeTo(null);
		
		
		msg = "I am going to get a kickass job, and learn \n"
				+ "everyday. This is the mindset I have working\n"
				+ "with an amazing company like Collabera.\n"
				+ "I know that I could have went anywhere but coming\n"
				+ "here just felt like the right thing to do!\n"
				+ "Thanks Collabera!, Sincerely, Deron Franklin Sobers II\n"
				+ "I am going to get a kickass job, and learn \n"
				+ "everyday. This is the mindset I have working\n"
				+ "with an amazing company like Collabera.\n"
				+ "I know that I could have went anywhere but coming\n"
				+ "here just felt like the right thing to do!\n"
				+ "Thanks Collabera!, Sincerely, Deron Franklin Sobers II\n";
		
		textArea = new JTextArea(msg, 7, 20);
		sPane = new JScrollPane(textArea);
		sPane.setSize(new Dimension(50, 50));
		
		
		
		//pulled from stack overflow.come
		//source https://stackoverflow.com/questions/31171502/scroll-jscrollpane-by-dragging-mouse-java-swing
		//ty based overflow
		MouseAdapter ma = new MouseAdapter() {

            private Point origin;

            @Override
            public void mousePressed(MouseEvent e) {
                origin = new Point(e.getPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (origin != null) {
                    JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, textArea);
                    if (viewPort != null) {
                        int deltaX = origin.x - e.getX();
                        int deltaY = origin.y - e.getY();

                        Rectangle view = viewPort.getViewRect();
                        view.x += deltaX;
                        view.y += deltaY;

                        textArea.scrollRectToVisible(view);
                    }
                }
            }//end mouseDragged

        };//end MouseAdapter
		
		textArea.addMouseListener(ma);
		textArea.addMouseMotionListener(ma);
		//sPane.setAutoscrolls(true);
		jBtn.addActionListener(e -> {
			sPane.getVerticalScrollBar().setValue(0);
			sPane.getHorizontalScrollBar().setValue(0);
		});
		frm.add(jLab);
		frm.add(sPane);
		frm.add(jBtn);
		frm.setVisible(true);
		
		frm.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	             // this is the way to force a java application to gracefully exit
	             // when not going to end via the main method entry point
	             System.exit(0);
	         }        
	      });
		
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
