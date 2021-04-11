package com.pi.demo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pi.demo.model.Appointment;
import com.pi.demo.services.AppointmentService;

//////
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;
//////

@RestController
@RequestMapping("/appointment")
public class AppointmentController implements Serializable {
	
	@Autowired
	AppointmentService appointmentService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	//////
//	private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
//    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//    private static final String TOKENS_DIRECTORY_PATH = "tokens";
//
//    /**
//     * Global instance of the scopes required by this quickstart.
//     * If modifying these scopes, delete your previously saved tokens/ folder.
//     */
//    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_READONLY);
//    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
//
//    /**
//     * Creates an authorized Credential object.
//     * @param HTTP_TRANSPORT The network HTTP Transport.
//     * @return An authorized Credential object.
//     * @throws Exception 
//     */
//    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws Exception {
//        // Load client secrets.
//        InputStream in = AppointmentController.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
//        if (in == null) {
//            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
//        }
//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
//                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
//                .setAccessType("offline")
//                .build();
//        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
//        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
//    }
	//////
	
//	@ResponseBody
//	@GetMapping("/test")
//	public Appointment test() {
//		Appointment app = new Appointment(1,null,"address",true,null,null);
//		return app;
//	}
	
	@GetMapping("/")
	public List<Appointment> getAllAppointments() {
		return appointmentService.findAll();
	}
	
	@GetMapping("/{id}")
	public Appointment getAppointmentById(@PathVariable long id) {
		Appointment app = appointmentService.findAppointmentById(id);
		return app;
	}
	
	@PostMapping("/add")
	public Appointment addAppointment(@RequestBody Appointment app) {
		final SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("amjedbouallegui@gmail.com");
		message.setTo("mohamedamjed.bouallegui@esprit.tn");
		message.setText("Good morning, you have an appointment !");
		javaMailSender.send(message);
		return appointmentService.add(app);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAppointment(@PathVariable long id) {
		appointmentService.deleteById(id);
	}
	
	@PutMapping("/edit")
	public Appointment editAppointment(@RequestBody Appointment app) {
		appointmentService.findAppointmentById(app.getId());
		return appointmentService.edit(app);
	}
	
	@PostMapping("/confirm/{id}") //switch
	public Appointment confirmAppointment(@PathVariable long id) throws Exception {
		///////
//		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//		Event event = new Event();
		///////
		
		Appointment app = appointmentService.findAppointmentById(id);
		
		///////
//		DateTime strt = new DateTime(app.getDateAppointment().getTime()); 
//		EventDateTime start = new EventDateTime().setDateTime(strt);
//		event.setStart(start);
//		
//		DateTime ennd = new DateTime(app.getDateAppointment().getTime());
//		EventDateTime end = new EventDateTime().setDateTime(ennd);
//		event.setEnd(end);
//		
//		EventAttendee[] attendees = new EventAttendee[] {
//			    new EventAttendee().setEmail("amjedbouallegui@gmail.com"),
//			    new EventAttendee().setEmail("mohamedamjed.bouallegui@esprit.tn"),
//			};
//		
//		event.setAttendees(Arrays.asList(attendees));
//		
//		String calendarId = "pi-calendar-1617115653450";
//		event = service.events().insert(calendarId, event).execute();
		///////
		
		return appointmentService.confirm(app);
	}
	
	@PutMapping("/decline/{id}") //switch
	public Appointment declineAppointment(@PathVariable long id) {
		Appointment app = appointmentService.findAppointmentById(id);
		return appointmentService.deny(app);
	}
	
	@GetMapping("/count")
	public long countAppointments() {
		return appointmentService.countAppointments();
	}
	
	

}
