package patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarShould {

   @Test
   void allowEntryOfAnAppointment() {
      ClinicCalendar calendar = new ClinicCalendar();
      calendar.addAppointment("Jim", "Weaver", "avery",
         "09/01/2018 2:00 pm");
      List<PatientAppointment> appointments = calendar.getAppointments();
      assertNotNull(appointments);
      assertEquals(1, appointments.size());
      PatientAppointment enteredApt = appointments.get(0);
      assertEquals("Jim", enteredApt.getPatientFirstName());
      assertEquals("Weaver", enteredApt.getPatientLastName());
      assertEquals(Doctor.avery, enteredApt.getDoctor());
      assertEquals("9/1/2018 02:00 PM",
         enteredApt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a", Locale.US)));
   }

}