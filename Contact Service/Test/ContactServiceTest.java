//Author Name: Jason Gionfriddo

//Description: This is the ContactService test file that validates the add, update, and delete functionality 
// of the ContactService class

package Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import contact.main.ContactService;

class ContactServiceTest {

	// contact service only adds contacts with unique id
	@Test
	void testAddContact() {
		ContactService contacts = new ContactService();
		
		// Successfully add new contact
		contacts.addContact("1234567890", "Jane", "Doe", "9523814409", "123 Elm Street");
		
		//Testing for duplicate ID error.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		contacts.addContact("1234567890", "Jane", "Doe", "9523814409", "123 Elm Street");
			});
	}
	
	// test for the ability to update contact
	@Test
	void testUpdateContact() {
		ContactService contacts = new ContactService();
		
		// test for empty list
		Assertions.assertThrows(Error.class, () -> {
			contacts.updateContact("0", "Jane", "Doe", "9523814409", "123 Elm Street");
		});
		
		// add the contact to be updated
		contacts.addContact("1", "Jane", "Doe", "9523814409", "123 Elm Street");
		
		// update contact
		contacts.updateContact("1", "newFirst", "newLast", "1234567890", "New Address");
		
		// check for non-existent id
		Assertions.assertThrows(Error.class, () -> {
			contacts.updateContact("7", "Jane", "newLast", "1234567890", "New Address");
		});
		
	}
	
	// test for ability to delete contact
	@Test
	void testDeleteContact() {
		ContactService contacts = new ContactService();
		
		// test for empty list
		Assertions.assertThrows(Error.class, () -> {
			contacts.deleteContact("2");
		});
		
		// add the contact to be deleted
		contacts.addContact("1", "Jane", "Doe", "9523814409", "123 Elm Street");
		
		// test to ensure non-existent contact can not be deleted
		Assertions.assertThrows(Error.class, () -> {
			contacts.deleteContact("6");
		});
				
		// successfully delete contact
		contacts.deleteContact("1");
				
	}

}
