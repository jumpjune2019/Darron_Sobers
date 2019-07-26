import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
public class GridLayoutDemo  implements ActionListener {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   public GridLayoutDemo(){
      prepareGUI();
   }
   
   private void prepareGUI(){
      mainFrame = new JFrame("Grid Layout Example");
      mainFrame.setSize(400,250);
      mainFrame.setLayout(new GridLayout(3, 1));
      headerLabel = new JLabel("",JLabel.CENTER ); 
      
      // old school way to close a window
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
             // this is the way to force a java application to gracefully exit
             // when not going to end via the main method entry point
             System.exit(0);
         }        
      });
      // ^^^^^*******************^^^^^^^^^^^^^^^^^^^^
      // New school way to close a window
      // mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // ^^^^^*******************^^^^^^^^^^^^^^^^^^^^
      
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);  
   }
   
   private void showGridLayoutDemo() throws NullPointerException {
      headerLabel.setText("Push Button");  
      JPanel panel = new JPanel();
      panel.setSize(300,300);
      GridLayout layout = new GridLayout(2,3);
      layout.setHgap(10);
      layout.setVgap(10);
      panel.setLayout(layout);
      int length = 6;
      JButton[] buttons = new JButton[length];
      int x;
      String prefixLabel = "Button ";
      for (x = 0; x < length; x++) {
          // upon each iteration the buttons labels created are incremented by one
          buttons[x] = new JButton(prefixLabel.concat(Integer.toString(x + 1)));
          buttons[x].addActionListener(this);
          panel.add(buttons[x]);
      }
      
      controlPanel.add(panel);
      mainFrame.setVisible(true);  
   }
 
   public void actionPerformed(ActionEvent ae) {
//       statusLabel.setText(ae.getActionCommand());
   }
   
   public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GridLayoutDemo gridLayoutDemo = new GridLayoutDemo();  
                gridLayoutDemo.showGridLayoutDemo();
            }
        });      
   }
}