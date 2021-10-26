//Author Name: Jason Gionfriddo

//Description: This is the AppointmentTest file that validates all new appointments are created with 
//the appropriate values for id, month, day, year and description.
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import appointements.main.Appointment;
import java.util.Date;

class AppointmentTest {

	@Test
	void testAppointment() {
		Appointment testAppointment = new Appointment("1234567890",8, 5, 2022, "Make this thing happen");

		assertTrue(testAppointment.getId().equals("1234567890"));
		assertTrue(testAppointment.getAppointment().getMonth() == 8);
		assertTrue(testAppointment.getAppointment().getDate() == 05);
		assertTrue(testAppointment.getAppointment().getYear() + 1900 == 2022);
		assertTrue(testAppointment.getDescription().equals("Make this thing happen"));
	}
	
	@Test
	void testNullId() {
		
		// Testing null input for id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, 8, 5, 2022, "This should throw an exception");
		});
	}
	
	@Test
	void testLongId() {
		
		// testing too long Id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678901", 8, 5, 2022, "This id is 11 char, should throw an exception");
		});
	}
	
	@Test
	void testDateInThePast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", 5, 8, 2021, "This date is in the past, should throw an exception");
		});
	}
	
	@Test
	void testNullMonth() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", null, 8, 2021, "The month is null, should throw an exception");
		});
	}
	
	@Test
	void testNullDay() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", 5, null, 2021, "The day is null, should throw an exception");
		});
	}
	
	@Test
	void testNullYear() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", 5, 8, null, "The year is null, should throw an exception");
		});
	}
	
	@Test
	void testAllDateFeildsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", null, null, null, "This date fields are all null, should throw an exception");
		});
	}
	
	@Test
	// testing for a null description
	void testNullDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", 5, 8, 2022, null);
		});
	}
	
	@Test
	void testLongDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", 5, 8, 2022, "This description is over 50 caharacters and should throw an exception");
		});
	}

}
