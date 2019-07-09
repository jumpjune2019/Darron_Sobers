package phone;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Phone {

	public static void main(String[] args) {
		
		// creates a 2d array named phoneApp the has 6 rows and 3 columns
		String[][] phoneApp = new String[6][3];
		// assigning the value of the first row in the array
		phoneApp[0][0] = "Name";
		phoneApp[0][1] = "Phone Number";
		phoneApp[0][2] = "City";
		String reEnter = null;
		boolean wait = true;
		
		for(int row = 1; row < phoneApp.length; row++) {
			int check = 0;
			for(int col = 0; col < phoneApp[0].length; col++) {
				// a new scanner object is created every iteration
				Scanner sc = new Scanner(System.in);
				// increments check by 1 each iteration
				check++;
				
				// depending on the value of check a prompt is selected
				switch(check) {
				case 1:
					System.out.println("print name");
					break;
				case 2:
					System.out.println("print phone number");
					break;
				case 3:
					System.out.println("print city");
					break;
				}
				// try checks the users input
				try {
				phoneApp[row][col] = sc.nextLine();
				
				// if the users input is empty the custom exception is thrown
				if (phoneApp[row][col].isEmpty()) {
					// custom exception
					throw new NullValueInMatrixException();
					// if user input is not null it will be printed out
				}	else {
					System.out.println("User has entered " + phoneApp[row][col]);
				}
				
				// 
				while(wait) {
					
					System.out.println("do you accept this input? type y if yes and n if no to re-enter it");
					reEnter = sc.next();
					
					if(reEnter.charAt(0) == 'y') {
						wait = false;
					} else if(reEnter.charAt(0) == 'n') {
						System.out.println("Please re-enter your data");
						phoneApp[row][col] = sc.next();
					}
				}
			} catch(NullValueInMatrixException e) {
				System.out.println(e);
				col--;
				check--;
			}
		}
			check = 0;
		}
		
		printGraph(phoneApp);
		
	}
	
	public static void printGraph(String[][] phoneApp) {
		try(FileWriter fw = new FileWriter("PhoneAppData.txt")) {
			for (int i = 0; i < phoneApp.length; i++) {
				for(int j = 0; j < phoneApp[0].length; j++) {
					fw.append(String.format("%-20s", phoneApp[i][j]));
					System.out.format("%-20s", phoneApp[i][j]);
					
				}
				System.out.println();
				fw.append("\r\n");
			}			
		} catch(IOException e) {
			System.out.print(e);
		}
		
	}

}
