package matrixcustomhandler;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

public class MatrixCustomHandler {
	
	
	public static void printGraph() throws MatrixOutOfBoundException{
		try {
			for (int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[0].length; j++) {
					System.out.format("%-24s", matrix[i][j]);
				}
				System.out.println();
			}
		} catch(IndexOutOfBoundsException e) {
				throw new MatrixOutOfBoundException("Error when referring to matrix index");
			}
	}

	// initialized a 2 dimensional String array 
	static String[][] matrix = {{"", "Die 1", "Die 2", "Die 3", "Die 4", "Die 5", "Die 6"},
			{"Die 1", "Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one your're done"},
			{"Die 2", "Ace caught a deuce", "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"}, 
			{"Die 3", "Easy four", "OJ", "Brooklyn Forest", "Big Red", "Eighter from Decatur", "Nina from Pasadena"},
			{ "Die 4", "Little Phoebe", "Easy six", "Skinny Mckinney", "Square pair", "Railroad nine", "Big one on the end"},
			{"Die 5", "Sixie from Dixie", "Skinny Dugan", "Easy eight", "Jesse James", "Puppy paws", "Yo"},
			{"Die 6", "The Devil", "Easy eight", "Lou Brown", "Tennessee", "Six five no jive", "Midnight"}};
	public static void main(String[] args) throws MatrixOutOfBoundException {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		System.out.println("Type the number of how you want the matrix printed\n\n"
				+ "	1) print on screen only\n" + 
				"	2) print on file\n" + 
				"	3) print on both");
		
		choice = sc.nextInt();
		try {
		if(choice == 1 || choice == 2 || choice == 3) {
		} else {
			throw new WrongKeySelectedException(choice);			
		}
		
		switch(choice) {
		case 1:
				printGraph();				
			break;
		case 2:
			try { 
				File newFile = new File("matrixFile.txt");
				  
				  if(!newFile.exists()) {
					  newFile.createNewFile();
				  }
				  
				  PrintWriter pw = new PrintWriter(newFile);
				  
				  printGraph();
					
					pw.println();
					pw.close();
				
			} catch (IOException exc) {
				System.out.println("I/O Error: " + exc);
			}
			break;
		case 3:
			try { 
				File newFile = new File("matrixBoth.txt");
				  
				  if(!newFile.exists()) {
					  newFile.createNewFile();
				  }
				  
				  PrintWriter pw = new PrintWriter(newFile);

				  printGraph();
					
					pw.println();
					pw.close();
				
			} catch (IOException exc) {
				System.out.println("I/O Error: " + exc);
			}
			printGraph();
			
			break;
		}// End of switch
		} catch(WrongKeySelectedException e) {
			System.out.println(e);
		}
	}// End of main
}// End of class
