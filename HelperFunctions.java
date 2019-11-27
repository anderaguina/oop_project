package project;

public class HelperFunctions {
	static final int NUM_ROOMS = 26;
	
	public void availableRooms(Room[] rooms) {
		
		for (int i=0; i<NUM_ROOMS; i++) {
			if (rooms[i].isFree()) {
				System.out.println("Room "+rooms[i].getRoomNumber()+" free");
			}
		}
	}
	
	// Get if there is available rooms
	public boolean isThereAvailableRooms(Room[] rooms) {
		for (int i=0; i<NUM_ROOMS; i++) {
			if (rooms[i].isFree()) {
				return true;
			}
		}
		return false;
	}
	
	// Get if there is available rooms
	public boolean bigEnoughRooms(Room[] rooms, int numGuests) {
		for (int i=0; i<NUM_ROOMS; i++) {
			if (rooms[i].bigEnough(numGuests)) {
				return true;
			}
		}
		return false;
	}
	
	public void getGuests(Room[] rooms) {
		
		for (int i=0; i<NUM_ROOMS; i++) {
			if (!rooms[i].isFree()) {
				System.out.println("Guest in room "+i+" is "+rooms[i].getBooker());
			}
		}
	}
	
}
