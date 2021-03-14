package com.pi.demo.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


@RestController
@RequestMapping("/appointment")
public class AppointmentController implements Serializable {
	
	@Autowired
	AppointmentService appointmentService;
	
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
	
	@PutMapping("/confirm/{id}")
	public Appointment confirmAppointment(@PathVariable long id) {
		Appointment app = appointmentService.findAppointmentById(id);
		return appointmentService.confirm(app);
	}
	
	@PutMapping("/decline/{id}")
	public Appointment declineAppointment(@PathVariable long id) {
		Appointment app = appointmentService.findAppointmentById(id);
		return appointmentService.deny(app);
	}

}
