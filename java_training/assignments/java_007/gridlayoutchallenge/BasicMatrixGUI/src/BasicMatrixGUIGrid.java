import java.awt.Color;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class BasicMatrixGUIGrid {
	JFrame matrixFrame;
	
	JLabel header;
	JLabel footer;
	JPanel controlPanel;
	JPanel panel;

	int row = randomIndex();
	int col = randomIndex();
	
	public BasicMatrixGUIGrid() {
		prepGUI();
	}
	
	private void prepGUI() {
		// create JFrame and its title
		matrixFrame = new JFrame("Basic Matrix Demo");
		matrixFrame.setSize(new Dimension((col*50), (row*50) + 80));
		matrixFrame.setLayout(new BorderLayout());
		header = new JLabel("Basic Matrix Demo", JLabel.CENTER);
		footer = new JLabel("No seat selected", JLabel.CENTER);
		controlPanel = new JPanel();
		matrixFrame.add(header, BorderLayout.NORTH);
		matrixFrame.add(controlPanel, BorderLayout.CENTER);
		matrixFrame.add(footer, BorderLayout.SOUTH);
		// program terminates on close of window
		matrixFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		matrixFrame.setLocationRelativeTo(null);
		matrixFrame.setVisible(true);
	}
	
	
	public void showGridLayout() throws NullPointerException {
		// creates JPanel for Grid Layout
		panel = new JPanel();
		panel.setSize(new Dimension(row*50 , col*50));
		panel.setBackground(Color.RED);
		GridLayout layout = new GridLayout(row,col);
		
		// created initial row letter
		char alpha = 'A';
		char alphaTemp = alpha;
		// resets after each row is completed
		int iExtra = 0;
		// nested for loop appends cells to panel
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				// adds the cells to the Grid of the JPanel
				panel.add(addCellToGrid(alphaTemp, iExtra));
				iExtra++;
			}
			alphaTemp++;
			iExtra = 0;
		}
		panel.setLayout(layout);
		controlPanel.add(panel);
	}

	// returns a random number between 2 and 5
	int randomIndex() {
		// min = 2 and max = 5
		// range = max - min + 1 >>> range = 5 - 2 + 1 = 4, therefore...
		// (int) (Math.random() * range) + min >>>> is the formula used below
		return (int) (Math.random() * 4) + 2;
	}

	// created method to allocate each cell
	private JPanel addCellToGrid(char a, int i) {
		JButton jBtn = new JButton(a + " - " + (i + 1));
		jBtn.addActionListener(ae ->  {
			footer.setText(ae.getActionCommand());
		});
		String label = (a + " - " +  (i + 1)).toString();

		JLabel cellLabel = new JLabel(label, JLabel.CENTER);
		JPanel cell = new JPanel();
		// sets the cells to host a Box Layout
		cell.setLayout(new BoxLayout(cell, BoxLayout.Y_AXIS));
		// set the size of the cell
		cell.setSize(new Dimension(50, 50));
		cell.setBackground(Color.GREEN);
		// adds a label to the cell
		cell.add(cellLabel);
		// adds a button
		cell.add(jBtn);
		return cell;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BasicMatrixGUIGrid matrixG = new BasicMatrixGUIGrid();
				matrixG.showGridLayout();
			}
		});  
	}
}
