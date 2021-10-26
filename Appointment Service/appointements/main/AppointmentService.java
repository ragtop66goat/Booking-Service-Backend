//Author Name: Jason Gionfriddo

//Description: This is the AppointmentService class that ensures all new appointments meet the requirements 
//for a valid id, date, and description
package appointements.main;

import java.util.ArrayList;


public class AppointmentService {
 
	// ArrayList for storing appointments
	public static ArrayList<Appointment> appointmentList = new ArrayList<>();
	
	// method to add appointment Used integer class in order to test for null input
	public void addAppointment(String id, Integer month, Integer day, Integer year, String description ) {
		
		// constructor for new appointment from appointment.java
		Appointment newApointment = new Appointment(id, month, day, year, description);
		
		// add the new appointment to the array
		appointmentList.add(newApointment);
	}
	
	//method to delete an appointment
	public void deleteAppointment(String id) {
		
		// check for empty appointment list
		if( appointmentList.size() == 0) {
			throw new Error("There are no appointments to delete");
		}
		
		// find appointment by id and remove it
		for(int i = 0; i <appointmentList.size(); i++) {
			if(appointmentList.get(i).getId().equals(id)) {
				appointmentList.remove(i);
				
				return;
			}
			
		}
		
		// error if appointment not found
		throw new Error("Appiontment not in the list!");
	}
}
