package project;

import java.io.IOException;
import java.util.*;

public class MainHotel {
	public static void main(String args[]) throws IOException {
		 Scanner keyboard = new Scanner(System.in);
		 
		 // Menu object
		 Menu menu = new Menu();
		 
		 // Helper functions object
		 HelperFunctions helper = new HelperFunctions();
		 
		 // Empty guest object
		 Guest emptyGuest = new Guest();
		 
		 // ROOMS		 
		 Room[] roomList = new Room[26];
		 
		 // Suits
		 int s;
		 for (s = 0; s<6; s++) {
			 Room room = new Room(s, 150, true, 0, 3, emptyGuest);
			 roomList[s] = room; 
		 }
		 
		 // Doubles
		 int d;
		 for (d = s; d<14; d++) {
			 Room room = new Room(d, 100, true, 0, 2, emptyGuest);
			 roomList[d] = room; 
		 }
		 
		 // Singles
		 int sin;
		 for (sin = d; sin<26; sin++) {
			 Room room = new Room(sin, 75, true, 0, 1, emptyGuest);
			 roomList[sin] = room; 
		 }
		 
		 // User option choice
		 int option;
		 
		 do {		 
			 // Main menu
			 menu.mainMenu();
			 option = keyboard.nextInt();
			 // Clean scanner from \n
			 keyboard.nextLine();
			 
			 //Redirect from main menu to option menus
			 switch (option) {
				 case 1:
					 menu.reservationsMenu(roomList);
					 break;
				 case 2:
					 helper.getGuests(roomList);
					 break;
				 case 3:
					 helper.availableRooms(roomList);
					 break;
				 case 4:
					 System.out.println(menu.processPayment(roomList));
					 break;
				 case 5:
					 helper.writeDetailsToFile(roomList);
					 System.out.println("See you soon!");
					 break;
			 }
		 } while(option != 5);
	}
}
