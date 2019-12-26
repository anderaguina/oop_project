package project;
import java.util.*;

public class HelperFunctions {
	static final int NUM_ROOMS = 26;
	
	public void availableRooms(Room[] rooms) {		
		for (int i=0; i<NUM_ROOMS; i++) {
			if (rooms[i].isFree()) {
				System.out.println("Room "+rooms[i].getRoomNumber()+" free");
			}
		}
	}
	
	public ArrayList<Room> notAvailableRooms(Room[] rooms) {
		ArrayList<Room> notAvailable = new ArrayList<Room>();
		
		int indexTotal = 0, indexNotAvailable = 0;
		
		for (int i=0; i<NUM_ROOMS; i++) {
			if (!rooms[i].isFree()) {
				notAvailable.add(rooms[i]);
			}
		}
		return notAvailable;
	}
	
	public void getGuests(Room[] rooms) {
		
		for (int i=0; i<NUM_ROOMS; i++) {
			if (!rooms[i].isFree()) {
				System.out.println("Guest in room "+i+" is "+rooms[i].getBooker());
			}
		}
	}
	
	public void calculatePrice(double rate, int numGuests, String type) {
		double price = rate * numGuests;
		if (type == "lecturer") {			
			price = price*0.9;
		} 
		System.out.println("Price is = " + price);
	}
	
}
