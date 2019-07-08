package assignment6;

public class LabellingPairOfDices {

	public static void main(String[] args) {
		// initialized an integer variable named d to 0
		int d = 0;
		// initialized a 2 dimensional String array 
		String[][] matrix = {{"Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one your're done"},
				{"Ace caught a deuce", "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"}, {"Easy four", "OJ", "Brooklyn Forest", "Big Red",
		"Eighter from Decatur", "Nina from Pasadena"},{ "Little Phoebe", "Easy six", "Skinny Mckinney", "Square pair", "Railroad nine", "Big one on the end"},
				{"Sixie from Dixie", "Skinny Dugan", "Easy eight", "Jesse James", "Puppy paws", "Yo"}, {"The Devil", "Easy eight", "Lou Brown", "Tennessee", "Six five no jive",
		"Midnight"}};
		
		// outer for loop traverses the rows of the 2d array
		for(int x = 0; x <matrix.length; x++) {
			if(x == 0) {
				System.out.println("        Die 1             Die 2                Die 3                         Die 4                Die 5           Die 6\n");
			}
			// inner for loop traverses the columns of the 2d array
			for(int y = 0; y <matrix[0].length; y++) {
				// in he first column the die side will be printed
				if(y == 0) {
					d++;
					System.out.printf("Die %d ", d);
				}
				// prints the value at the 2d array index
				System.out.print("  " + matrix[x][y] + "      ");
				}// End of inner for loop
			// escapes to times to create space in graph display
			System.out.print("\n\n");
		}// End of outer for loop
	}// End of main
}// End of class
