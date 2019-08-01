import java.util.Arrays;

public class Room {
	// each room will have a matrix of seats
	private Seat[][] roomArr;
	public static int numOfRooms = 0;
	
	Room(int row, int col) {
		this.roomArr = new Seat[row][col];
		numOfRooms++;
	}

	// returns the 2D array for a instance of Room 
	Seat[][] getRoomMatrix() {
		return this.roomArr;
	}
	
	// initialize matrix
	// initializes matrix with Seat objects
	public void initializeSeatArray(Seat[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int x = 0; x < arr[i].length; x++) {
				arr[i][x] = new Seat();
			}
		}
	}
	
	// print out matrix
	public void printOutMatrix(Seat[][] array) {
		int row = 0;
		for(int i = 0; i < array.length; i++) {
			row++;
			for(int x = 0; x < array[i].length; x++) {
				if (i == 0 && x == 0) {
					for(int y = 0; y < array[i].length; y++) {
								System.out.format("%14d", (row + y));
					}					
					System.out.println();
				}
				
				if(i == i && x == 0) {
					char alpha = (char)65;
					System.out.format("%c     %-17s", (alpha + row - 1), array[i][x].checkIfAvailable());
				}else {
					System.out.format("%-14s", array[i][x].checkIfAvailable());					
				}
			}
			System.out.println();
		}
	}
	
	// randomly generate a index
	public int randomlyAssignIndex() {
		// return a number between 0 and 9
		return (int) (Math.random() * 10); 
	}
	
	// randomly assign seat
	public void randomlyAssignSeat(Seat[][] array, Client obj) {
		boolean searching = true;
		while(searching) {
			int r = randomlyAssignIndex();
			int c = randomlyAssignIndex();
			if (array[r][c].getCanBeAssigned() == true) {
				array[r][c].setCanBeAssigned(false);
				array[r][c].setClientInSeat(obj);
				array[r][c].setClientId(obj.getClientId());
				array[r][c].setInitialsOfClient(obj.getClientInitials());
				array[r][c].getClientInSeat().setSeatAssignment(ClientsSeat(r,c));
				searching = false;
			} else {
				continue;
			}// End of Else
		}// End of while
	}// End of randomlyAssignSeat

	// inserts clients into Seat Matrix from an array of clients
	public void insertClients(Client[] cArray, Seat[][] roomArray) {
		for(Client c : cArray) {
			randomlyAssignSeat(roomArray, c);
		}
	}
	
	public String ClientsSeat(int row, int col) {
		String seatRow = "";
		int column = col +1;
		String seatCol = String.valueOf(column);
		switch(row) {
		case 0:
			seatRow = "A-";
			break;
		case 1:
			seatRow = "B-";
			break;
		case 2:
			seatRow = "C-";
			break;
		case 3:
			seatRow = "D-";
		case 4:
			seatRow = "E-";
		case 5:
			seatRow = "F-";
		case 6:
			seatRow = "G-";
		case 7:
			seatRow = "H-";
		case 8:
			seatRow = "I-";
		case 9:
			seatRow = "J-";
		}
		return seatRow + seatCol;
	}
}// End of Room class
