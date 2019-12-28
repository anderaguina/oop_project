package project;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	public void writeDetailsToFile(Room[] rooms) throws IOException {
		FileWriter fileWriter = new FileWriter("./database.txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    
	    for (int i = 0; i<rooms.length; i++) {
	    	printWriter.print("roomNumber: " + rooms[i].getRoomNumber());
	    	printWriter.print(", ");
	    	
	    	printWriter.print("currentGuests: " + rooms[i].getCurrentGuests());
	    	printWriter.print(", ");
	    	
	    	printWriter.print("free: " + rooms[i].isFree());
	    	printWriter.print(", ");
	    	
	    	printWriter.print("booker: " + rooms[i].getBooker());
	    	printWriter.print(", ");
	    	
	    	printWriter.println();
	    }
	    printWriter.close();
	}
	
}
