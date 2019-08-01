
public class Seat {
	private String initialsOfClient;
	private int clientId;
	private boolean canBeAssigned;
	private Client occupied;
	
	// initials default values
	Seat() {
		this.initialsOfClient = null;
		this.clientId = 0;
		this.canBeAssigned = true;
		this.occupied = null;
	}
	
	Seat(String initials, int id, boolean assign, Client c) {
		this.initialsOfClient = initials;
		this.clientId = id;
		this.canBeAssigned = assign;
		this.occupied = c;
	}
	Client getClientInSeat() {
		return occupied;
	}
	void setClientInSeat(Client c) {
		this.occupied = c;
	}
	
	String getInitialsOfClient() {
		return initialsOfClient;
	}
	
	int getClientId() {
		return clientId;
	}
	
	boolean getCanBeAssigned() {
		return canBeAssigned;
	}
	
	void setCanBeAssigned(boolean assign) {
		this.canBeAssigned = assign;
	}
	
	void setInitialsOfClient(String ini) {
		this.initialsOfClient = ini;
	}
	
	void setClientId(int id) {
		this.clientId = id;
	}
	// checks if the seat can be assigned or now
	String checkIfAvailable() {
		if (canBeAssigned == true) {
			return "vacant";
		} else
			return "id:" + getClientInSeat().getClientId() + "/" + getClientInSeat().getClientInitials();
	}
}
