//Demonstrate a simple JList.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
class Main {
	
	DefaultListModel listModel;
	JList<String> jlst;
	JLabel jlab;
	JLabel headerLabel;
	JScrollPane jscrlp;
	JButton addItem;
	JButton deleteItem;
	JPanel panel;
	
	// Create an array of names.
//	String names[] = { "Train", "Car", "Airplane" };

	Main() {
		// Create a new JFrame container.
		JFrame jfrm = new JFrame("ListView to JList");
		// Specify a flow Layout.
		jfrm.setLayout(new GridBagLayout());
		// Give the frame an initial size.
		jfrm.setSize(250, 250);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		// Terminate the program when the user closes the application.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listModel = new DefaultListModel();
		listModel.addElement("Train");
		listModel.addElement("Car");
		listModel.addElement("Airplane");
		// Create a JList.
		jlst = new JList<String>(listModel);
		// Set the list selection mode to single-selection.
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Add list to a scroll pane.
		jscrlp = new JScrollPane(jlst);
		// Set the preferred size of the scroll pane.
		jscrlp.setPreferredSize(new Dimension(120, 90));
		// Make a label that displays the selection.
		jlab = new JLabel("Nothing Selected           ");
		jlab.setAlignmentX(Component.CENTER_ALIGNMENT);
		headerLabel = new JLabel("Select Transport Type");
		headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		addItem = new JButton("Add an Item");
		addItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteItem = new JButton("Remove first Item");
		deleteItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		addItem.addActionListener(e -> {
			listModel.addElement("Test");
		});
		deleteItem.addActionListener(e -> {
			if(listModel.size() != 0) {
				listModel.remove(0);
			}
		});
		// Add list selection handler.
		// converted into lambda expression
		jlst.addListSelectionListener(e -> {
			valueChange(e);
		});
		// Add the list and label to the content pane.
		
		panel.add(headerLabel);
		panel.add(jscrlp);
		panel.add(jlab);
		panel.add(addItem);
		panel.add(deleteItem);
		// Display the frame.
		
		jfrm.add(panel, new GridBagConstraints());
		jfrm.setVisible(true);
	}
	
	// Handle list selection events.
	public void valueChange(ListSelectionEvent le) {
		// Get the index of the changed item.
		String idx = jlst.getSelectedValue();
		// Display selection, if item was selected.
			jlab.setText("Transport selected is " + idx);
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