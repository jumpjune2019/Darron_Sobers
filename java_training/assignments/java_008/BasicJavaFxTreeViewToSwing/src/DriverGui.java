import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.tree.TreePath;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class DriverGui {

	boolean toggle;
	JFrame frm;
	JTree tree;
	JToggleButton button;
	JPanel panel;
	JLabel top;
	JPanel temp;
	JLabel selection;
	JLabel path;
	
	public DriverGui() {
		
		toggle = false;
		frm = new JFrame("Tree View Demo");
		frm.setSize(850, 600);
		frm.setLayout(new BorderLayout());
		
		panel = new JPanel(new BorderLayout());
		temp = new JPanel();
		temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
		
		top = new JLabel("TreeViewDemo");
		
		DefaultMutableTreeNode food = new DefaultMutableTreeNode("Food");
		DefaultMutableTreeNode fruits = new DefaultMutableTreeNode("Fruits");
		DefaultMutableTreeNode apples = new DefaultMutableTreeNode("Apples");
		
		DefaultMutableTreeNode fuji = new DefaultMutableTreeNode("Fuji");
		DefaultMutableTreeNode winesap = new DefaultMutableTreeNode("Winesap");
		DefaultMutableTreeNode clark = new DefaultMutableTreeNode("Clark");
		
		DefaultMutableTreeNode nuts = new DefaultMutableTreeNode("Nuts");
		DefaultMutableTreeNode vegetables = new DefaultMutableTreeNode("Vegetables");
		DefaultMutableTreeNode pears = new DefaultMutableTreeNode("Pears");
		DefaultMutableTreeNode oranges = new DefaultMutableTreeNode("Oranges");
		DefaultMutableTreeNode corn = new DefaultMutableTreeNode("Corn");
		DefaultMutableTreeNode peas = new DefaultMutableTreeNode("Peas");
		DefaultMutableTreeNode broccoli = new DefaultMutableTreeNode("Broccoli");
		DefaultMutableTreeNode beans = new DefaultMutableTreeNode("Beans");
		
		DefaultMutableTreeNode walnuts = new DefaultMutableTreeNode("Walnuts");
		DefaultMutableTreeNode almonds = new DefaultMutableTreeNode("Almonds");
		DefaultMutableTreeNode pistachios = new DefaultMutableTreeNode("Pistachios");
		DefaultMutableTreeNode cashews = new DefaultMutableTreeNode("Cashews");
		
		food.add(fruits);
		food.add(vegetables);
		food.add(nuts);
		
		fruits.add(apples);
		apples.add(fuji);
		apples.add(winesap);
		apples.add(clark);
		
		fruits.add(pears);
		fruits.add(oranges);
		
		vegetables.add(corn);
		vegetables.add(peas);
		vegetables.add(broccoli);
		vegetables.add(beans);
		
		nuts.add(walnuts);
		nuts.add(almonds);
		nuts.add(pistachios);
		nuts.add(cashews);
		
		
		tree = new JTree(food);
		
		button = new JToggleButton("Collapse All");
		
		ItemListener itemListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				int state = e.getStateChange();
				
				if(state == ItemEvent.SELECTED) {
					button.setText("Expand All");
					expandTree(tree, false);
					path.setText("Food");
					selection.setText("Food");
				}else {
					button.setText("Collapse All");
					expandTree(tree, true);
				}
					
			}//end itemStateChanged
			
		};//end ItemListener
		
		
		
		selection = new JLabel("No Selection");
		path = new JLabel("");
		
		tree.getSelectionModel().addTreeSelectionListener((TreeSelectionListener) new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				
				String pathToNode = "";
				
				if(toggle == false) {
					DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					selection.setText("Selection is: " + selected.getUserObject().toString());
					
					TreePath tp = e.getNewLeadSelectionPath(); 
					Object[] myPath = tp.getPath();
	
					for(int i=0; i < myPath.length; i++) {
						
						if(i == myPath.length-1) {
							pathToNode += myPath[i].toString();
						}else {
							pathToNode += myPath[i].toString() + " -> ";
						}
						
					}//end for loop
					
	
					path.setText(pathToNode);
				}
				
			}//end valuechanged
			
			
		});

		
		button.addItemListener(itemListener);
		
		temp.add(selection);
		temp.add(path);
		
		panel.add(button, BorderLayout.SOUTH);
		panel.add(temp, BorderLayout.NORTH);
		
		frm.add(top, BorderLayout.NORTH);
		frm.add(tree, BorderLayout.CENTER);
//		frm.add(path, BorderLayout.EAST);
//		frm.add(selection, BorderLayout.WEST);
		frm.add(panel, BorderLayout.SOUTH);
		
		frm.setVisible(true);
		
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
	}//end DriverGui constructor
	
	
	private void expandTree(JTree tree, boolean expand) {
		toggle = true;
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        expandAll(tree, new TreePath(root), expand);
        toggle = false;
    }
	
	
	//pulled straight from the internet
	//no edit whatsoever
	private void expandAll(JTree tree, TreePath path, boolean expand) {
        TreeNode node = (TreeNode) path.getLastPathComponent();

        if (node.getChildCount() >= 0) {
            Enumeration<? extends TreeNode> enumeration = node.children();
            while (enumeration.hasMoreElements()) {
                TreeNode n = (TreeNode) enumeration.nextElement();
                TreePath p = path.pathByAddingChild(n);

                expandAll(tree, p, expand);
            }
        }

        if (expand) {
            tree.expandPath(path);
        } else {
            tree.collapsePath(path);
        }
        
    }//end expandall
	
	
	
	
	
}//end DriverGui