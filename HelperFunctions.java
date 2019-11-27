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
	
	public void getGuests(Room[] rooms) {
		
		for (int i=0; i<NUM_ROOMS; i++) {
			if (!rooms[i].isFree()) {
				System.out.println("Guest in room "+i+" is "+rooms[i].getBooker());
			}
		}
	}
	
}
