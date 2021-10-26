//Author Name: Jason Gionfriddo

//Description: This is the Appointment class that ensures all new appointments meet the requirements 
//for a valid id, date, and description
package appointements.main;

import java.util.Date;
import java.util.Calendar;

public class Appointment {
	
	private final String id;
	private String description;
	private Date appointment;
	
	// appointment constructor uses Integer class in order to test for null input.
	// primitive int defaults to 0 which could be interpreted as January, or first index
	public Appointment(String idNum, Integer month, Integer day, Integer year, String description) {
		
		// id validation per requirements
		if(idNum == null || idNum.length() > 10) {
			throw new IllegalArgumentException("Id is invalid");
		}
		// ensure id is unique
		for(int i = 0; i < AppointmentService.appointmentList.size(); i++) {
			if(AppointmentService.appointmentList.get(i).getId().equals(idNum)) {
				throw new IllegalArgumentException("Id is already taken!");
			}
		}
		
		if(month == null ||  day == null || year == null) {
			throw new IllegalArgumentException("Month, Day, and Year required!");
		}
		
		// date validation
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		// broken down into month, day, year for the purpose of passing only these arguments to the constructor
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DATE, day);
		c.set(Calendar.YEAR, year);
		// load them into a Date object
		Date newDate = c.getTime();
		
		if(!currentDate.before(newDate)) {
			throw new IllegalArgumentException("Date is in the past!");
		}
		
		// idNum is passed to final int id here to prevent updating it later
		id = idNum;
		setAppointment(newDate);
		setDescription(description);
	}
	
	
	// section for all the getters
	public String getId() {
		return id;
	}

	public Date getAppointment() {
		return appointment;
	}
	
	public String getDescription() {
		return description;
	}

	
	// section for all of the setters
	public void setAppointment(Date appointment) {
		this.appointment = appointment;
	}
	
	public void setDescription(String description) {
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description is invalid");
		}
		this.description = description;
	}

}
