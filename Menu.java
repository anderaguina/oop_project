package project;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

public class Menu {
	
	Scanner keyboard = new Scanner(System.in);
	
	// Helper functions object
	HelperFunctions helper = new HelperFunctions();
	
	// Print the main menu
	public void mainMenu() {
		System.out.println("1. Reservations");
		System.out.println("2. List guests");
		System.out.println("3. Display available rooms");
		System.out.println("4. Payments");
		System.out.println("5. Exit");
	}
	
	// Reservations options
	public void reservationsMenu(Room[] rooms) {
		System.out.println("1. New reservations");
		System.out.println("2. View reservation");
		System.out.println("3. Cancel reservation");
		System.out.println("4. Return");
		
		int option = keyboard.nextInt();
		keyboard.nextLine();
		
		switch(option) {
			case 1:
				newReservation(rooms);
				break;
			case 2:
				displayReservations(rooms);
				break;
			case 3:
				cancelReservation(rooms);
				break;
			case 4:
				break;
		}
		
	}
	
	public void displayReservations(Room[] rooms) {
		ArrayList<Room> notAvailable = helper.notAvailableRooms(rooms);
		
		for (int i=0; i<notAvailable.size(); i++) {
			System.out.println("Reserve code: " + i);
			System.out.println("Name of the booker: "+ notAvailable.get(i).getBooker());
			System.out.println("Number of guests in room: " + notAvailable.get(i).getCurrentGuests());
		}
	}
	
	public void cancelReservation(Room[] rooms) {
		
		for (int i = 0; i<rooms.length;i++) {
			if (!rooms[i].isFree()) {
				System.out.println("Room : " + i);
				System.out.println("Booker: "+  rooms[i].getBooker());
			}
		}
		
		System.out.println("WHICH RESERVATION WOULD YOU LIKE TO CANCEL");
		int option = keyboard.nextInt();
		keyboard.nextLine();
		
		
	}
	
	// Rooms options
	public void displayAvailableRooms(Room[] rooms) {
		helper.availableRooms(rooms);		
	}	
	
	public Room[] newReservation(Room[] rooms) {
		int numGuests;
		
		System.out.println("How many people?");
		numGuests = keyboard.nextInt();
		keyboard.nextLine();
		
		System.out.println("ROOMS AVAILABLE");
		boolean freeRooms = false;
		for (int i = 0; i<26; i++) {
			if (rooms[i].isFree() && rooms[i].bigEnough(numGuests)) {
				System.out.print("Room : ");
				System.out.println(rooms[i].getRoomNumber());
				freeRooms = true;
			}
		}
		if (freeRooms) {

			System.out.println("WHICH ROOM WOULD YOU LIKE TO BOOK?");
			int position;
			do {
				position = keyboard.nextInt();
				keyboard.nextLine();
			} while (!rooms[position].isFree());
			
			Room room = rooms[position];
				
			Guest guest = guestReservationDetails();
			
			rooms[position].setBooker(guest.getName());
			rooms[position].book();
			rooms[position].setCurrentGuests(numGuests);
			
			helper.calculatePrice(room.getRatePerPerson(), numGuests, guest.getType());
			
			return rooms;
		} else {
			System.out.println("There is no rooms available");
			return rooms;
		}
	}
	
	public Guest guestReservationDetails() {
		Guest guest = new Guest();
		
		System.out.println("Guest name: ");
		String name = keyboard.nextLine();
		
		System.out.println("Is lecturer?");
		String isLecturer = keyboard.nextLine();
		
		guest.setName(name);
		guest.setType("lecturer");
		
		return guest;
	}
}
