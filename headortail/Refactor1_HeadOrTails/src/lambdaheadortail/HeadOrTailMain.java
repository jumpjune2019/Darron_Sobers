package lambdaheadortail;

import java.util.Scanner;

// created a heads or tails flip a coin game simulation
// using lambda expressions
public class HeadOrTailMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean keepOn = true;
		// lambda expression in a block of code
		Flipper pickSide = () -> {
			int side = (int) (Math.random()*2) + 1;
			return side;
		};
		
		// lambda expression in a block of code
		HeadOrTails select = (p) -> {
			if(p == 1) {
				return "Head";
			} else {
				return "Tail";
			}
		};
		
		System.out.println("Welcome to the game of Head or Tails where you will flip your life away!");
		System.out.println("Press the F key and flip our luck");

		String go;
		while(keepOn) {
			go = sc.nextLine();
			if(go.equalsIgnoreCase("F")) {
				System.out.printf("\nThe coin flip is: %s!", select.coinSide(pickSide.flipCoin()));
			}
			System.out.println("\nPress the F key to try again, press Q or q to quit");
			go = sc.nextLine();
			if(go.equalsIgnoreCase("F")) {
				System.out.printf("\nThe coin flip is: %s!", select.coinSide(pickSide.flipCoin()));
				System.out.println("\nPress the F key to try again, press Q or q to quit");
			} else if(go.equalsIgnoreCase("q") || go.equalsIgnoreCase("Q")) {
				System.out.println("Thank you for playing");
				keepOn = false;
			}
		}// End of while
		sc.close();
		}// End of main
}// End of class
