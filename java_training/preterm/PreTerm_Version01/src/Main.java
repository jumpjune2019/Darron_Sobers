
public class Main {

	public static void startApp() {
		System.out.println("startApp()");
//		System.out.println("- This is where I can setup very basic stuff, at least an app intro");
		System.out.println("- Welcome to AMC Seat Arrange");
	}
	
	public static void getInput() {
		System.out.println("getInput()");
		System.out.println("- get my clients");
		System.out.println("- get a room matrix");
	}

	public static void processData() {
		System.out.println("processData()");
		System.out.println("- associate clients with room matrix");
	}

	public static void showOutput() {
		System.out.println("showOutput()");
		System.out.println("- display matrix");
		System.out.println("- display list of clients with seat assignment");
	}
	
	public static void endApp() {
		System.out.println("endApp()");
		System.out.println("- display an ending message	");
	}
	
	public static void main(String[] args) {
		startApp();
		getInput();
		processData();
		showOutput();
		endApp();
	}

}
