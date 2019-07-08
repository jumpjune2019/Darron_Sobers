package assignment2;

public class KeepingStats {
	
	static int flip() {
		// randomly selects either 1 or 2 when called
		int headOrTail = (int) (Math.random()*2) + 1;
		// returns the random number
		return headOrTail;
	}// End of flip
	
	public static void main(String[] args) {
		int[] tally = {0, 0};
		// countH is the assigned to the first index of array tally
		int countH = tally[0];
		// countT is the assigned to the second index of array tally
		int countT = tally[1];
		// i is declared outside of the scope of the forloop so it can 
		// be used later in the program
		int i;
		
		for(i = 0; i < 1000; i++) {
			// when the flip method returns 1 countH is incremented by 1
			if (flip() == 1) {
				countH++;
				// when the flip method returns anything other than 1
				// countT is incremented by 1
			} else {
				countT++;
			}// End of else
		}// End of for
		
		// %d allows you to use an integer in the print statement
		// \n creates a new line
		System.out.printf("%d Coin Flips\n", i);
		System.out.printf("Count of Head: %d\n", countH);
		System.out.printf("Count of Tail: %d", countT);
		
	}// End of main
}// End of class
