package assignment1;

public class HeadOrTail {
	
	static int flip() {
		// randomly selects either 1 or 2 when called
		int headOrTail = (int) (Math.random()*2) + 1;
		// returns the random number
		return headOrTail;
	}// End of flip
	
	static String side(int c) {
		// if c is equal to 1 then side returns Heads
		if(c == 1) {
			return "Head";
			// if c is anything other than 1 then side returns Tail
		} else {
			return "Tail";
		}// End of else
	}// End of side

	public static void main(String[] args) {
		
		System.out.println("Coin Flip Program");
		// formatting out put with printf to modify changes upon execution
		System.out.printf("The Coin Flip is: %s", side(flip()));
		}// End of main
}// End of class
