package project;

public class Room {
	private int roomNumber;
	private double ratePerPerson;
	private boolean free;
	private int maxGuests;
	private int currentGuests;
	private String booker;

	// Constructor with fields
	public Room(int roomNumber, double ratePerPerson, boolean free, int maxGuests, int currentGuests, String booker) {
		this.roomNumber = roomNumber;
		this.ratePerPerson = ratePerPerson;
		this.free = free;
		this.maxGuests = maxGuests;
		this.currentGuests = currentGuests;
		this.booker = booker;
	}
	
	// Check which rooms are free
	public boolean isFree() {
		return free;
	}
	
	// Toggle the status of the room
	public void toggleFree() {
		free = !free;
	}
	
	// Check if room is big enough
	public boolean bigEnough(int numGuests) {
		return maxGuests >= numGuests;
	}

	@Override
	public String toString() {
		return "Room [ratePerPerson=" + ratePerPerson + ", free=" + free + ", maxGuests=" + maxGuests
				+ ", currentGuests=" + currentGuests + ", booker=" + booker + "]";
	}
	
	// Print the to string return value
	public void print() {
		System.out.println(toString());
	};
	
	// GETTERS/SETTERS
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public double getRatePerPerson() {
		return ratePerPerson;
	}
	
	public void setRatePerPerson(double ratePerPerson) {
		this.ratePerPerson = ratePerPerson;
	}
	
	public int getMaxGuests() {
		return maxGuests;
	}
	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}
	public int getCurrentGuests() {
		return currentGuests;
	}
	public void setCurrentGuests(int currentGuests) {
		this.currentGuests = currentGuests;
	}
	public String getBooker() {
		return booker;
	}
	public void setBooker(String booker) {
		this.booker = booker;
	}
	
}
