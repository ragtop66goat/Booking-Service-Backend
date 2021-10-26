package appointements.main;
import java.util.Calendar;

import appointements.main.*;

public class Driver {

	public static void main(String[] args) {
		Appointment testAppointment = new Appointment("123", 8, 5, 2022, "Get this going");
		
		
		System.out.println(testAppointment.getAppointment().getMonth());
		System.out.println(testAppointment.getAppointment().getDate());
		System.out.println(testAppointment.getAppointment().getYear());

	}

}
