import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class Main {
	private static JLabel head,foot;
	private static JPanel top, middle, bottom;
	private static JList<String> clientList;
	private static JScrollPane jScroll;
	
	public static JFrame setFrameStuff(JFrame frm, int width, int height, int onExit) {
		// Give the frame an initial size.		
		frm.setSize(width, height);
		// Centers JFrame
		frm.setLocationRelativeTo(null);
		// Terminate the program when the user closes the application.
		// Swing has events and as such there are other ways to deal with this
		// Some parameters for setDefaultCloseOperation (all integers)
		// JFrame.EXIT_ON_CLOSE <-- current one being passed
		// JFrame.HIDE_ON_CLOSE
		// JFrame.DO_NOTHING_ON_CLOSE
		frm.setDefaultCloseOperation(onExit);
		frm.setLayout(new BorderLayout());
		
		top = new JPanel();
		middle = new JPanel();
		bottom = new JPanel();
		head = new JLabel("My Second Matrix Demo", JLabel.CENTER);
		foot = new JLabel("\"Reset Entire Matrix\" and Print list of assigned clients in console", JLabel.CENTER);
		
		// demo array
		String[] demo = {"***This is a Demo***", "***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***"};
		// added the Jlist to the middle component
		middle.add(addJList(demo));
		top.setBackground(Color.CYAN);
		bottom.setBackground(Color.CYAN);
		top.add(head);
		frm.add(top, BorderLayout.NORTH);
		middle.add(addCenterGridPanel(10,10));
		frm.add(middle, BorderLayout.EAST);
		frm.add(middle, BorderLayout.CENTER);
		bottom.add(foot);
		frm.add(bottom, BorderLayout.SOUTH);
		return frm;
	}
	
	// method initializes first row of grid by returning seat titles
	public static JPanel addGridCellTitles(String label){
		JLabel seat = new JLabel(label, JLabel.CENTER);
		JPanel title = new JPanel();
		// sets the cells to host a Box Layout
		title.setLayout(new BoxLayout(title, BoxLayout.Y_AXIS));
		// set the size of the cell
		title.setPreferredSize(new Dimension(30, 30));
		title.add(seat);
		return title;
	}
	
	// method initializes first row of grid by returning seat titles
		public static JPanel addClientCells(String label){
			JLabel availability = new JLabel(label, JLabel.CENTER);
			JPanel seat = new JPanel();
			JPanel topLabel = new JPanel();
			topLabel.setLayout(new BorderLayout());
			JPanel btnPanel = new JPanel();
			btnPanel.setLayout(new BorderLayout());
			JToggleButton bookBtn = new JToggleButton(" Book ");
			bookBtn.setPreferredSize(new Dimension(40, 40));
			bookBtn.addActionListener(e -> {
				if (bookBtn.isSelected()) {
					bookBtn.setText("Unbook");
				} else {
					bookBtn.setText("Book");
				}
			});
			topLabel.add(availability);
			btnPanel.add(bookBtn);
			// sets the cells to host a Box Layout
			seat.setLayout(new BoxLayout(seat, BoxLayout.Y_AXIS));
			// set the size of the cell
			seat.setPreferredSize(new Dimension(80, 50));
			seat.add(topLabel, BorderLayout.NORTH);
			seat.add(btnPanel, BorderLayout.SOUTH);
			return seat;
		}
		
		
		
	// add Clients to JList wrapped in a JScrollPane
		// method to return and set up JList
		public static JScrollPane addJList(String[] arr) {
			DefaultListModel<String> demo = new DefaultListModel<String>();
			// add elements to String array
			for(String s : arr) {
				demo.addElement(s);				
			}
			clientList = new JList<String>(demo);
			// Set the list selection mode to single-selection.
			clientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jScroll = new JScrollPane(clientList);
			jScroll.setPreferredSize(new Dimension(200,300));
			clientList.addListSelectionListener(e -> {
				System.out.println("I am working!!!");
			});
			return jScroll;
		}	
		
	// method to return and set up Grid
	public static JPanel addCenterGridPanel(int row, int col) throws NullPointerException {
		int gridRow = row + 1;
		int gridCol = col + 1;
		JPanel gridPanel = new JPanel();
		GridLayout layout = new GridLayout(gridRow,gridCol);
		gridPanel.setLayout(layout);
		// nested for loop appends cells to gridPanel
		for(int r = 0; r < gridRow; r++) {
			char alpha = 'A';
			for(int c = 0; c < gridCol; c++) {
				if(r == 0 && c == 0) {
					gridPanel.add(addGridCellTitles("     "));
				} else if(r == r && c == 0) {
					gridPanel.add(addGridCellTitles("Row " + (char)(alpha + r - 1)));
				} else if(r == 0 && c == c) {
					gridPanel.add(addGridCellTitles("Seat " + String.valueOf(c)));					
				} else {
//						gridPanel.add(addGridCellTitles("Vacant"));
						// adding client cells
						gridPanel.add(addClientCells("Vacant"));
						}
				}// End of inner for loop
			}// End of outer for loop
		return gridPanel;
	}// End of addCenterGridPanel() method
	
	
	
	public static void main(String[] args) {
	// Create the frame on the event dispatching thread.
	SwingUtilities.invokeLater(new Runnable() {
		AppFrame app;
		JFrame frm;
		public void run() {
			app = new AppFrame("Pass Two");
			frm = app.getFrame();
			frm = setFrameStuff(frm, 1200, 720, JFrame.EXIT_ON_CLOSE);
			frm.setVisible(true);
		}
	});
	}
}
