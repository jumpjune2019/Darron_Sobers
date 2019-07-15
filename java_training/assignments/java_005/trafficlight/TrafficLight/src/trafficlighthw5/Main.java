package trafficlighthw5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// created a new br object which is a inputstream reader wrapped in a buffered reader
		// when used it will await user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// created a new instance of my thread
		TrafficThread tt = new TrafficThread();
		// empty string variable was created to accept user input in try statement
		String str;
		System.out.println("Traffic Light Simulator is a Go!\n\n");
		// executes the run method in my TrafficThread class
		tt.start();
		try {
			// assigns user input to variable str
			str = br.readLine();
			// if the user pressed the enter key the thread gets terminated
			while(str.equals("")) {
				System.out.println("\n\nTraffic Light Simulator is Done!");
				// calling the method that terminates the running thread
				tt.killTraffic();
				break;
			}
		} catch(Exception e) {
			System.out.println(e);
		}// End of catch
	}// End of Main
}// End of class
