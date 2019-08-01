import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Main {
	private static JLabel head,foot;
	public static JPanel top, middle, bottom;
	private static JList<String> clientList;
	private static JScrollPane jScroll;
	private static DefaultListModel<String> demo;
	private static Room roomDB1;
	private static GridLayout layout;
	private static Client currentClient;
	public static JButton resetMatrixBtn;
	public static JButton printMatrixBtn;
	public static JButton printClientsInRoom;
	public static JPanel footerBtns;
	public static JPanel gridPanel;
	public static ClientStore myStoreTest = new ClientStore("clients_list.csv");
	public static Client[] store = myStoreTest.getClientStore();
	public static JFrame frm;
	public static AppFrame app;
	
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
//		foot = new JLabel("\"Reset Entire Matrix\" and Print list of assigned clients in console", JLabel.CENTER);
		
		// demo array
		String[] demo = {"***This is a Demo***", "***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***","***This is a Demo***"};
//		ClientStore myStoreTest = new ClientStore("clients_list.csv");
//		Client[] store = myStoreTest.getClientStore();
		// added the Jlist to the middle component
		middle.add(addCenterGridPanel(10,10));
		middle.add(addJList(store));
		//******************8 Attempted to insert clients randomly is buggy************
//		// adding clients to room database
//		roomDB1.insertClients(store, roomDB1.getRoomMatrix());
		//******************8 Attempted to insert clients randomly is buggy************
		top.setBackground(Color.CYAN);
		bottom.setBackground(Color.CYAN);
		footerBtns = new JPanel();
		resetMatrixBtn = new JButton("Reset Room");
		printClientsInRoom = new JButton("Print Clients In Room");
		printClientsInRoom.addActionListener(e -> {
			System.out.println("\n************************* Clients in Room Only *************************\n");
			roomDB1.printClientsMatrix(roomDB1.getRoomMatrix(), null, roomDB1);	
			
		});
		resetMatrixBtn.addActionListener(e -> {
			System.out.println("\n************************* Room Has Been Reset *************************\n");
			roomDB1.resetMatrix(roomDB1.getRoomMatrix(), null, roomDB1);	
			
		});
		printMatrixBtn = new JButton("Print Room");
		printMatrixBtn.addActionListener(e -> {
			System.out.println("\n************************* Room Has Been Printed *************************\n");
			roomDB1.printOutMatrix(roomDB1.getRoomMatrix());
		});
		footerBtns.add(printClientsInRoom);
		footerBtns.add(resetMatrixBtn);
		footerBtns.add(printMatrixBtn);
		bottom.add(footerBtns);
		top.add(head);
		frm.add(top, BorderLayout.NORTH);
		frm.add(middle, BorderLayout.EAST);
		frm.add(middle, BorderLayout.CENTER);
//		bottom.add(foot);
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
		public static JPanel addClientCells(String label, Room rm, int r, int c){
			rm.getRoomMatrix()[r-1][c-1] = new Seat(r-1,c-1);
//			JLabel availability = new JLabel();
			//bookBtn = new JToggleButton[r-1][c-1];
		//	bookBtn[li].setActionCommand(String.valueOf(li));
			JLabel availability = new JLabel(label, JLabel.CENTER);
			JPanel seat = new JPanel();
			JPanel topLabel = new JPanel();
			topLabel.setLayout(new BorderLayout());
			JPanel btnPanel = new JPanel();
			btnPanel.setLayout(new BorderLayout());
//			bookBtn[li] = new JToggleButton(" Book ");
			JToggleButton newBookBtn = new JToggleButton(" Book ");
			newBookBtn.setPreferredSize(new Dimension(40, 40));
			newBookBtn.addActionListener(e -> {
				System.out.println("clicked");
				if (newBookBtn.isSelected()) {
					newBookBtn.setText("Unbook");
					newBookBtn.setSelected(true);
//					newBookBtn.setBackground(Color.RED);
					// assigns JLabel of seat to the client selected from list
					availability.setText(currentClient.getFullClientIdAndInitials());
					//actually setting the client in seat
					rm.getRoomMatrix()[r-1][c-1].setClientInSeat(currentClient);
					rm.getRoomMatrix()[r-1][c-1].setCanBeAssigned(false);
					
					// prints out seat info ****** Test 1 assigned ******
//					System.out.println(rm.getRoomMatrix()[r-1][c-1].toString());
//					// prints out clients first name ****** Test 2 assigned ******
//					System.out.println(currentClient.getClientFirstName());
					// returns a reference to the client object ****** Test 3 assigned ******
//					System.out.println(rm.getRoomMatrix()[r-1][c-1].getClientInSeat());
					// prints out seat row ****** Test 4 assigned ******
//					System.out.println("Row " + rm.getRoomMatrix()[r-1][c-1].getMySeatX());
					// prints out seat column ****** Test 5 assigned ******
//					System.out.println("Column " + rm.getRoomMatrix()[r-1][c-1].getMySeatY());
				} else if (!(newBookBtn.isSelected())) { 
					if(rm.getRoomMatrix()[r-1][c-1].getCanBeAssigned() == false) {
						System.out.printf("\n%s is already assigned!\n", rm.getRoomMatrix()[r-1][c-1].getClientInSeat().getClientFirstName());
						newBookBtn.setSelected(true);
					} else if(rm.getRoomMatrix()[r-1][c-1].getCanBeAssigned() == true) {
						newBookBtn.setSelected(false);
					newBookBtn.setText("Book");
					availability.setText("Vacant");
					Client s = rm.getRoomMatrix()[r-1][c-1].getClientInSeat();
					// takes the client out of the seat
					rm.getRoomMatrix()[r-1][c-1].setClientInSeat(null);
					// prints out empty seat test ****** Test 6 assigned ******
					System.out.println(rm.getRoomMatrix()[r-1][c-1].getClientInSeat());
					rm.getRoomMatrix()[r-1][c-1].setCanBeAssigned(true);
					// prints out seat info
					System.out.println(rm.getRoomMatrix()[r-1][c-1].toString());
					}
				}
			});
			topLabel.add(availability);
			btnPanel.add(newBookBtn);
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
		public static JScrollPane addJList(Client[] arr) {
			demo = new DefaultListModel<String>();
			// add elements to String array
			for(Client s : arr) {
				demo.addElement(s.getClientId() + s.getClientFirstName() + " " + s.getClientLastName());				
				
			}
			clientList = new JList<String>(demo);
			// Set the list selection mode to single-selection.
			clientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jScroll = new JScrollPane(clientList);
			jScroll.setPreferredSize(new Dimension(200,300));
			clientList.addListSelectionListener(e -> {
//				Test to make sure itemListener is working
//				System.out.println(clientList.getSelectedObjects());
				String clientName = clientList.getSelectedValue();
//				Client client = null;
				
				for (Client s : arr) {
					if (clientName.equals(s.getClientId() + s.getClientFirstName() + " " + s.getClientLastName())) {
						currentClient = s;
						System.out.println(currentClient.getClientFirstName());
						break;
					}
				}
				// prints out current Client selected on JList
//				System.out.println(currentClient.getClientFirstName());
//				roomDB1.getRoomMatrix()[3][3].setOccupied(client);
//				System.out.println(Arrays.deepToString(roomDB1.getRoomMatrix()));
//				System.out.println(roomDB1.getRoomMatrix()[3][3].getOccupied().getSeatAssignment());
			});
			return jScroll;
		}	
		
		// Handle list selection events.
		public void valueChanged(ListSelectionEvent le) {
			// Get the index of the changed item.
			int idx = clientList.getSelectedIndex();
			// Display selection, if item was selected.
			if(idx != -1) {
//				jlab.setText("Current selection: " + names[idx]);
				System.out.println("baby step");
			} else {
				// Otherwise, reprompt.
//				jlab.setText("Please choose a name");
			}
		}
		
	// method to return and set up Grid
	public static JPanel addCenterGridPanel(int row, int col) throws NullPointerException {
		
		roomDB1 = new Room(row, col);
		int gridRow = row + 1;
		int gridCol = col + 1;
		gridPanel = new JPanel();
		layout = new GridLayout(gridRow,gridCol);
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
				} else if (r >= 1 && c >= 1){	
//						gridPanel.add(addGridCellTitles("Vacant"));
						// adding client cells
						gridPanel.add(addClientCells("Vacant", roomDB1, r, c));
//						roomDB1.initializeSeatArray(roomDB1.getRoomMatrix());
						
				}
				}// End of inner for loop
			}// End of outer for loop
		
		// Testing to see Room Database output
//		roomDB1.printOutMatrix(roomDB1.getRoomMatrix());
		return gridPanel;
	}// End of addCenterGridPanel() method
	
	
	
	public static void main(String[] args) {
	// Create the frame on the event dispatching thread.
	SwingUtilities.invokeLater(new Runnable() {
		
		
		public void run() {
			app = new AppFrame("Pass Two");
			frm = app.getFrame();
			frm = setFrameStuff(frm, 1200, 720, JFrame.EXIT_ON_CLOSE);
			frm.setVisible(true);
		}
	});
	}
}
