package project;

public class Guest {
	private String name;
	private String email;
	private String address;
	private String phoneNumber;
	private String type;
	
	@Override
	public String toString() {
		return "Guest [name=" + name + ", email=" + email + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", type=" + type + "]";
	}
	
	// Print the to string return value
	public void print() {
		System.out.println(toString());
	}
	
	
	// GETTERS/SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
