// a client object

public class Client {
	private String lastname;
	private String firstname;
	private int id;
	private String seatAssignment;
	private int clientRow;
	private int clientCol;
	
	Client(String l, String f, int i) {
		lastname = l;
		firstname = f;
		id = i;
		seatAssignment = null;
	}
	
	public int getClientRow() {
		return clientRow;
	}

	public void setClientRow(int clientRow) {
		this.clientRow = clientRow;
	}

	public int getClientCol() {
		return clientCol;
	}

	public void setClientCol(int clientCol) {
		this.clientCol = clientCol;
	}

	void setSeatAssignment(String sa) {
		this.seatAssignment = sa;
	}
	String getSeatAssignment() {
		return seatAssignment;
	}
	
	int getClientId() {
		return id;
	}
	
	String getClientLastName() {
		return lastname;
	}
	
	String getClientFirstName() {
		return firstname;
	}
	
	String getClientInitials() {
		char[] initialsArr = {' ', ' '};
		initialsArr[0] = firstname.charAt(0);
		initialsArr[1] = lastname.charAt(0); 
		return new String(initialsArr);
	}

	String getFullClientString() {
		String full = ("id: " + id + " lastname: " + lastname + " firstname: " + firstname + " Seat: " + seatAssignment);
		return full;
	}
	
	String getFullClientIdAndInitials() {
		String clientInfo = ("id: " + id + "/" + getClientInitials());
		return clientInfo;
	}
	
}
