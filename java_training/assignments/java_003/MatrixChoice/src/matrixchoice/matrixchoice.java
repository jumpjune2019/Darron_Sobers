package matrixchoice;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

public class matrixchoice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		// initialized a 2 dimensional String array 
		String[][] matrix = {{"", "Die 1", "Die 2", "Die 3", "Die 4", "Die 5", "Die 6"},
				{"Die 1", "Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one your're done"},
				{"Die 2", "Ace caught a deuce", "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"}, 
				{"Die 3", "Easy four", "OJ", "Brooklyn Forest", "Big Red", "Eighter from Decatur", "Nina from Pasadena"},
				{ "Die 4", "Little Phoebe", "Easy six", "Skinny Mckinney", "Square pair", "Railroad nine", "Big one on the end"},
				{"Die 5", "Sixie from Dixie", "Skinny Dugan", "Easy eight", "Jesse James", "Puppy paws", "Yo"},
				{"Die 6", "The Devil", "Easy eight", "Lou Brown", "Tennessee", "Six five no jive", "Midnight"}};
		
		
		System.out.println("Type the number of how you want the matrix printed\n\n"
				+ "	1) print on screen only\n" + 
				"	2) print on file\n" + 
				"	3) print on both");
		
		choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			for(String[] row : matrix) {
				for(String elem : row ) {
					System.out.format("%-24s", elem);
				}
				System.out.println();
			}
			break;
		case 2:
			try { 
				File newFile = new File("matrixFile.txt");
				  
				  if(!newFile.exists()) {
					  newFile.createNewFile();
				  }
				  
				  PrintWriter pw = new PrintWriter(newFile);
				  

				  for(String[] row : matrix) {
						for(String elem : row ) {
							pw.format("%-25s", elem);
						}
						pw.println();
					}
					
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
				  

				  for(String[] row : matrix) {
						for(String elem : row ) {
							pw.format("%-25s", elem);
						}
						pw.println();
					}
					
					pw.println();
					pw.close();
				
			} catch (IOException exc) {
				System.out.println("I/O Error: " + exc);
			}
			
			for(String[] row : matrix) {
				for(String elem : row ) {
					System.out.format("%-24s", elem);
				}
				System.out.println();
			}
			
			break;
		}// End of switch
	}// End of main
}// End of class