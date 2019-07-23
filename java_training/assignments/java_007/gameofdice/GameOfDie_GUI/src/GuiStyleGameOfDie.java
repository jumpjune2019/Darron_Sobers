import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiStyleGameOfDie implements ActionListener{
	String[][] matrix = {{"Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one your're done"},
			{"Ace caught a deuce", "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"}, {"Easy four", "OJ", "Brooklyn Forest", "Big Red",
	"Eighter from Decatur", "Nina from Pasadena"},{ "Little Phoebe", "Easy six", "Skinny Mckinney", "Square pair", "Railroad nine", "Big one on the end"},
			{"Sixie from Dixie", "Skinny Dugan", "Easy eight", "Jesse James", "Puppy paws", "Yo"}, {"The Devil", "Easy eight", "Lou Brown", "Tennessee", "Six five no jive",
	"Midnight"}};
	
	JFrame dieRoller;
	JLabel results;
	JLabel dieResults;
	JButton rollBtn;
	JButton resetBtn;
	int die1, die2;
	
	RefactorGame ready2Roll = () -> {
		int side = (int) (Math.random()*5) + 1;
		return side;
	};

	GuiStyleGameOfDie() {
		// create a new JFrame container
		// as well as the title of the JFrame
		dieRoller = new JFrame("Game Of Die");
		
		dieRoller.setLayout(new FlowLayout());
		// sets the dimensions of JFrame window
		dieRoller.setSize(300, 200);
		// Terminates program on closing of window
		dieRoller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// created a label for result of coin flip
		// that initially says waiting
		results = new JLabel("waiting...");
		dieResults = new JLabel("");
		
		// created a button to simulate the dice roll
		rollBtn = new JButton("Try your luck!");
		resetBtn = new JButton("Reset");
		
		// allows the buttons to cause something to happen
		// based on what the actionPerformed method defines
		// for each button
		rollBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		
		// adding components to JFrame
		dieRoller.add(rollBtn);
		dieRoller.add(results);
		dieRoller.add(dieResults);
		dieRoller.add(resetBtn);
		dieRoller.setVisible(true);
	}

	
	
	// Handle button events.
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		switch(action) {
		case "Reset":
			results.setText("waiting...");
			dieResults.setText("");
			break;
		case "Try your luck!" : {
			die1 = ready2Roll.rolling();
			die2 = ready2Roll.rolling();
			results.setText("You rolled a " + die1 + " and a " + die2);
			dieResults.setText("Also know as " + matrix[die1][die2]);
			break;
		}
		}
	}
	
	public static void main(String[] args) {
		// spawns the JFrame on the event dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GuiStyleGameOfDie();
			}
		}); 
	}
}
