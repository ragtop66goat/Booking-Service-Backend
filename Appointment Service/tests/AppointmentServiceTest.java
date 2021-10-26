//Author Name: Jason Gionfriddo

//Date: 10/02/2021

//Course ID: CS-320-T1021 Software Test Automation

//Description: This is the AppointmentServiceTest file  that validates functionality in terms of 
// adding and deleting appointments
package tests;

import org.junit.jupiter.api.Assertions;

import appointements.main.AppointmentService;

import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	@Test
	void testDeleteAppointment() {
		AppointmentService appointments = new AppointmentService();
		
		// successfully add new appointment
		appointments.addAppointment("1234567890", 5, 8, 2022, "This is great");
		
		// delete the appointment
		appointments.deleteAppointment("1234567890");
		
		// ensure that a non-existent appointment throws an error
		Assertions.assertThrows(Error.class, () -> {
			appointments.deleteAppointment("1234567890");
		});
	}
	
	@Test
	void testAddAppointment() {
		AppointmentService appointments = new AppointmentService();
		
		// successfully add new appointment
		appointments.addAppointment("1234567890", 5, 8, 2022, "This is great");
		
		// test for duplicate id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointments.addAppointment("1234567890", 5, 8, 2022, "This is a duplicate");
		});
		
		// delete the appointment
		appointments.deleteAppointment("1234567890");
	}

}
