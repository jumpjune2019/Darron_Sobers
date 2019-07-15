package trafficlighthw5;

public class TrafficThread extends Thread{
	
	// allows the while loop to continue iterations
	boolean keepOn = true;
	
	// executes a while loop until the killTraffic method is used in the main method
	public void run() {
		try {
			while(keepOn) {
				// now the constant GREEN can be used as an object
				Lights g = Lights.GREEN;
				
				System.out.printf("The light is %s - %s!\n", g.getColor(), g.getMsg());
				sleep(5000);
				
				// now the constant YELLOW can be used as an object
				Lights y = Lights.YELLOW;
				
				System.out.printf("The light is %s - %s!\n", y.getColor(), y.getMsg());
				sleep(2000);
				
				// now the constant RED can be used as an object
				Lights r = Lights.RED;
				
				System.out.printf("The light is %s - %s!\n", r.getColor(), r.getMsg());
				sleep(3000);
				
				
			}// End of while
		} catch(Exception e) {
			System.out.println(e);
		}// End of catch
	}// End of run
	
	// kills the thread execution
	public void killTraffic() {
		keepOn = false;
	}
}// End of class
