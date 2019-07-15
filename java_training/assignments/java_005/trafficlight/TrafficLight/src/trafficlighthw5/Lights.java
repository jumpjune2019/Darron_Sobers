package trafficlighthw5;

public enum Lights {
	// each enum takes 2 parameters for a message and a color
	GREEN("Green", "GO"), YELLOW("Yellow", "Beware"), RED("Red", "Stop");
	
	private String message;
	private String color;

	// constructor for the enum class that assigns
	// parameters to a variable
Lights(String clr, String msg) {
	color = clr;
	message = msg;
	}

// returns the color for a specific Light object
String getColor() {
	return color;
}

//returns the message for a specific Light object
String getMsg() {
	return message;
}
}// End of enum class Lights