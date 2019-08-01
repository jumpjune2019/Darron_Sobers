
public class Seat {
	private String initialsOfClient;
	private int clientId;
	private boolean canBeAssigned;
	private Client occupied;
	private int myRowX = 0;
	private int mySeatY = 0;
	
	// initials default values
	Seat(int x, int y) {
		this.initialsOfClient = null;
		this.clientId = 0;
		this.canBeAssigned = true;
		this.occupied = null;
		this.myRowX = x;
		this.mySeatY = y;
	}
	
	Seat(Client occupie) {
		this.initialsOfClient = null;
		this.clientId = 0;
		this.canBeAssigned = true;
		this.occupied = occupie;
		this.myRowX = 0;
		this.mySeatY = 0;
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
	
	public Client getOccupied() {
		return occupied;
	}

	public void setOccupied(Client occupied) {
		this.occupied = occupied;
	}

	public int getMySeatX() {
		return myRowX;
	}

	public void setMySeatX(int myRowX) {
		this.myRowX = myRowX;
	}

	public int getMySeatY() {
		return mySeatY;
	}

	public void setMySeatY(int mySeatY) {
		this.mySeatY = mySeatY;
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

	@Override
	public String toString() {
		return "Seat [initialsOfClient=" + initialsOfClient + ", clientId=" + clientId + ", canBeAssigned="
				+ canBeAssigned + ", occupied=" + occupied + ", myRowX=" + myRowX + ", mySeatY=" + mySeatY + "]";
	}
	
}

