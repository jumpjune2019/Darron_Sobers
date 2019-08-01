import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Loading Clients from CSV file");
		ClientStore myStoreTest = new ClientStore("clients_list.csv");
		Client[] store = myStoreTest.getClientStore();
		// prints a list of clients and their seating assignments
		myStoreTest.printClientList(store);
		// creates a room object and sets the dimensions of the room
		Room room1 = new Room(10,10);
		// initializes the room with empty seat objects
		room1.initializeSeatArray(room1.getRoomMatrix());
		System.out.println("\n******************** Empty Room ********************\n");
		// prints out a matrix of empty seats
		room1.printOutMatrix(room1.getRoomMatrix());
		//******************** Test 1 ******************** 
		// initialization check
		// sets the seat object at index 1, 2 to 9
		// room1.getRoomMatrix()[1][2].setClientId(9);
		// prints out the id of the seat object at 1,2 
		// System.out.println(room1.getRoomMatrix()[1][2].getClientId());
		//******************** Test 1 ******************** 
		
		//******************** Test 2 ******************** 
		// Client testClient = new Client("Gauthier", "Claude", 2);
		// room1.randomlyAssignSeat(room1.getRoomMatrix(), testClient);
		// System.out.println("\n\nAfter Random Seat Assignment");
		// room1.printOutMatrix(room1.getRoomMatrix());
		//******************** Test 2 ******************** 
		//*******Finally storing Clients into matrix*******//
		System.out.println("\n- Seating Clients\n");
		room1.insertClients(store, room1.getRoomMatrix());
		System.out.println("\n******************** Filled Room ********************\n");
		room1.printOutMatrix(room1.getRoomMatrix());
		// prints a list of clients and their seating assignments
		myStoreTest.printClientList(store);
	}// End of main
}// End of class
