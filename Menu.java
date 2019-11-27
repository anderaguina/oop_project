package project;

public class Menu {
	
	// Print the main menu
	public void mainMenu() {
		System.out.println("1. Reservations");
		System.out.println("2. List guests");
		System.out.println("3. Display available rooms");
		System.out.println("4. Payments");
		System.out.println("5. Exit");
	}
	
	// Reservations options
	public void reservationsMenu() {
		System.out.println("1. New reservation");
		System.out.println("2. Add to reservation");
		System.out.println("b. Go back to main menu");
	}
	
	/*// Rooms options
	public void displayAvailableRooms() {
		HelperFunctions.availableRooms();		
	}*/
	
	
	
	public void newReservation(Room[] roomsAvailable) {
		System.out.println("ROOMS AVAILABLE");
		for (int i = 0; i<26; i++) {
			System.out.print("Room : ");
			System.out.println(roomsAvailable[i].getRoomNumber());
		}
		System.out.println("WHICH ROOM WOULD YOU LIKE TO BOOK?");	
	}
}
