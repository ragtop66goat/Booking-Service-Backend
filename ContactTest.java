//Author Name: Jason Gionfriddo

//Date: 09/22/2021

//Course ID: CS-320-T1021 Software Test Automation

//Description: This is the Contact test file that validates that the Contacts class abides by the 
//requirements for the creation of contacts to be added to the ContactServices class 


package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.main.Contact;

class ContactTest {

	// valid contact creation
	@Test
	void testContact() {
		Contact testContact = new Contact("1234567890", "Jane", "Doe", "9523814409", "123 Elm Street");
		assertTrue(testContact.getId().equals("1234567890"));
		assertTrue(testContact.getFirstName().equals("Jane"));
		assertTrue(testContact.getLastName().equals("Doe"));
		assertTrue(testContact.getPhone().equals("9523814409"));
		assertTrue(testContact.getAddress().equals("123 Elm Street"));
	}

@Test
void testNullID() {
	
	//Testing null input for ID.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Contact(null, "Jane", "Doe", "9523814409", "123 Elm Street");
		});
}

@Test
void testLongID() {
	
	//Testing with invalid length of characters for ID.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Contact("12345678901", "Jane", "Doe", "9523814409", "123 Elm Street");
		});
	
	}

@Test
void testNullFirstName() {
	
	//Testing null input for firstName.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Contact("1234567890", null, "Doe", "9523814409", "123 Elm Street");
		});
}

@Test
void testLongFirstName() {
	
	//Testing with invalid length of characters for firstName.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Contact("1234567890", "JaneJaneJane", "Doe", "9523814409", "123 Elm Street");
		});
	
	}

@Test
void testNullLastName() {
	
	//Testing null input for lastName.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Contact("1234567890", "Jane", null, "9523814409", "123 Elm Street");
		});
}

@Test
void testLongLastName() {
	
	//Testing with invalid length of characters for lastName.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Contact("1234567890", "Jane", "DoeDoeDoeDoe", "9523814409", "123 Elm Street");
		});
	
	}

@Test
void testNullPhone() {
	
	//Testing null input for phone.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Contact("1234567890", "Jane", "Doe", null, "123 Elm Street");
		});
}

@Test
void testLongPhone() {
	
	//Testing with invalid length of characters for ID.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Contact("1234567890", "Jane", "Doe", "95238144096", "123 Elm Street");
		});
	
	}

@Test
void testShortPhone() {
	
	//Testing with invalid length of characters for ID.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Contact("1234567890", "JaneJaneJane", "Doe", "952381440", "123 Elm Street");
		});
	
	}


@Test
void testNullAddress() {
	
	//Testing null input for address.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Contact("1234567890", "Jane", "Doe", "9523814409", null);
		});
}

@Test
void testLongAddress() {
	
	//Testing with invalid length of characters for ID.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Contact("1234567890", "Jane", "Doe", "9523814409", "123 Elm Street 123 Elm Street11");
		});
	
}

}
