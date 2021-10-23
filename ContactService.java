//Author Name: Jason Gionfriddo

//Date: 09/22/2021

//Course ID: CS-320-T1021 Software Test Automation

//Description: This is the ContactService class that provides the Add, Update, and Delete contact functionality 
//by utilizing an Arraylist as they are re-sizable in Java


package contact.main;
import java.util.ArrayList;

public class ContactService {
	
	//array for storing contacts
	public static ArrayList<Contact> contactList = new ArrayList<>();
	
	//method to add contact
	public void addContact(String id, String firstName, String lastName, String phone, String address) {
		
		// constructor from Contact.java
		Contact newContact = new Contact(id, firstName, lastName, phone, address);
		
		// append to contactList
		contactList.add(newContact);
	}
	
	//method to delete contact
	public void deleteContact(String id) {
		
		// make sure there is a list to be checked
		if(contactList.size() == 0) {
			throw new Error("There are no contacts in the list!");
		}
		
		//for loop to search for id
		for (int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getId().equals(id)) {
				contactList.remove(i);
				
				return;
			}
		}
		
		// error for non-existent id
		throw new Error("Id not found");
	}
	
	//method to update contact
	public void updateContact(String id, String firstName, String lastName, String phone, String address) {
		
		// make sure there is a list to be checked
		if(contactList.size() == 0) {
			throw new Error("There are no contacts in the lsit!");
		}
		
		//for loop to find the contact by id
		for (int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getId().equals(id)) {
				
				contactList.get(i).setFirstName(firstName);
				contactList.get(i).setLastName(lastName);
				contactList.get(i).setPhone(phone);
				contactList.get(i).setAddress(address);
				
				return;
			}
		}
		
		//error for non-existent contact
		throw new Error("Id not found");
	}

}
