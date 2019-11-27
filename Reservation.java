package project;

import java.util.Scanner;

// Class for handling everything related to reservations
public class Reservation {
	// Keyboard input for reservation options
	Scanner keyboard = new Scanner(System.in);
	
	// Reservation option
	int option = 0;
	
	// Helper functions object
	HelperFunctions helper = new HelperFunctions();
	
	// Reservation main menu
	public int reservationMainMenu() {
		System.out.println("1. New reservation");
		System.out.println("2. Add to reservation");
		System.out.println("0. Go back to main menu");
		option = keyboard.nextInt();
		keyboard.nextLine();
		return option;
	}
	
	// New reservation menu
	public int newReservation(Room[] roomsAvailable) {
		// Check if there is any room available
		if (!helper.isThereAvailableRooms(roomsAvailable)) {
			System.out.println("We have no rooms availale, I'm sorry");
		} else {
			// How many guests
			int numGuests = numberOfGuest();
			
			// Check if there is big enough rooms
			if (!helper.bigEnoughRooms(roomsAvailable, numGuests)) {
				System.out.println("Sorry we have no big enough rooms available");
			} else {
				// Show rooms available
				roomsAvailable(roomsAvailable, numGuests);
				// helper.availableRooms(roomsAvailable, numGuests);
				
				// Get room to book number
				int roomNumber = roomSelected(roomsAvailable);
				
				// Ask for user details
				Guest newGuest = getGuestDetails();
				
				// Place reservation
			}
		}
		return  0;
	}
	
	// Ask how many guests
	public int numberOfGuest() {
		System.out.println("How many guests?");
		int numGuests = keyboard.nextInt();
		
		return numGuests;
	}
	
	// Show rooms available
	public void roomsAvailable(Room[] roomsAvailable, int numGuests) {
		System.out.println("ROOMS AVAILABLE");
		// TODO Show the number of max guests for that room
		for (int i = 0; i<26; i++) {
			if (roomsAvailable[i].bigEnough(numGuests) && roomsAvailable[i].isFree()) {
				System.out.print("Room : ");
				System.out.println(roomsAvailable[i].getRoomNumber());
			}
		}
	}
	
	// Select room for new reservation
	public int roomSelected(Room[] roomsAvailable) {
		int roomNumber;
		
		System.out.println("WHICH ROOM WOULD YOU LIKE TO BOOK?");	
		roomNumber = keyboard.nextInt();
		
		// Verify if the number entered is in the room list
		if (roomNumber > 26 && roomNumber < 0) {
			System.out.println("That room doesn't exist, select one that does");
			roomSelected(roomsAvailable);
		}
		// Verify if the room entered is actually free
		if (!roomsAvailable[roomNumber].isFree()) {
			System.out.println("That room is not available, select a room from the previous list");
			roomSelected(roomsAvailable);
		}
		keyboard.nextLine();
		return roomNumber;
	}
	
	// Get user details
	public Guest getGuestDetails() {
		String name;
		String email;
		String address;
		String phoneNumber;
		String type;
		
		// Get details into variables
		System.out.println("Enter guest name");
		name = keyboard.nextLine();
		System.out.println("Enter guest email");
		email = keyboard.nextLine();
		System.out.println("Enter guest address");
		address = keyboard.nextLine();
		System.out.println("Enter guest phone number");
		phoneNumber = keyboard.nextLine();
		System.out.println("Is the guest a lecturer or a student (Student/Lecturer");
		type = keyboard.nextLine();
		
		// Create guest class object using the variables filled above
		Guest newGuest = new Guest(name, email, address, phoneNumber, type);
		
		// Return guest object
		return newGuest;
	}
	
	public void placeResevation(Guest guest, Room selectedRoom) {
		// Set the guest name as the booker
		selectedRoom.setBooker(guest.getName());
		
		// Set the room status as occupied/not available/not free
		selectedRoom.toggleFree();
		
	}
}
