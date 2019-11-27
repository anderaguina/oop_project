package project;

import java.util.*;

public class MainHotel {
	public static void main(String args[]) {
		 Scanner keyboard = new Scanner(System.in);
		 
		 // Menu object
		 Menu menu = new Menu();
		 
		 // Helper functions object
		 HelperFunctions helper = new HelperFunctions();
		 
		 // ROOMS
		 
		 Room[] roomList = new Room[26];
		 for (int i = 0; i<26; i++) {
			 Room room1 = new Room(i, 2.2, true, 5, 5, "a");
			 roomList[i] = room1; 
		 }
		 
		 // User option choice
		 int option;
		 
		 // Main menu
		 menu.mainMenu();
		 option = keyboard.nextInt();
		 // Clean scanner from \n
		 keyboard.nextLine();
		 
		 //Redirect from main menu to option menus
		 switch (option) {
			 case 1:
				 menu.reservationsMenu();
				 break;
			 case 2:
				 helper.getGuests(roomList);
				 break;
			 case 3:
				 helper.availableRooms(roomList);
				 break;
		 }
	}
}
