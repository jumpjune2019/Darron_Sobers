package assignment7;
import java.util.Scanner;

public class GameOfDice {

	public static void main(String[] args) {
		String[][] matrix = {{"Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one your're done"},
				{"Ace caught a deuce", "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"}, {"Easy four", "OJ", "Brooklyn Forest", "Big Red",
		"Eighter from Decatur", "Nina from Pasadena"},{ "Little Phoebe", "Easy six", "Skinny Mckinney", "Square pair", "Railroad nine", "Big one on the end"},
				{"Sixie from Dixie", "Skinny Dugan", "Easy eight", "Jesse James", "Puppy paws", "Yo"}, {"The Devil", "Easy eight", "Lou Brown", "Tennessee", "Six five no jive",
		"Midnight"}};
		// created a Scanner object to be able to accept input
		Scanner sc = new Scanner(System.in);
		// created a boolean variable and set it equal to true
		boolean play = true;
		// created a null String variable named quit
		String quit = null;
		// created a null String variable named playAgain
		String playAgain = null;
		// created a null integer variable named die1 and die2
		int die1 = 0;
		int die2 = 0;
		int cDie1 = 0;
		int cDie2 = 0;
		int sumMe = 0;
		int sumC = 0;
		
		// created a block lambda expression to return a random number between 1 and 5
		RefactorGame ready2Roll = () -> {
			int side = (int) (Math.random()*5) + 1;
			return side;
		};
		int playTimes = 0;
		System.out.println("Welcome to the dice throw challenge!\nDo you feel lucky? \"Punk\"... Do ya?");
		System.out.println("Press any key and ENTER to throw your dice or press (Q or q) to chicken your butt off…");
		// while play is true the loop will continue iteration
		while(play) {
			if(playTimes == 0) {
			// quit is assigned to the users input
			quit = sc.next();
			// change the string value to all uppercase
			quit.toUpperCase();
			// the if statement checks if the first character is a capital 'Q' or the string assigned to
			// the word "quit"
			
			}
			if(quit.charAt(0) == 'Q'|| quit.charAt(0) == 'q') {
				if(playTimes == 0) {
					System.out.println("See ya later alligator!");
				} else if (playTimes == 1) {
					System.out.println("Thanks for being a sport! laters!");
				}
				// assigns play the value of false to end loop
				play = false;
			} else {
				System.out.println("Rolling the dice!!");
				playTimes++;
				// assigns each die the the result of the lambda expression
				die1 = ready2Roll.rolling();
				die2 = ready2Roll.rolling();
				cDie1 = ready2Roll.rolling();
				cDie2 = ready2Roll.rolling();
				// prints the random number selected to the console in a statement
				System.out.printf("You have rolled a %d and %d > the " + matrix[die1][die2] + "\n", die1,die2);
				System.out.printf("I have rolled a %d and %d > the " + matrix[cDie1][cDie2] + "\n", cDie1,cDie2);
				// sum of users dice
				sumMe= die1 + die2;
				// sum of computers dice
				sumC = cDie1 + cDie2;
				// when users roll is greater than the computers roll
				if(sumMe > sumC) {
					System.out.println("You Win!!!");
					System.out.println("Did you cheat?? Gimme another try, c’mon Press any key and ENTER to throw you dice or press (Q or q) to quit");
				// when users roll and the computers roll are equal but users dice are the same
				} else if (sumMe == sumC && die1 == die2) {
					System.out.println("Damn! You win on a Double! What Luck");
					System.out.println("Did you cheat?? Gimme another try, c’mon Press any key and ENTER to throw you dice or press (Q or q) to quit");
				// when users roll and the computers roll are equal but computers dice are the same
				} else if (sumMe == sumC && cDie1 == cDie2) {
					System.out.println("Damn! I win on a Double! I pity you fool!");
					System.out.println("Wanna try again? Press any key and ENTER to throw your dice or press (Q or q) to quit");
				// when users roll and the computers roll are the same
				} else if (sumMe == sumC) {
					System.out.println("Stalemate! You're tough, let's try for a tie-breaker Press any key and ENTER to throw you dice or press (Q or q) to quit");
				// when the computers sum is greater than users sum
				} else if (sumMe < sumC) {
					System.out.println("I win!!!");
					System.out.println("Wanna try again? Press any key and ENTER to throw your dice or press (Q or q) to quit");
				}
				// assigns playAgain to the user input
				playAgain = sc.next();
				// the if statement checks if the first character is a capital or lowercase 'y'
				if(playAgain.charAt(0) == 'Q' || playAgain.charAt(0) == 'q') {
					// assigns play the value of false to end loop
					play = false;
				} else {
					// assigns play the value of false to end loop
					play = true;
				}// End of else
			}// End of else
		}// End of while

	}

}
