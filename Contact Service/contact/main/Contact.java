//Author Name: Jason Gionfriddo

//Date: 09/22/2021

//Course ID: CS-320-T1021 Software Test Automation

//Description: This is the Contact class that ensures all new contacts meet the requirements for id, first name, last name, phone, and address 


package contact.main;

public class Contact {
	
	// id variable is final, blank, and initialized in the constructor
	// prevents it form being changed
	private final String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//Contact Constructor
	public Contact(String idNum, String firstName, String lastName, String phone, String address) {
		//idNum validation per requirements
		if (idNum == null || idNum.length() > 10 || idNum.length() < 1) {
			throw new IllegalArgumentException("ID is invalid!");
		}
		
		// ensures id is unique and not in contactService contactList
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getId().equals(idNum)) {
				throw new IllegalArgumentException("Id already taken!");
			}
		}
		id = idNum;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhone(phone);
		this.setAddress(address);
	}
	
	
	//section for all setters. No setter for id variable
	public void setFirstName(String firstName) {
		// validates firstName per requirements
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name is invalid!");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		// validates last name per requirements
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name is invalid!");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		//check to ensure phone is exactly 10 digits
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Phone number must be 10 digits");
		}
		this.phone = phone;
	}
	public void setAddress(String address) {
		// validates address per requirements
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address is invalid");
		}
		this.address = address;
	}
	
	//section for all getters
	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	
	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}


}
